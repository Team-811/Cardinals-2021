package frc.robot.commands.Carousel;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class CarosuelBackward extends Command{

    public CarosuelBackward() {
        requires(Robot.carousel);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
      Robot.carousel.spinCarousel ( Constants.CAROUSEL_BACKWARD_SPEED );
    }

    @Override
    protected void end() {
        
    }

    @Override
    protected boolean isFinished() {
      return false;

    }


}