package org.usfirst.frc20.LaunchPad.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc20.LaunchPad.commands.DrivetrainGearboxShiftHighCommand;

/**
 * @author Jacob Melite
 */
public class DrivetrainGearbox extends Subsystem {

    private final DoubleSolenoid shifter;

    public DrivetrainGearbox(int moduleNumber, int shifterForwardChannel, int shifterReverseChannel) {
        shifter = new DoubleSolenoid(moduleNumber, shifterForwardChannel, shifterReverseChannel);
    }

    /**
     * sets the doublesolenoid to kForward
     */
    public void highGear() {
        shifter.set(DoubleSolenoid.Value.kForward);
    }

    /**
     * sets the doublesolenoid to kReverse
     */
    public void lowGear() {
        shifter.set(DoubleSolenoid.Value.kReverse);
    }

    /**
     * 
     * @return true if doulesolenoid is kForward
     */
    public boolean isInHigh() {
        return shifter.get().equals(DoubleSolenoid.Value.kForward);
    }

    /**
     * 
     * @return true if doublesolenoid is kReverse
     */
    public boolean isInLow() {
        return shifter.get().equals(DoubleSolenoid.Value.kReverse);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new DrivetrainGearboxShiftHighCommand());//sets the default command to high gear
    }

}