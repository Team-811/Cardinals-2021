package frc.robot.commands.Kicker;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class KickerReverse extends Command {

  public KickerReverse() {
      requires(Robot.kicker);
  }

  @Override
    protected void initialize() {

    }
  
  @Override
    protected void execute() {
        Robot.kicker.reverseKicker(Constants.KICKER_BACKWARDS_SPEED);
    }
    

  @Override
    protected void end() {
        
    }

  @Override
    protected boolean isFinished() {
      return false;

    }

  


}