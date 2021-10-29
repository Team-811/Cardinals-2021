package frc.robot.commands.Kicker;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class KickerRetract extends Command{
    public KickerRetract() {
        requires(Robot.kicker);
      } 
    
      @Override
         protected void initialize() {
         
        }
     
       @Override
         protected void execute() {
           Robot.kicker.retractKicker();
           
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