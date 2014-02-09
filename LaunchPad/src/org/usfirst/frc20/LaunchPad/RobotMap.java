package org.usfirst.frc20.LaunchPad;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    //TODO: Get channels for EVERYTHING
    //catapault
    //motors
    public static int catapaultMotor1Channel = 1;
    public static int catapaultMotor2Channel = 2;
    //limit switch
    public static int catapaultLimitSwitchChannel = 1;
    //pneumatics
    public static int catapaultPneumaticModule = 2;
    public static int catapaultMotorPneumaticForwardChannel = 1;
    public static int catapaultMotorPneumaticReverseChannel = 2;
    public static int catapaultRatchetPneumaticForwardChannel = 3;
    public static int catapaultRatchetPneumaticReverseChannel = 4;

    //drivetrain
    //right talons
    public static int drivetrainRightTalon1Channel = 1;
    public static int drivetrainRightTalon2Channel = 2;
    public static int drivetrainRightTalon3Channel = 3;
    //left talons
    public static int drivetrainLeftTalon1Channel = 4;
    public static int drivetrainLeftTalon2Channel = 5;
    public static int drivetrainLeftTalon3Channel = 6;
    //pneumatics
    public static int drivetrainGearboxPneumaticModule = 1;
    public static int drivetrainGearboxPneumaticForwardChannel = 1;
    public static int drivetrainGearboxPneumaticReverseChannel = 2;
    //gyro
    public static int drivetrainGyroChannel;
    //right encoder
    public static int drivetrainRightEncoderChannelA;
    public static int drivetrainRightEncoderChannelB;
    //left encoder
    public static int drivetrainLeftEncoderChannelA;
    public static int drivetrainLeftEncoderChannelB;

    //controllers
    public static int logitechDualActionControllerChannel;

    public static int logitechGamepadControllerChannel;

    //compressor channels
    public static int compressorSwitchChannel;
    public static int compressorRelayChannel;

    //catchers
    //left
    public static int leftCatcherPanelModuleNumber;
    public static int leftCatcherPanelForwardChannel;
    public static int leftCatcherPanelReverseChannel;
    //right
    public static int rightCatcherPanelModuleNumber;
    public static int rightCatcherPanelForwardChannel;
    public static int rightCatcherPanelReverseChannel;
    //back
    public static int backCatcherPanelModuleNumber;
    public static int backCatcherPanelForwardChannel;
    public static int backCatcherPanelReverseChannel;

    //collector
    //left doublesolenoid
    public static int collectorSolenoidModuleNumber;
    public static int collectorLeftDoubleSolenoidForwardChannel;
    public static int collectorLeftDoubleSolenoidReverseChannel;
    //right doublesolenoid
    public static int collectorRightDoubleSolenoidModuleNumber;
    public static int collectorRightDoubleSolenoidForwardChannel;
    public static int collectorRightDoubleSolenoidReverseChannel;
    //collector motor
    public static int collectorRollerMotorChannel;

    //LEDs
    //starting mode
    public static int ledsInitialMode=0;
    public static void init() {

    }
}
