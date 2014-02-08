package org.usfirst.frc20.LaunchPad.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc20.LaunchPad.Robot;

/**
 *@author Jared Gentner
 */
public class  CatapaultShootCommand extends Command {

    public CatapaultShootCommand() {
	requires(Robot.catapult);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.catapult.shoot();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.catapult.shoot();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
