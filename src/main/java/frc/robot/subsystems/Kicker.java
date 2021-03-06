package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Kicker.KickerForward;

public class Kicker extends Subsystem implements ISubsystem {

    private static Kicker instance = new Kicker();

    /**
     * @return A new instance of the Kicker
     */
    public static Kicker getInstance() {
        return instance;
    }
 
    private TalonSRX kickerMotor;

    private boolean kickerExtending = false;

    public boolean kickerExtending() {
        return kickerExtending;
    }
    
    private boolean kickerRetracting = false;

    public boolean kickerRetracting() {
        return kickerRetracting;
    }

    public Kicker() {
        super();
    }

    public void forwardKicker(double speed) {
        if (kickerRetracting == false) {
            kickerExtending = true;
            kickerMotor.setInverted(false);
            kickerMotor.set(ControlMode.PercentOutput, speed);
        } else {
            kickerExtending = false;
        }

    }
    

     public void reverseKicker(double speed) {
        if (kickerExtending == false) {
            kickerRetracting = true;
            kickerMotor.setInverted(false);
            kickerMotor.set(ControlMode.PercentOutput, speed);
        } else {
            kickerRetracting = false;
            kickerMotor.setInverted(true);
        }

    }

    public void stopKicker() {
        kickerExtending = false;
        kickerRetracting = false;
        kickerMotor.set(ControlMode.PercentOutput, 0);
        kickerMotor.setInverted(false);
    }

    @Override
    public void outputSmartdashboard() {
        SmartDashboard.putBoolean("Kicker Extending", kickerExtending);
        SmartDashboard.putBoolean("Kicker Retracting", kickerRetracting);

    }

    @Override
    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
      setDefaultCommand(new KickerForward());
    }

    @Override
    public void resetSubsystem() {
        stopKicker();
        zeroSensors();
        
    }
    @Override
    public void zeroSensors() {
 
    }
    @Override
    public void testSubsystem() {
  
    }

}