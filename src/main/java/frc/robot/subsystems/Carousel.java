package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Carousel.CarouselForward;

public class Carousel extends Subsystem implements ISubsystem {
    
    private static Carousel instance = new Carousel();
    
    public static Carousel getInstance() {
        return instance;
    }

    private TalonSRX carouselMotor;
    private boolean goingForward = false;
    private boolean goingBackward = false;


    public Carousel() {
        carouselMotor = new TalonSRX(RobotMap.CAROUSEL);
    }
    public boolean carouselForward() {
        return goingForward;
    }

    public boolean carouselBackward() {
        return goingBackward;
    }
    
    public void forwardCarousel(double speed){
        if (goingBackward == false) {
            goingForward = true;
            carouselMotor.setInverted(false);
            carouselMotor.set(ControlMode.PercentOutput, speed);
        } else {
            goingForward = false;
            carouselMotor.setInverted(true);
        }
    }

    public void reverseCarousel(double speed) {
        if (goingForward == false) {
            goingBackward = true;
            carouselMotor.setInverted(false);
            carouselMotor.set(ControlMode.PercentOutput, speed);
        } else {
            goingBackward = false;
            carouselMotor.setInverted(true);
        }
    }
/*
    public void stopCarousel() {
        goingBackward = false;
        goingForward = false;
        carouselMotor.set(ControlMode.PercentOutput, 0);
        carouselMotor.setInverted(false);
    }
*/
    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new CarouselForward());
    }

    @Override
    public void zeroSensors() {
        
    }

    @Override
    public void testSubsystem() {
        
    }

    @Override
    public void outputSmartdashboard() {
        SmartDashboard.putBoolean("Carousel Spinning", goingForward);
        SmartDashboard.putBoolean("Carousel Reversing", goingBackward);
    }

    @Override
    public void resetSubsystem() {
       // stopCarousel();
        zeroSensors();
    }

}