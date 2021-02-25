package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.Robot;

public class Kicker extends Subsystem implements ISubsystem {

    private static Kicker instance = new IntakeSpinner();

    /**
     * @return A new instance of the Kicker
     */
    public static Kicker getInstance() {
        return instance;
    }

    private TalonSRX kickerMotor;

    private boolean kickerExtending = false;

    public boolean kickerExtending() {
        return intakeIsRunning;
    }
    
    private boolean kickerRetracting = false;

    public boolean kickerRetracting() {
        return intakeIsRunning;
    }

    public void forwardKicker(double speed) {
        if (kickerRetracting == false) {
            kickerExtending = true;
            KickerMoter.setInverted(false);
            kickerMotor.set(ControlMode.PercentOutput, kickerSpeed);
        } else {
            kickerExtending = false;
        }

    }
    

     public void reverseKicker(double speed) {
        if (kickerExtending == false) {
            kickerRetracting = true;
            KickerMoter.setInverted(false);
            kickerMotor.set(ControlMode.PercentOutput, kickerSpeed);
        } else {
            kickerRetracting = false;
            KickerMoter.setInverted(true);
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




}