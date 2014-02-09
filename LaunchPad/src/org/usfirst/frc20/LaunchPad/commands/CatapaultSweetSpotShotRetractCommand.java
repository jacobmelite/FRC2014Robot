package org.usfirst.frc20.LaunchPad.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc20.LaunchPad.Robot;

/**
 *@author Jared Gentner
 */
public class  CatapaultSweetSpotShotRetractCommand extends Command {

    public CatapaultSweetSpotShotRetractCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	requires(Robot.catapault);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.catapault.sweetSpotShotRetract();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.catapault.isCatapultDown();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
