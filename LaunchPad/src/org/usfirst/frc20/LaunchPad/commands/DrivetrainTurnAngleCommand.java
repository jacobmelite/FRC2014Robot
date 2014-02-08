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
public class DrivetrainTurnAngleCommand extends Command {

    private double angle;
    private double tolerance = .03;

    public DrivetrainTurnAngleCommand(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
        this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drivetrain.driveAngle(angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drivetrain.setRightSpeed(-Robot.drivetrain.getLeftSpeed());//sets the right side to the opposite speed of the left side
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.drivetrain.getHeading() < Robot.drivetrain.getAngleSetpoint() * (1 + tolerance)
                && Robot.drivetrain.getHeading() > Robot.drivetrain.getAngleSetpoint() * (1 - tolerance);
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.disableTurningController();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.drivetrain.disableTurningController();
    }
}
