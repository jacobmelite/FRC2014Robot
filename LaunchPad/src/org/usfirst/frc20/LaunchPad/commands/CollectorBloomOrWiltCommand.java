package org.usfirst.frc20.LaunchPad.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc20.LaunchPad.Robot;

/**
 * @author Jacob Melite
 */
public class CollectorBloomOrWiltCommand extends Command {
    
    public CollectorBloomOrWiltCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if(Robot.collector.isBloomed()){
            new CollectorWiltCommand().start();
        }
        else{
            new CollectorBloomCommand().start();
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        if(Robot.collector.isBloomed()){
            new CollectorWiltCommand().start();
        }
        else{
            new CollectorBloomCommand().start();
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
