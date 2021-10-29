//This is where we bind the commands to the buttons, the format is very simple
package frc.robot.controllers;

import java.sql.Driver;

/**
 * When you want to bind a button to a command you MUST import the command code, this is the format:
 * import frc.robot.(name of folder it is in).(name of subfolder).command name
 */
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Carousel.CarosuelBackward;
import frc.robot.commands.Carousel.CarouselForward;
import frc.robot.commands.Carousel.CarouselStop;
import frc.robot.commands.Drivetrain.NormalDrive;
import frc.robot.commands.Drivetrain.SlowMode;
import frc.robot.commands.Intake.IntakeExtend;
import frc.robot.commands.Intake.IntakeForward;
import frc.robot.commands.Intake.IntakeRetract;
import frc.robot.commands.Intake.IntakeReverse;
import frc.robot.commands.Intake.stopIntake;
import frc.robot.commands.Kicker.KickerForward;
import frc.robot.commands.Kicker.KickerReverse;
import frc.robot.commands.Kicker.KickerStop;
import frc.robot.commands.Kicker.KickerExtend;
import frc.robot.commands.Kicker.KickerRetract;
//import frc.robot.commands.Kicker.KickerStop;
import frc.robot.commands.Shooter.ShooterForward;
import frc.robot.commands.Shooter.ShooterReverse;
import frc.robot.commands.Shooter.ShooterStop;

//this import allows us to talk to the smartdashboard to display values for the drivers/pit crew
//Reminder for Charlotte: SmartDashboard subclass?
//False is single control
public class OI {
    private boolean mode = true;

    public BobXboxController driveController;
    public BobXboxController operatorController;
    
    public static OI getInstance() {
        return new OI();
    }

    public OI() {
        driveController = new BobXboxController(0, .3, .3);
        operatorController = new BobXboxController(1, .3, .3);

        if(mode)    {
            //for driver: driveController.(button).(action, usually when pressed or while held)(new (action)());
            //to diffrentiate the controllers change the controller
          driveController.startButton.whenPressed(new NormalDrive());
          driveController.leftBumper.whileHeld(new SlowMode());  
          // driveController.aButton.whileHeld(new IntakeExtend());
          // driveController.aButton.whenInactive(new IntakeRetract());
          // driveController.xButton.whileHeld(new KickerExtend());
          // driveController.yButton.whenInactive(new KickerRetract());
          

          operatorController.aButton.whileHeld(new IntakeReverse());
          operatorController.aButton.whenReleased(new stopIntake());
          operatorController.bButton.whileHeld(new IntakeForward());
          operatorController.bButton.whenReleased(new stopIntake());

          operatorController.xButton.whenPressed(new KickerReverse());
          operatorController.xButton.whenInactive(new KickerStop());
          // operatorController.yButton.whenPressed(new KickerReverse());
          // operatorController.yButton.whenInactive(new KickerStop());

          

          operatorController.leftTriggerButton.whileHeld(new CarouselForward());
          operatorController.rightTriggerButton.whileHeld(new CarosuelBackward());
          operatorController.rightTriggerButton.whenReleased(new CarouselStop());
          operatorController.leftTriggerButton.whenReleased(new CarouselStop());

          operatorController.xButton.whenPressed(new ShooterForward());
          operatorController.xButton.whenReleased(new ShooterStop());
          // operatorController.yButton.whenPressed(new ShooterReverse());
          operatorController.yButton.whenReleased(new ShooterStop());

         operatorController.bButton.whileActive(new IntakeExtend());
         operatorController.aButton.whenActive(new IntakeRetract());
         operatorController.yButton.whileHeld(new KickerExtend());
         operatorController.xButton.whenActive(new KickerExtend());
          
/*
          operatorController.startButton.whenPressed(new IntakeExtend());
          operatorController.startButton.whenInactive(new IntakeRetract());
*/


          //operatorController.yButton.whenPressed(new ShooterReverse());
            
        }
        
        //Single Controller
        else {
          driveController.startButton.whenPressed(new NormalDrive());
          driveController.leftBumper.whileHeld(new SlowMode());

          driveController.aButton.whileHeld(new IntakeForward());
          driveController.rightBumper.whenPressed(new ShooterReverse());

          driveController.xButton.whileActive(new IntakeExtend());

          // driveController.xButton.whenPressed(new KickerForward());
          // driveController.bButton.whenPressed(new KickerReverse());

          driveController.leftTriggerButton.whileHeld(new CarouselForward());
          driveController.rightTriggerButton.whileHeld(new CarosuelBackward());

          driveController.yButton.whenPressed(new ShooterForward());

        }

    }

    public void outputSmartDashboard() {
        String strMode;
        if (mode) {
          strMode = "DUAL";
        } else
          strMode = "SINGLE";
    
        SmartDashboard.putString("Controller Mode", strMode);
      }

}
