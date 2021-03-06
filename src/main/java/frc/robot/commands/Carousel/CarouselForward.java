package frc.robot.commands.Carousel;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class CarouselForward extends Command {

    public CarouselForward() {
        requires(Robot.carousel);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
      Robot.carousel.forwardCarousel(Constants.CAROUSEL_FORWARD_SPEED);
    }

    @Override
    protected void end() {
        
    }

    @Override
    protected boolean isFinished() {
      return false;

    }


}