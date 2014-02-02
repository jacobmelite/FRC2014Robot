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
public class DrivetrainDriveDistanceCommand extends Command {

    int distance;
    double tolerance = .03;

    public DrivetrainDriveDistanceCommand(int distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(Robot.drivetrain);
        this.distance = distance;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.drivetrain.driveDistance(distance);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //returns true if the encoders are within <tolerance> percent of the setpoint
        return Robot.drivetrain.getCurrentLeftEncoderDistance() < Robot.drivetrain.getLeftSetpoint() * 1 + tolerance
                && Robot.drivetrain.getCurrentLeftEncoderDistance() > Robot.drivetrain.getLeftSetpoint() * 1 - tolerance
                && Robot.drivetrain.getCurrentRightEncoderDistance() < Robot.drivetrain.getRightSetpoint() * 1 + tolerance
                && Robot.drivetrain.getCurrentRightEncoderDistance() > Robot.drivetrain.getRightSetpoint() * 1 - tolerance;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.disableBrake();//disables PID controllers
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        Robot.drivetrain.disableBrake();//disables PID controllers
    }
}
