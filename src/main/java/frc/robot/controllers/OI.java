//This is where we bind the commands to the buttons, the format is very simple
package frc.robot.controllers;
/**
 * When you want to bind a button to a command you MUST import the command code, this is the format:
 * import frc.robot.(name of folder it is in).(name of subfolder).command name
 */
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//this import allows us to talk to the smartdashboard to display values for the drivers/pit crew
//Reminder for Charlotte: SmartDashboard subclass?
public class OI {
    private boolean mode = true;

    public BobXboxController driveController;
    public BobXboxController operatorController;
    
    public static OI getInstance() {
        return new OI();
    }

    public OI() {
        driveController = new BobXboxController(1, .3, .3);
        operatorController = new BobXboxController(1, .3, .3);

        if(mode)    {
            //for driver: driveController.(button).(action, usually when pressed or while held)(new (action)());
            //to diffrentiate the controllers change the controller


        }
        
        //Single Controller
        else {

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
