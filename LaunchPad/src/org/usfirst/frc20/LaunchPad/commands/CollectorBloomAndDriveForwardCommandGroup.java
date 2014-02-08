package org.usfirst.frc20.LaunchPad.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Jacob Melite
 */
public class CollectorBloomAndDriveForwardCommandGroup extends CommandGroup {
    
    public CollectorBloomAndDriveForwardCommandGroup() {
        addSequential(new CollectorDriveForwardCommand());
        addSequential(new CollectorBloomCommand());
    }
}
