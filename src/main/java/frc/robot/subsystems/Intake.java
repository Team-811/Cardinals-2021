package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Solenoid;
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
    private Solenoid extendPiston; 

    private boolean intakeIsRunning;


    public Intake() {
        iMotor = new CANSparkMax(RobotMap.INTAKE, MotorType.kBrushless);
        iEncoder = iMotor.getEncoder();

        extendPiston = new Solenoid(RobotMap.INTAKE_PISTON);

        resetSubsystem();
    }

    public void extendIntake() {
        extendPiston.set(true);
    }
    public void retractIntake() {
        extendPiston.set(false);
    }

    public boolean NeuOn() {
        if(extendPiston.get()){
            return true;
        } else {
            return false;
        }
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
            extendIntake();   
        } else {
            iMotor.set(0);
            retractIntake();
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
        retractIntake();
    }


    private void configureMotorControllers() {
        zeroSensors();
        iMotor.setInverted(false);
        iMotor.setIdleMode(IdleMode.kBrake);
        retractIntake();
    }

    @Override
    public void outputSmartdashboard() {
        SmartDashboard.putBoolean("Intake Running", intakeIsRunning);
        SmartDashboard.putBoolean("Neumatics On", NeuOn());
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
