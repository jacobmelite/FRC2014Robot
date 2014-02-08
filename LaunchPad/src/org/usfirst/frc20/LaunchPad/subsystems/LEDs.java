package org.usfirst.frc20.LaunchPad.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * @author Jacob Melite
 */
public class LEDs extends Subsystem {

    DigitalOutput ones;
    DigitalOutput twos;
    DigitalOutput fours;
    int state;

    protected void initDefaultCommand() {
        //throw new java.lang.UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mode(int mode) {
        if (mode > 7 || mode < 0) {
            return;
        }
        state = mode;
        switch (mode) {
            case 0:
                setOutputs(false, false, false);
                break;
            case 1:
                setOutputs(false, false, true);
                break;
            case 2:
                setOutputs(false, true, false);
                break;
            case 3:
                setOutputs(false, true, true);
                break;
            case 4:
                setOutputs(true, false, false);
                break;
            case 5:
                setOutputs(true, false, true);
                break;
            case 6:
                setOutputs(true, true, false);
                break;
            case 7:
                setOutputs(true, true, true);
                break;
        }
    }

    public void setOutputs(boolean four, boolean two, boolean one) {
        ones.set(one);
        twos.set(two);
        fours.set(four);
    }
    
    public int getMode(){
        return state;
    }
}