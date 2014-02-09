package org.usfirst.frc20.LaunchPad.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Jared Gentner
 * @author Jacob Melite
 */
public class Drivetrain extends Subsystem {

    /**
     * Used in the PID controllers in this class. Makes it easier to control the
     * controllers and reduces necessary computations by only needing to
     * calculate once, and writing to 3 controllers at once instead of 3
     * separate controllers.
     */
    private class TripleTalonSource implements PIDOutput {

        Talon m1;
        Talon m2;
        Talon m3;

        /**
         * 
         * @param t1 a talon
         * @param t2 a talon on the same side of the bot as t1
         * @param t3 a talon on the same side of the bot as t1
         */
        TripleTalonSource(Talon t1, Talon t2, Talon t3) {
            m1 = t1;
            m2 = t2;
            m3 = t3;
        }

        public void pidWrite(double speed) {
            m1.set(speed);
            m2.set(speed);
            m3.set(speed);
        }

    }

    Gyro gyro;
    
    private Talon leftTalon1, leftTalon2, leftTalon3;
    private Talon rightTalon1, rightTalon2, rightTalon3;
    
    TripleTalonSource leftSource;
    TripleTalonSource rightSource;
    
    PIDController leftBrake, rightBrake;
    
    Encoder leftEncoder;
    Encoder rightEncoder;
    
    //TODO: Load dynamically from file on cRIO
    final double P = 0, I = 0, D = 0;

    public Drivetrain(int right1, int right2, int right3,
            int left1, int left2, int left3,
            int gyroChannel, int leftEncoderChannelA, int leftEncoderChannelB,
            int rightEncoderChannelA, int rightEncoderChannelB) {

        //motor controllers
        leftTalon1 = new Talon(left1);
        leftTalon2 = new Talon(left2);
        leftTalon3 = new Talon(left3);

        rightTalon1 = new Talon(right1);
        rightTalon2 = new Talon(right2);
        rightTalon3 = new Talon(right3);

        //gyro
        gyro = new Gyro(gyroChannel);
        gyro.setPIDSourceParameter(PIDSource.PIDSourceParameter.kAngle);

        //encoders TODO: Find distanceperpulse
        leftEncoder = new Encoder(leftEncoderChannelA, leftEncoderChannelB);
        rightEncoder = new Encoder(rightEncoderChannelA, rightEncoderChannelB);
        
        //double ticksPerRevolution = ;
        //leftEncoder.setDistancePerPulse(4*Math.PI/ticksPerRevolution);
        //rightEncoder.setDistancePerPulse(4*Math.PI/ticksPerRevolution);
        
        leftEncoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kDistance);
        rightEncoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kDistance);

        //PID Controllers
        leftSource = new TripleTalonSource(leftTalon1, leftTalon2, leftTalon3);
        rightSource = new TripleTalonSource(rightTalon1, rightTalon2, rightTalon3);
        
        leftBrake = new PIDController(P, I, D, leftEncoder, leftSource);
        rightBrake = new PIDController(P, I, D, rightEncoder, rightSource);
    }

    /**
     * Drives the right and left motors in arcade drive
     * @param magnitude speed
     * @param diff turning
     */
    public void driveArcade(double magnitude, double diff) {
        setLeftSpeed(-magnitude + diff);
        setRightSpeed(magnitude - diff);
    }

    /**
     * sets the speed of the right talons
     * @param speed a double between -1 and 1
     */
    public void setRightSpeed(double speed) {
        rightTalon1.set(speed);
        rightTalon2.set(speed);
        rightTalon3.set(speed);
    }

    /**
     * sets the speed of the left talons
     * @param speed a double between -1 and 1
     */
    public void setLeftSpeed(double speed) {
        leftTalon1.set(speed);
        leftTalon2.set(speed);
        leftTalon3.set(speed);
    }

    /**
     * @return the speed of leftTalon1
     */
    public double getLeftSpeed() {
        return leftTalon1.get();
    }

    /**
     * @return the speed of rightTalon1
     */
    public double getRightSpeed() {
        return rightTalon1.get();
    }

    /**
     * @return the current angle of the gyro
     */
    public double getHeading() {
        return gyro.getAngle();
    }

    /**
     * @return the angle of the gyro % 360
     */
    public double getAdjustedHeading() {
        return gyro.getAngle() % 360;
    }

    /**
     * @return the distance of the left encoder
     */
    public double getLeftEncoderDistance() {
        return leftEncoder.getDistance();
    }

    /**
     * @return the distance of the right encoder
     */
    public double getRightEncoderDistance() {
        return rightEncoder.getDistance();
    }

    /**
     * @return the current setpoint of <code>leftBrake</code>
     */
    public double getLeftSetpoint() {
        return leftBrake.getSetpoint();
    }

    /**
     * @return the current setpoint of <code>rightBrake</code>
     */
    public double getRightSetpoint() {
        return rightBrake.getSetpoint();
    }

    /**
     * sets the setpoint of left and right brake
     * to their encoder's current distance, enables left and right brake
     * controllers
     */
    public void enableBrake() {
        leftBrake.setSetpoint(leftEncoder.getDistance());
        rightBrake.setSetpoint(rightEncoder.getDistance());
        leftBrake.enable();
        rightBrake.enable();
    }

    /**
     * disables the left and right brake controllers
     */
    public void disableBrake() {
        leftBrake.disable();
        rightBrake.disable();
    }

    /**
     * 
     * @param angle
     */
    public void driveAngle(double angle) {
        //TODO: Write custom controller code
    }

    public void initDefaultCommand() {
        
    }
}
