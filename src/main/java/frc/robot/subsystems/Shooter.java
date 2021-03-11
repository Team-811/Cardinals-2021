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

    public Shooter() {
        iMotor = new CANSparkMax(RobotMap.SHOOTER, MotorType.kBrushed);
        iEncoder = iMotor.getEncoder();
        resetSubsystem();
    }

    public void runShooter(double speed) {
        iMotor.set(speed);
        if (speed == 0) {
            shooterIsRunning = false;
        } else {
            shooterIsRunning = true;
        }
    }

    public void shooterForward(double speed){
        shooterIsRunning = !shooterIsRunning;
        if (shooterIsRunning){
            iMotor.set(speed);
        }else {
            iMotor.set(0);
        }
    }

    public void shooterReverse(double speed){
        shooterIsRunning = !shooterIsRunning;
        if (shooterIsRunning){
            iMotor.set(-speed);
        }else {
            iMotor.set(0);
        }
    }
    
    public void stopIntake(){
        shooterIsRunning = false;
        iMotor.set(0);
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
    public void testSubsystem() {}

    @Override
    public void initDefaultCommand() {}

}
