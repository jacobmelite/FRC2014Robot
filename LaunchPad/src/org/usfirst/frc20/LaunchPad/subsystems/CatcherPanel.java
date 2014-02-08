package org.usfirst.frc20.LaunchPad.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc20.LaunchPad.commands.CatcherPanelOutCommand;

/**
 *@author Jacob Melite
 */
public class CatcherPanel extends Subsystem {

    private DoubleSolenoid doubleSolenoid;

    public CatcherPanel(int moduleNumber, int forwardChannel, int reverseChannel) {
        doubleSolenoid = new DoubleSolenoid(moduleNumber, forwardChannel, reverseChannel);
    }
    protected void initDefaultCommand() {
        //extends catcher panel out as default command
        setDefaultCommand(new CatcherPanelOutCommand(this));
    }
    /**
     * sets the doublesolenoid to kForward
     */
    public void bloom() {
        doubleSolenoid.set(DoubleSolenoid.Value.kOff);
    }
    /**
     * sets the doublesolenoid to kReverse
     */
    public void wilt() {
        doubleSolenoid.set(DoubleSolenoid.Value.kForward);
    }
    /**
     * @return true if the doublesolenoid is kForward
     */
    public boolean isOut() {
        return doubleSolenoid.get().equals(DoubleSolenoid.Value.kOff);
    }
    /**
     * @return true if the doublesolenoid is kReverse
     */
    public boolean isIn(){
        return doubleSolenoid.get().equals(DoubleSolenoid.Value.kForward);
    }
    
}
