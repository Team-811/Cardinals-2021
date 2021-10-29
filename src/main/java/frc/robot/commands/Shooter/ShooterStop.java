package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.InstantCommand;

import frc.robot.Robot;

public class ShooterStop extends InstantCommand {

  public ShooterStop() {
    requires(Robot.shooter);
  } 

  @Override
     protected void initialize() {
     
    }
 
   @Override
     protected void execute() {
       Robot.shooter.ShooterStop();
     }

   @Override
     protected void end() {    
    
    }
    
    @Override
    protected boolean isFinished(){
        return false;
    }

}