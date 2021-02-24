package frc.robot.commands.Utility;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.TimedCommand;

public class TimerCommand extends TimedCommand {
  /**
   * This command pauses the code for a given period between commands in command
   * groups.
   * 
   * @param timeout : time in seconds
   */
  public TimerCommand(double timeout) {
    super(timeout);
  }

  /**
   * Used to wait in the code (not between commands)
   * 
   * @param seconds
   */
  public static void PauseCode(double seconds) {
    double start = Timer.getFPGATimestamp();
    while (Timer.getFPGATimestamp() - start < seconds) {
    }
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
