/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc20.LaunchPad.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc20.LaunchPad.subsystems.CatcherPanel;

/**
 *
 * @author Elfun Gift
 */
public class CatcherPanelInCommand extends Command {

    CatcherPanel catcherPanel;

    public CatcherPanelInCommand(CatcherPanel catcherPanel) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(catcherPanel);
        this.catcherPanel = catcherPanel;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        catcherPanel.in();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        catcherPanel.in();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return catcherPanel.isIn();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
