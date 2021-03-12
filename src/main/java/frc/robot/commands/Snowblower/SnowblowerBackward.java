package frc.robot.commands.Snowblower;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class SnowblowerBackward extends Command {


    public SnowblowerBackward() {
        requires(Robot.snowblower);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
      Robot.snowblower.snowblowerBackward(Constants.SNOWBLOWER_BACKWARD_SPEED);
    }

    @Override
    protected void end() {
        
    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }


    
}
