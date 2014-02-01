/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc20.LaunchPad.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc20.LaunchPad.Robot;

/**
 *
 * @author Elfun Gift
 */
public class CollectorDriveBackCommand extends Command {
    
    public CollectorDriveBackCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.collector.driveCollector(-1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.collector.driveCollector(-1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.collector.isDrivingBackwards();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
