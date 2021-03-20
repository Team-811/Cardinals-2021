package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class ShooterStop extends Command {

  public ShooterStop() {
    requires(Robot.kicker);
  } 

  @Override
     protected void initialize() {
     
    }
 
   @Override
     protected void execute() {
       Robot.shooter.stopShooter();
     }

   @Override
     protected void end() {    
    
    }
    
    @Override
    protected boolean isFinished(){
        return false;
    }

}