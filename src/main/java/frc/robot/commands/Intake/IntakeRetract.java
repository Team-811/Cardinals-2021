package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeRetract extends Command{
    public IntakeRetract() {
        requires(Robot.intake);
      } 
    
      @Override
         protected void initialize() {
         
        }
     
       @Override
         protected void execute() {
           Robot.intake.retractIntake();
           
         }
    
       @Override
         protected void end() {    
        
        }
    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }
    
}