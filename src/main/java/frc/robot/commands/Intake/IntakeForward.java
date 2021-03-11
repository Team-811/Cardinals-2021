package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Constants;

import frc.robot.Robot;

public class IntakeForward extends InstantCommand {
    
    public IntakeForward() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.intake.IntakeForward(Constants.INTAKE_SPEED);
    }

    @Override
    protected void end() {}

    @Override
    protected boolean isFinished(){
        return false;
    }
}
           