package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;
//import frc.robot.commands.Kicker.KickerForward;

public class Kicker extends Subsystem implements ISubsystem {

    private static Kicker instance = new Kicker();

    /**
     * @return A new instance of the Kicker
     */
    public static Kicker getInstance() {
        return instance;
    }
 
    private TalonSRX k_Motor;
    boolean kickerIsRunning;


    public Kicker() {
        k_Motor = new TalonSRX(RobotMap.KICKER);
        resetSubsystem();
    }


    public void toggleKicker(double speed) {
        k_Motor.set(ControlMode.PercentOutput, 0);
        if (speed == 0) {
            kickerIsRunning = false;
        } else {
            kickerIsRunning = true;
        }
    }

    public void KickerForward(double speed) {
        kickerIsRunning = !kickerIsRunning;
        if (kickerIsRunning) {
            k_Motor.set(ControlMode.PercentOutput, speed);
        } else {
            k_Motor.set(ControlMode.PercentOutput, 0);
        }
    }

    public void stopKicker() {
        kickerIsRunning = false;
        k_Motor.set(ControlMode.PercentOutput, 0);
    }
    // private boolean kickerExtending = false;
    // private boolean kickerDirection;

    // public boolean kickerExtending() {
    //     return kickerExtending;
    // }
    
    // private boolean kickerRetracting = false;

    // public boolean kickerRetracting() {
    //     return kickerRetracting;
    // }

    // public Kicker() {
    //     kickerMotor = new TalonSRX(RobotMap.KICKER);
    //     resetData();
    //     kickerMotor.setInverted(false);

    // }

    // public void resetData()
    // {
    //     kickerRetracting = false;
    //     setUsage ( false );
    //     setDirection ( true  );
    // }

    // public void forwardKicker(double speed) {
    //     if (kickerRetracting == false) {
    //         kickerExtending = true;
    //         kickerMotor.set(ControlMode.PercentOutput, speed);
    //     } else {
    //         kickerExtending = false;
    //     }

    // }
    
    // public boolean isInUse (){
    //     return kickerExtending;
    // }

    // public void setUsage ( boolean kflag) {
    //     kickerExtending = kflag;

    // }


    // public void setDirection ( boolean kIsExtending ) 
    // {
    //     kickerDirection = kIsExtending;
    // }

    // public boolean getDirection()
    // {
    //     return kickerDirection;
    // }

    //  public void reverseKicker(double speed) {
    //     if (kickerExtending == false) {
    //         kickerRetracting = true;
    //         kickerMotor.set(ControlMode.PercentOutput, speed);
    //     } else {
    //         kickerRetracting = false;
    //     }

    // }

    // public void stopKicker() {
    //     kickerExtending = false;
    //     kickerRetracting = false;
    //     kickerMotor.set(ControlMode.PercentOutput, 0);
    // }

    private void configureMotorControllers() {
        k_Motor.setInverted(true);
        k_Motor.setNeutralMode(NeutralMode.Brake);
    }
    @Override
    public void outputSmartdashboard() {
        SmartDashboard.putBoolean("Kicker On", kickerIsRunning);
       // SmartDashboard.putBoolean("Kicker Extending", kickerExtending);
        //SmartDashboard.putBoolean("Kicker Retracting", kickerRetracting);
    }

    @Override
    public void initDefaultCommand() {
      // Set the default command for a subsystem here.
      // setDefaultCommand(new MySpecialCommand());
      //setDefaultCommand(new KickerForward());
    }

    @Override
    public void resetSubsystem() {
        stopKicker();
        configureMotorControllers();
        //stopKicker();
        zeroSensors();
        
    }
    @Override
    public void zeroSensors() {
 
    }
    @Override
    public void testSubsystem() {
  
    }

}