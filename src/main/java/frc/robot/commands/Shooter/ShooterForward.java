package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Constants;

import frc.robot.Robot;

public class ShooterForward extends InstantCommand {
    
    public ShooterForward() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.shooter.ShooterForward(Constants.SHOOTER_SPEED);
    }

    @Override
    protected void end() {}

    @Override
    protected boolean isFinished(){
        return false;
    }
}
           