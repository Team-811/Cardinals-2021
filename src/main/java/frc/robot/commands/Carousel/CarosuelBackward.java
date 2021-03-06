package frc.robot.commands.Carousel;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class CarouselBackward extends Command{

    public CarouselBackward() {
        requires(Robot.carousel);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
      Robot.carousel.reverseCarousel(Constants.CAROUSEL_BACKWARD_SPEED);
    }

    @Override
    protected void end() {
        
    }

    @Override
    protected boolean isFinished() {
      return false;

    }


}