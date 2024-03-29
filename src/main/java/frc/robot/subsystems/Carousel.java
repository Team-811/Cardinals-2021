package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Carousel.CarouselForward;
import frc.robot.commands.Carousel.CarosuelBackward;
import frc.robot.commands.Carousel.CarouselStop;


//reverted carousel to the simplest version of itself
public class Carousel extends Subsystem implements ISubsystem {
    
    private static Carousel instance = new Carousel();
    
    public static Carousel getInstance() {
        return instance;
    }

    private TalonSRX carouselMotor;
    private boolean CarouselIsRunning;
    private DigitalInput limitSwitch = new DigitalInput(RobotMap.CAROUSEL_LIMIT_SWITCH);
    public static Boolean limitSwitchOn = false;
    // private boolean bSpinning;      // flag to denote if this is spinning currently
    // private boolean bForward;       // direction of the spin (true if foward, false if reverse)

    public Carousel() {
        carouselMotor = new TalonSRX(RobotMap.CAROUSEL);
        //resetData();
        resetSubsystem();
    } 

    //This says run the carousel at a speed
    public void toggleCarousel(double speed) {
        carouselMotor.set(ControlMode.PercentOutput, 0);
        if (speed == 0){
            CarouselIsRunning = false;
        } else {
            CarouselIsRunning = true;
        }
    }


    public void stopCarousel() {
        CarouselIsRunning = false;
        carouselMotor.set(ControlMode.PercentOutput, 0);
        

        
    }

    public void spinCarousel(double speed) {
        // CarouselIsRunning = !CarouselIsRunning;
        // if (CarouselIsRunning){
        
            //if(limitSwitch.get() == true){
              //  stopCarousel(); 
           // }else {
           // carouselMotor.set(ControlMode.PercentOutput, speed);
            if (speed > 0) {
                if (limitSwitch.get() == false){
                    if (limitSwitchOn){
                        carouselMotor.set(ControlMode.PercentOutput, 0);
                        limitSwitchOn=false;
                        for(int i =0 ; i<1000000; i++){}
                    }else{
                        carouselMotor.set(ControlMode.PercentOutput, speed);
                        limitSwitchOn = true; 
                    }
                
                }
                else if (limitSwitch.get() == true) {
                    carouselMotor.set(ControlMode.PercentOutput, speed);
                    limitSwitchOn = true;
                }
            }
    }
    // public void stopLimitSwitch(double speed){
       
    // }

    /** Reset the member data to default values */
    // public void resetData() {
    //     setUsage (false);
    //     setDirection (true);
    // }

    /** 
     * determine if the unit is spinning/in use
     * @return true if unit is in use
     */
    // public boolean isInUse() {
    //     return bSpinning;
    // }
    /** 
     * set flag to denote unit is in use
     * @param bFlag  true if in use, false if not
     */
    // public void setUsage (boolean bFlag) {
    //     bSpinning = bFlag;
    // }

    /**
     * Set the direction of unit,while in use
     * @param bIsForward  true if "foward"
    //  */
    // public void setDirection ( boolean bIsForward ) {
    //     bForward = bIsForward;
    // }
    /** 
     * get the direction of the unit in use
     * @return true, if spinning foward, false for reverse
     */
    // public boolean getDirection(){
    //     return bForward;
    // }


    /***********************************************************
     * Spin the carousel if not already spinning
     *  @param speed          how fast to spin motor, in directio (-1 to 1)
     *  @param motorInversion Direction of motor (See Constants)
     ************************************************************/
    // public void spinCarousel (double speed )
    // {
    //     // if not in use, take ownership
    //     if (!isInUse()){
    //         setUsage (true);
    //         setDirection (speed > 0.0);
    //         carouselMotor.set(ControlMode.PercentOutput, speed);
    //     }
    // }
    // /**
    //  * Stop the carousel and reset default data
    //  */
    // public void stopCarousel() {
    //     resetData ();
    //     carouselMotor.set(ControlMode.PercentOutput, 0);
    // }

    private void configureMotorControllers() {
        carouselMotor.setInverted(true);
        carouselMotor.setNeutralMode(NeutralMode.Brake); //could be kBrake -- check
    }


    @Override
    protected void initDefaultCommand() {
        //setDefaultCommand(new CarouselForward());
    }

    @Override
    public void zeroSensors() {
        
    }

    @Override
    public void testSubsystem() {
        
    }

    @Override
    public void outputSmartdashboard() {
        SmartDashboard.putBoolean("Carousel Spin Fwd", CarouselIsRunning);
    }

    @Override
    public void resetSubsystem() {
        stopCarousel();
        zeroSensors();
        configureMotorControllers();
    }

}