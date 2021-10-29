package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class stopIntake extends Command {

  public stopIntake() {
    requires(Robot.intake);
  } 

  @Override
     protected void initialize() {
     
    }
 
   @Override
     protected void execute() {
       Robot.intake.stopIntake();
       
     }

   @Override
     protected void end() {    
    
    }
    
    @Override
    protected boolean isFinished(){
        return false;
    }

}