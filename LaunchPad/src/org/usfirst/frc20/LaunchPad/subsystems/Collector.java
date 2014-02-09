package org.usfirst.frc20.LaunchPad.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc20.LaunchPad.commands.CollectorIdleCommand;

/**
 *@author Jacob Melite
 */
public class Collector extends Subsystem {

    private DoubleSolenoid leftDoubleSolenoid;
    private DoubleSolenoid rightDoubleSolenoid;
    private Talon motor;

    public Collector(int collectorSolenoidModuleNumber,
            int leftDoubleSolenoidForwardChannel,
            int leftDoubleSolenoidReverseChannel,
            int rightDoubleSolenoidForwardChannel,
            int rightDoubleSolenoidReverseChannel,
            int rollerMotorChannel) {
        leftDoubleSolenoid = new DoubleSolenoid(collectorSolenoidModuleNumber,
                leftDoubleSolenoidForwardChannel,
                leftDoubleSolenoidReverseChannel);

        rightDoubleSolenoid = new DoubleSolenoid(collectorSolenoidModuleNumber,
                rightDoubleSolenoidForwardChannel,
                rightDoubleSolenoidReverseChannel);

        motor = new Talon(rollerMotorChannel);

    }

    public void initDefaultCommand() {
        //idles as defualt command
        setDefaultCommand(new CollectorIdleCommand());
    }

    /**
     * sets the right and left doublesolenoids to kReverse
     */
    public void bloomCollector() {
        leftDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);
        rightDoubleSolenoid.set(DoubleSolenoid.Value.kReverse);

    }

    /**
     * sets the right and left doublesolenoids to kForward
     */
    public void wiltCollector() {
        leftDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
        rightDoubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    /**
     * drives the collector forwards (ball goes in)
     */
    public void drive() {
        motor.set(1);
    }
    
    /**
     * drives the collector backwards (ball goes out)
     */
    public void backDrive() {
        motor.set(-1);
    }

    /**
     * sets the motor to 0
     */
    public void stopCollector() {
        motor.set(0);
    }

    /**
     * @return true if the speed is greater than 0 
     */
    public boolean isDrivingForward() {
        return motor.get() > 0;
    }

    /**
     * @return  true if the motor speed equals 0
     */
    public boolean isStopped() {
        return motor.get() == 0;
    }

    /**
     * @return true if the motor speed is below 0
     */
    public boolean isDrivingBackwards() {
        return motor.get() < 0;
    }

    /**
     * @return true if both doublesolenoids have a value of kReverse
     */
    public boolean isBloomed() {
        return leftDoubleSolenoid.get().equals(DoubleSolenoid.Value.kReverse)
                && rightDoubleSolenoid.get().equals(DoubleSolenoid.Value.kReverse);
    }

    /**
     * @return true if both doublesolenoids have a value of kForward
     */
    public boolean isWilted() {
        return leftDoubleSolenoid.get().equals(DoubleSolenoid.Value.kForward)
                && rightDoubleSolenoid.get().equals(DoubleSolenoid.Value.kForward);
    }
}
