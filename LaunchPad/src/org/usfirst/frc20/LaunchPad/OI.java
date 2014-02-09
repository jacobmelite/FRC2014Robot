package org.usfirst.frc20.LaunchPad;

import edu.wpi.first.wpilibj.buttons.Button;
import org.usfirst.frc20.LaunchPad.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    //Controllers
    public LogitechGamepadController logitechGamepadController
            = new LogitechGamepadController(RobotMap.logitechGamepadControllerChannel);
    public LogitechDualActionController logitechDualActionController
            = new LogitechDualActionController(RobotMap.logitechDualActionControllerChannel);

    //Buttons
    public Button driverButtonA = logitechGamepadController.getAButton();
    public Button driverButtonB = logitechGamepadController.getBButton();
    public Button driverButtonX = logitechGamepadController.getXButton();
    public Button driverButtonY = logitechGamepadController.getYButton();
    public Button driverButtonLB = logitechGamepadController.getLeftBumper();
    public Button driverButtonRB = logitechGamepadController.getRightBumper();
    public Button driverButtonBack = logitechGamepadController.getBackButton();
    public Button driverButtonStart = logitechGamepadController.getStartButton();
    public Button operatorButton1 = logitechDualActionController.getButton(1);
    public Button operatorButton2 = logitechDualActionController.getButton(2);
    public Button operatorButton3 = logitechDualActionController.getButton(3);
    public Button operatorButton4 = logitechDualActionController.getButton(4);
    public Button operatorButton5 = logitechDualActionController.getButton(5);
    public Button operatorButton6 = logitechDualActionController.getButton(6);
    public Button operatorButton7 = logitechDualActionController.getButton(7);
    public Button operatorButton8 = logitechDualActionController.getButton(8);
    public Button operatorButton9 = logitechDualActionController.getButton(9);
    public Button operatorButton10 = logitechDualActionController.getButton(10);

    public OI() {
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());

        /*driverButtonA.whenPressed(new BrakeCommand());
         driverButtonB.whenPressed(new CatapaultSweetSpotRetractAndShootCommandGroup());
         driverButtonX.whenPressed(new ArcadeDriveCommand());
        
         driverButtonY.whenPressed(new CollectorExtendOrRetractCommand());//alternates the collector between extended and retracted
         driverButtonRB.whenPressed(new CollectorDriveForwardCommand());
         driverButtonLB.whenPressed(new CollectorDriveBackCommand());
         driverButtonStart.whenPressed(new DrivetrainGearboxShiftHighCommand());
         driverButtonBack.whenPressed(new DrivetrainGearboxShiftLowCommand());*/
        operatorButton1.whenPressed(new CatcherPanelBloomOrWiltCommand(Robot.leftCatcherPanel));
        operatorButton2.whenPressed(new CatcherPanelBloomOrWiltCommand(Robot.backCatcherPanel));
        operatorButton3.whenPressed(new CatcherPanelBloomOrWiltCommand(Robot.rightCatcherPanel));
        
    }

}
