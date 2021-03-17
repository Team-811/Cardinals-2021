package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Shooter extends Subsystem implements ISubsystem {

    private static Shooter instance = new Shooter();

    public static Shooter getInstance() {
        return instance;
    }

    private CANSparkMax iMotor;
    private CANEncoder iEncoder;

    private boolean shooterIsRunning = false;

    private boolean shooterIsRunning(){
        return shooterIsRunning;
    }
    private void setShooter ( boolean bInUse )
    {
        shooterIsRunning = bInUse;
    }
    private void toggleShooter ( void )
    {
        shooterIsRunning = !shooterIsRunning;
    }

    public Shooter() {
        iMotor = new CANSparkMax(RobotMap.SHOOTER, MotorType.kBrushed);
        iEncoder = iMotor.getEncoder();
        resetSubsystem();
    }

    // public void runShooter(double speed) {
    //     iMotor.set(speed);
    //     if (speed == 0.0) {
    //         shooterIsRunning = false;
    //     } else {
    //         shooterIsRunning = true;
    //     }
    // }

    /**
     * change the state of the shooter
     * If already in action, disable it
     * If not running, use the speed
     * @param speed  Speed of motor (range: -1.0 to 1.0)
     */
    public void toggleShooter ( double speed )
    {
        shooterIsRunning = !shooterIsRunning;
        if (shooterIsRunning)
        {
            iMotor.set(speed);
        }
        else 
        {
            iMotor.set(0);
        }
    }

    /** @TODO - remove this,replace usage with toggleShooter */
    public void shooterForward(double speed){
        toggleShooter (speed);
    }

    /** @TODO - remove this,replace usage with toggleShooter */
    public void shooterReverse(double speed){
        toggleShooter (speed);
    }
    
    public void stopShooter(){
        shooterIsRunning = false;
        iMotor.set(0);
    }

    private void configureMotorControllers() {
        iMotor.setInverted(false);
        iMotor.setIdleMode(IdleMode.kBrake);
    }

    @Override
    public void outputSmartdashboard() {
        SmartDashboard.putBoolean("Shooter Running", shooterIsRunning);
    }

    @Override
    public void zeroSensors() {
        iEncoder.setPosition(0);
    }

    @Override
    public void resetSubsystem() {
        stopShooter();
        zeroSensors();
        configureMotorControllers();
    }

    @Override
    public void testSubsystem() {}

    @Override
    public void initDefaultCommand() {}

}
