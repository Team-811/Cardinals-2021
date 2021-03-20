package frc.robot.commands.Kicker;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class KickerForward extends Command {


  public KickerForward() {
      requires(Robot.kicker);
  }

    @Override
    protected void initialize() {

    }
 
    @Override
    protected void execute() {
       Robot.kicker.forwardKicker(Constants.KICKER_FORWARD_SPEED);
    }

    @Override
    protected void end() {
        
    }

    @Override
    protected boolean isFinished() {
      return false;

    }


  }

