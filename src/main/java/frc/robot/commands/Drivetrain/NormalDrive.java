package frc.robot.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class NormalDrive extends InstantCommand {
  /**
   * This command toggles the drive mode of the robot between arcade and tank
   */
  public NormalDrive() {

  }

  // Called once when the command executes. Since this is an InstantCommand, the
  // method wil only be called once and not continuously. This is good when
  // something needs to be turned on/off or toggled.
  @Override
  protected void initialize() {
    Robot.drivetrain.toggleDriveMode();
  }

}
