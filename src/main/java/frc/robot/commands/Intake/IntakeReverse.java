package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Constants;



public class IntakeReverse {
    public IntakeReverse() {

    }

    @Override
    protected void initalize() {
        Robot.intake.IntakeReverse(Constants.INTAKE_SPEED_REVERSE);
    }
}
