package org.usfirst.frc20.LaunchPad.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc20.LaunchPad.Robot;
import org.usfirst.frc20.LaunchPad.subsystems.LEDs;

/**
 *
 * @author Jacob Melite
 */
public class switchLEDMode extends Command{
    int mode;
    public switchLEDMode(int mode) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.leds);
        this.mode = mode;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.leds.setMode(mode);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.leds.setMode(mode);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.leds.getMode()==mode;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
