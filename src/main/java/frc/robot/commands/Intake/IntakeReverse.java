package frc.robot.commands.Intake;

import java.lang.module.ModuleDescriptor.Requires;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeReverse extends InstantCommand{

    public IntakeReverse() {
        requires(Robot.carousel);
    }

    @Override
    protected void initalize() {}

    @Override
    protected void execute() {
        Robot.intake.intakeReverse(Constants.INTAKE_SPEED_REVERSE);
    }

    @Override
    protected void end() {}

    @Override 
    protected boolean isFinished() {
        return false;
    }
}
