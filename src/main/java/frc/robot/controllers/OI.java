//This is where we bind the commands to the buttons, the format is very simple
package frc.robot.controllers;
/**
 * When you want to bind a button to a command you MUST import the command code, this is the format:
 * import frc.robot.(name of folder it is in).(name of subfolder).command name
 */
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Carousel.CarosuelBackward;
import frc.robot.commands.Carousel.CarouselForward;
import frc.robot.commands.Drivetrain.NormalDrive;
import frc.robot.commands.Drivetrain.SlowMode;
import frc.robot.commands.Intake.IntakeForward;
// import frc.robot.commands.Kicker.KickerForward;
// import frc.robot.commands.Kicker.KickerReverse;
import frc.robot.commands.Shooter.ShooterForward;
import frc.robot.commands.Shooter.ShooterReverse;
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

          operatorController.aButton.whileHeld(new IntakeForward());

        //  operatorController.xButton.whenPressed(new KickerForward());
        //  operatorController.bButton.whenPressed(new KickerReverse());

          driveController.leftTriggerButton.whileHeld(new CarouselForward());
          operatorController.rightTriggerButton.whileHeld(new CarosuelBackward());

          operatorController.yButton.whenPressed(new ShooterReverse());

        }
        
        //Single Controller
        else {
          driveController.startButton.whenPressed(new NormalDrive());
          driveController.leftBumper.whileHeld(new SlowMode());

          driveController.aButton.whileHeld(new IntakeForward());
          driveController.rightBumper.whenPressed(new ShooterReverse());

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
