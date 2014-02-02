// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc20.LaunchPad.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

       public class source implements PIDOutput {

        Talon m1;
        Talon m2;
        Talon m3;

        source(Talon t1, Talon t2, Talon t3) {
            m1 = t1;
            m2 = t2;
            m3=t3;
        }

        public void pidWrite(double t1) {
            m1.set(t1);
            m2.set(t1);
            m3.set(t1);
        }

    }
       
    Gyro gyro;
    private Talon leftTalon1, leftTalon2, leftTalon3;
    private Talon rightTalon1, rightTalon2, rightTalon3;
   // PIDController leftBrake1, leftBrake2, leftBrake3;
    //PIDController rightBrake1, rightBrake2, rightBrake3;
    PIDController leftBrake,rightBrake, turningController;
    Encoder leftEncoder;
    Encoder rightEncoder;

    final double P = 0, I = 0, D = 0;

    public Drivetrain(int right1, int right2, int right3,
            int left1, int left2, int left3,
            int gyroChannel, int leftEncoderChannelA, int leftEncoderChannelB,
            int rightEncoderChannelA, int rightEncoderChannelB) {

        leftTalon1 = new Talon(left1);
        leftTalon2 = new Talon(left2);
        leftTalon3 = new Talon(left3);

        rightTalon1 = new Talon(right1);
        rightTalon2 = new Talon(right2);
        rightTalon3 = new Talon(right3);

        gyro = new Gyro(gyroChannel);
        gyro.setPIDSourceParameter(PIDSource.PIDSourceParameter.kAngle);
        
        leftEncoder = new Encoder(leftEncoderChannelA, leftEncoderChannelB);
        rightEncoder = new Encoder(rightEncoderChannelA, rightEncoderChannelB);
        //leftEncoder.setDistancePerPulse( );
        //rightEncoder.setDistancePerPulse( );
        leftEncoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kDistance);
        rightEncoder.setPIDSourceParameter(PIDSource.PIDSourceParameter.kDistance);
        
        source leftSource= new source(leftTalon1,leftTalon2,leftTalon3);
        source rightSource = new source(rightTalon1,rightTalon2,rightTalon3);
        leftBrake = new PIDController(P,I,D,leftEncoder,leftSource);
        rightBrake = new PIDController(P,I,D,rightEncoder,rightSource);
        turningController = new PIDController(P,I,D,gyro,leftSource);
       /* leftBrake1 = new PIDController(P, I, D, leftEncoder, leftTalon1);
        leftBrake2 = new PIDController(P, I, D, leftEncoder, leftTalon2);
        leftBrake3 = new PIDController(P, I, D, leftEncoder, leftTalon3);

        rightBrake1 = new PIDController(P, I, D, rightEncoder, rightTalon1);
        rightBrake2 = new PIDController(P, I, D, rightEncoder, rightTalon2);
        rightBrake3 = new PIDController(P, I, D, rightEncoder, rightTalon3);*/
    }

    /**
     *
     * @param magnitude
     * @param diff
     */
    public void driveArcade(double magnitude, double diff) {
        setLeftSpeed(-magnitude + diff);
        setRightSpeed(magnitude + diff);
    }

    public void setRightSpeed(double speed) {
        rightTalon1.set(speed);
        rightTalon2.set(speed);
        rightTalon3.set(speed);
    }

    public void setLeftSpeed(double speed) {
        leftTalon1.set(speed);
        leftTalon2.set(speed);
        leftTalon3.set(speed);
    }
    public double getLeftSpeed(){
        return leftTalon1.get();
    }
    public double getRightSpeed(){
        return rightTalon1.get();
    }
    public double getHeading() {
        return gyro.getAngle();
    }

    public double getAdjustedHeading() {
        return gyro.getAngle() % 360;
    }

    public double getCurrentLeftEncoderDistance(){
        return leftEncoder.getDistance();
    }
    public double getCurrentRightEncoderDistance(){
        return rightEncoder.getDistance();
    }
    public double getLeftSetpoint(){
        return leftBrake.getSetpoint();
    }
    public double getRightSetpoint(){
        return rightBrake.getSetpoint();
    }
    public double getAngleSetpoint(){
        return turningController.getSetpoint();
    }
    public void enableBrake() {
      /*  leftBrake1.enable();
        leftBrake2.enable();
        leftBrake3.enable();
        rightBrake1.enable();
        rightBrake2.enable();
        rightBrake3.enable();*/
        turningController.disable();
        leftBrake.setSetpoint(leftEncoder.getDistance());
        rightBrake.setSetpoint(rightEncoder.getDistance());
        leftBrake.enable();
        rightBrake.enable();
    }

    public void disableBrake() {
      /*  leftBrake1.disable();
        leftBrake2.disable();
        leftBrake3.disable();
        rightBrake1.disable();
        rightBrake2.disable();
        rightBrake3.disable();*/
        leftBrake.disable();
        rightBrake.disable();
    }
    
    
    public void driveDistance(double distance){
        turningController.disable();
        leftBrake.setSetpoint(leftEncoder.getDistance()+distance);
        rightBrake.setSetpoint(rightEncoder.getDistance()+distance);
        leftBrake.enable();
        rightBrake.enable();
    }
    public void driveAngle(double angle){
        leftBrake.disable();
        rightBrake.disable();
        turningController.setSetpoint(getHeading()+angle);
        turningController.enable();
    }
    public void disableTurningController(){
        turningController.disable();
    }
    

    public void initDefaultCommand() {

    }
}
