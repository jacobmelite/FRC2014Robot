package org.usfirst.frc20.LaunchPad.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc20.LaunchPad.subsystems.CatcherPanel;

/**
 *
 * @author Jacob Melite
 */
public class CatcherPanelBloomOrWiltCommand extends Command {
    CatcherPanel catcherpanel;
    public CatcherPanelBloomOrWiltCommand(CatcherPanel catcherpanel) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catcherpanel);
        this.catcherpanel = catcherpanel;
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(catcherpanel.isBloomed()){
            new CatcherPanelWiltCommand(catcherpanel).start();
        }else{
            new CatcherPanelBloomCommand(catcherpanel).start();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(catcherpanel.isBloomed()){
            new CatcherPanelWiltCommand(catcherpanel).start();
        }else{
            new CatcherPanelBloomCommand(catcherpanel).start();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
