package org.usfirst.frc20.LaunchPad.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc20.LaunchPad.commands.CatapaultIdleCommand;

/**
 * @author Jared Gentner 
 */
public class Catapult extends Subsystem {

    private Gearbox gearbox;
    DigitalInput limitSwitch;

    public Catapult(int motor1Channel,
                    int motor2Channel,
                    int pneumaticModuleNumber,
                    int ratchetForwardChannel,
                    int ratchetReverseChannel,
                    int motorForwardChannel,
                    int motorReverseChannel,
                    int limitSwitchDigitalInput) {
        gearbox = new Gearbox(motor1Channel, motor2Channel, pneumaticModuleNumber, ratchetForwardChannel, ratchetReverseChannel, motorForwardChannel, motorReverseChannel);
        limitSwitch = new DigitalInput(limitSwitchDigitalInput);
    }

    
    public void sweetSpotShotRetract() {
        gearbox.engageMotors();
        gearbox.engageRatchet();
        if (!isCatapultDown()) {
            gearbox.drive();
        } else {
            gearbox.disengageMotors();
            gearbox.stop();
        }
    }

    public void smallSpotShotRetract() {
        gearbox.engageMotors();
        gearbox.engageRatchet();
        if (!isCatapultDown()) {
            gearbox.drive();
        } else {
            gearbox.engageMotors();
            gearbox.stop();
        }
    }

    public void idle() {
        gearbox.stop();
    }

    public void shoot() {
        gearbox.disengageRatchet();
    }

    public boolean isCatapultDown() {
        return limitSwitch.get();
    }

    public void initDefaultCommand() {
        setDefaultCommand(new CatapaultIdleCommand());//idles as default
    }

    private class Gearbox {

        private Talon motor1;
        private Talon motor2;
        private DoubleSolenoid ratchetSolenoid;
        private DoubleSolenoid motorSolenoid;
        private static final double kDirection = 1;

        public Gearbox(int motor1,
                       int motor2,
                       int pneumaticModuleNumber,
                       int ratchetForwardChannel,
                       int ratchetReverseChannel,
                       int motorForwardChannel,
                       int motorReverseChannel) {
            this.motor1 = new Talon(motor1);
            this.motor2 = new Talon(motor2);
            ratchetSolenoid = new DoubleSolenoid(pneumaticModuleNumber, ratchetForwardChannel, ratchetReverseChannel);
            motorSolenoid = new DoubleSolenoid(pneumaticModuleNumber, motorForwardChannel, motorReverseChannel);
        }

        public void drive() {
            motor1.set(kDirection);
            motor2.set(kDirection);
        }

        public void backdrive() {
            motor1.set(-kDirection);
            motor2.set(-kDirection);
        }

        public void stop() {
            motor1.set(0);
            motor2.set(0);
        }

        public void engageRatchet() {
            ratchetSolenoid.set(DoubleSolenoid.Value.kForward);
        }

        public void disengageRatchet() {
            ratchetSolenoid.set(DoubleSolenoid.Value.kReverse);
        }

        public void engageMotors() {
            motorSolenoid.set(DoubleSolenoid.Value.kForward);
        }

        public void disengageMotors() {
            motorSolenoid.set(DoubleSolenoid.Value.kReverse);
        }

        public boolean areMotorsEngaged() {
            return motorSolenoid.get() == DoubleSolenoid.Value.kForward;
        }

        public boolean isRatchetEngaged() {
            return ratchetSolenoid.get() == DoubleSolenoid.Value.kReverse;
        }
    }
}