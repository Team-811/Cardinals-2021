package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SlowMode extends Command {
  /**
   * This command puts the Robot into slow mode while it is active
   */
  public SlowMode() {
  }

  // Called continously while the command is run. In this case, while the button
  // for slow mode is pressed.
  @Override
  protected void execute() {
    Robot.drivetrain.slowMode(true);
  }

  // turn off slow mode when the command is not longer being called
  @Override
  protected void end() {
    Robot.drivetrain.slowMode(false);
  }

  @Override
  protected void interrupted() {
    end();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }
}
