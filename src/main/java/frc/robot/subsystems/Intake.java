package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;


public class Intake extends Subsystem implements ISubsystem {
    private static Intake instance = new Intake();    

    public static Intake getInstance() {
        return instance;
    }

    private CANSparkMax iMotor;
    private CANEncoder iEncoder;

    private boolean intakeIsRunning = false;

    private boolean intakeIsRunning() {
        return intakeIsRunning;
    }

    public Intake() {
        iMotor = new CANSparkMax(RobotMap.INTAKE, MotorType.kBrushless);
        iEncoder = iMotor.getEncoder();
        resetSubsystem();
    }

    public void runIntake(double speed) {
        iMotor.set(speed);
        if (speed == 0) {
            intakeIsRunning = false;
        } else {
            intakeIsRunning = true;
        }
    }

    public void IntakeForward(double speed) {
        intakeIsRunning = !intakeIsRunning;
        if (intakeIsRunning){
            iMotor.set(speed);    
        } else {
            iMotor.set(0);
        }
    }

    public void intakeReverse(double speed){
        intakeIsRunning = !intakeIsRunning;
        if (intakeIsRunning){
            iMotor.set(speed);
        } else {
            iMotor.set(0);
        }
    }

    public void stopIntake() {
        intakeIsRunning = false;
        iMotor.set(0);
    }

    public double getInVelocity() {
        return iEncoder.getVelocity(); //check
    }

    private void configureMotorControllers() {
        iMotor.setInverted(false);
        iMotor.setIdleMode(IdleMode.kBrake);
    }

    @Override
    public void outputSmartdashboard() {
        SmartDashboard.putBoolean("Intake Running", intakeIsRunning);
    }

    @Override
    public void zeroSensors() {
        iEncoder.setPosition(0);
    }
    
    @Override
    public void resetSubsystem() {
        stopIntake();
        zeroSensors();
        configureMotorControllers();
    }

    @Override
    public void testSubsystem() {}

    @Override
    public void initDefaultCommand() {}

}
