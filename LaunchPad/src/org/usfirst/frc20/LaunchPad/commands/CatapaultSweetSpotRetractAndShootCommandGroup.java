package org.usfirst.frc20.LaunchPad.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * @author Jacob Melite
 */
public class CatapaultSweetSpotRetractAndShootCommandGroup extends CommandGroup {
    
    public CatapaultSweetSpotRetractAndShootCommandGroup() {
        addSequential(new CatapaultSweetSpotShotRetractCommand());
        addSequential(new CatapaultShootCommand());
    }
}
