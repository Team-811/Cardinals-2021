package frc.robot.commands.Kicker;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class KickerExtend extends Command{
    public KickerExtend() {
        requires(Robot.kicker);
      } 
    
      @Override
         protected void initialize() {
         
        }
     
       @Override
         protected void execute() {
           Robot.kicker.extendKicker();
           
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