package frc.robot.commands.Carousel;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;

public class CarouselStop extends InstantCommand {

    public CarouselStop() {
        requires(Robot.carousel);
    }

    
    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        Robot.carousel.stopCarousel();
    }

    @Override
    protected void end() {
        
    }
}