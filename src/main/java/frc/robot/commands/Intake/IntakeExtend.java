package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeExtend extends Command{
    public IntakeExtend() {
        requires(Robot.intake);
      } 
    
      @Override
         protected void initialize() {
         
        }
     
       @Override
         protected void execute() {
           Robot.intake.extendIntake();
           
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