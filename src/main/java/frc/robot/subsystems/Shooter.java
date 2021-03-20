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

    private CANSparkMax sMotor;
    private CANEncoder sEncoder;

    private boolean shooterIsRunning = false;

    // private boolean shooterIsRunning(){
    //     return shooterIsRunning;
    // }
    // private void setShooter ( boolean bInUse )
    // {
    //     shooterIsRunning = bInUse;
    // }
    // private void toggleShooter() 
    // {
    //     shooterIsRunning = !shooterIsRunning;
    // }

    public Shooter() {
        sMotor = new CANSparkMax(RobotMap.SHOOTER, MotorType.kBrushless);
        // sMotor = new CANSparkMax(RobotMap.SHOOTER, MotorType.kBrushed);
        sEncoder = sMotor.getEncoder();
        resetSubsystem();
    }

    public double getShooterVelocity() {
        return sEncoder.getVelocity();
    }


    // public void runShooter(double speed) {
    //     sMotor.set(speed);
    //     if (speed == 0) {
    //         shooterIsRunning = false;
    //     }else {
    //         shooterIsRunning = true;
    //     }
    // }

    public void ShooterForward(double speed) {
        // shooterIsRunning = !shooterIsRunning;
        // if (shooterIsRunning){
            shooterIsRunning =true;
            sMotor.set(speed);    
        // } else {
        //     sMotor.set(0);
        // }
    }

    // public void ShooterReverse(double speed){
    //     // shooterIsRunning = !shooterIsRunning;
    //     // if (shooterIsRunning){
    //         sMotor.set(speed);
    //     // } else {
    //     //     sMotor.set(0);
    //     // }
    // }

    public void stopShooter() {
        shooterIsRunning = false;
        sMotor.set(0);
    }


    private void configureMotorControllers() {
        zeroSensors();
        sMotor.setInverted(false);
        sMotor.setIdleMode(IdleMode.kBrake);
    }
    // // public void runShooter(double speed) {
    // //     iMotor.set(speed);
    // //     if (speed == 0.0) {
    // //         shooterIsRunning = false;
    // //     } else {
    // //         shooterIsRunning = true;
    // //     }
    // // }

    // /**
    //  * change the state of the shooter
    //  * If already in action, disable it
    //  * If not running, use the speed
    //  * @param speed  Speed of motor (range: -1.0 to 1.0)
    //  */
    // public void toggleShooter ( double speed )
    // {
    //     shooterIsRunning = !shooterIsRunning;
    //     if (shooterIsRunning)
    //     {
    //         iMotor.set(speed);
    //     }
    //     else 
    //     {
    //         iMotor.set(0);
    //     }
    // }

    // /** @TODO - remove this,replace usage with toggleShooter */
    // public void shooterForward(double speed){
    //     toggleShooter (speed);
    // }

    // /** @TODO - remove this,replace usage with toggleShooter */
    // public void shooterReverse(double speed){
    //     toggleShooter (speed);
    // }
    
    // public void stopShooter(){
    //     shooterIsRunning = false;
    //     iMotor.set(0);
    // }

    // private void configureMotorControllers() {
    //     iMotor.setInverted(false);
    //     iMotor.setIdleMode(IdleMode.kBrake);
    // }

    @Override
    public void outputSmartdashboard() {
        SmartDashboard.putBoolean("Shooter Running", shooterIsRunning);
        SmartDashboard.putNumber("Shooter Encoder", getShooterVelocity());
    }

    @Override
    public void zeroSensors() {
        sEncoder.setPosition(0);
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
