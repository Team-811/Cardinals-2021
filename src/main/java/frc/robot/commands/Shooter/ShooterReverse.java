package frc.robot.commands.Shooter;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Constants;

import frc.robot.Robot;

public class ShooterReverse extends InstantCommand {
    
    public ShooterReverse() {
        requires(Robot.intake);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void execute() {
        Robot.shooter.shooterForward(Constants.SHOOTER_SPEED_REVERSE);
    }

    @Override
    protected void end() {}

    @Override
    protected boolean isFinished(){
        return false;
    }
}
           