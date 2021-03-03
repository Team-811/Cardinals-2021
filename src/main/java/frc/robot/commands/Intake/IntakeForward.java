package frc.robot.commands.Intake;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Constants;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeForward extends InstantCommand {
    
    public IntakeForward() {

    }

    @Override
    protected void initalize() {
        Robot.intake.IntakeForward(Constants.INTAKE_SPEED);
    }
    //not coded into robot so this is an error -- TODO
}
