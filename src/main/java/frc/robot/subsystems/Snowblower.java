package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import frc.robot.commands.Snowblower.SnowblowerForward;
/*
public class Snowblower extends Subsystem implements ISubsystem{

    private static Snowblower instance = new Snowblower();

         

    public static Snowblower getInstance() {
            return instance;
      }

     private TalonSRX snowblowerMotor;

     private boolean spiningForward = false;

     public boolean spiningForward() {
        return spiningForward;
    }

    private boolean spinningBackward = false;

    public boolean spinningBackward() {
        return spinningBackward;
    }

    public void snowblowerForward(double speed){
        if (spinningBackward == false) {
            spiningForward = true;
            snowblowerMotor.setInverted(false);
            snowblowerMotor.set(ControlMode.PercentOutput, speed);
        } 
        
        else {
            spiningForward = false;
        }
    }

    public void snowblowerBackward(double speed) {
        if (spiningForward == false) {
            spinningBackward = true;
            snowblowerMotor.setInverted(false);
            snowblowerMotor.set(ControlMode.PercentOutput, speed);
        } else {
            spinningBackward = false;
            snowblowerMotor.setInverted(true);
        }

    }

    public void stopSnowblower() {
        spinningBackward = false;
        spiningForward = false;
        snowblowerMotor.set(ControlMode.PercentOutput, 0);
        snowblowerMotor.setInverted(false);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new SnowblowerForward());
    }

    @Override
    public void outputSmartdashboard() {
        SmartDashboard.putBoolean("Snowblower Spinning", spiningForward);
        SmartDashboard.putBoolean("Snowblower Reversing", spinningBackward);

    }

    @Override
    public void zeroSensors() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resetSubsystem() {
        stopSnowblower();
        zeroSensors();
    }

    @Override
    public void testSubsystem() {
        // TODO Auto-generated method stub

    }




    
}
*/