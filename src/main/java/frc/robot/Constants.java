package frc.robot;

//change values to change motor speeds, commit these changes with cntrl shift p 
public class Constants {
    public static final double DRIVETRAIN_SPEED_SCALE = 1;
    public static final double DRIVETRAIN_SLOW_SCALE = .5;
    public static final double DRIVETRAIN_RAMP_RATE = 0.5;

    public static final double TICKS_TO_INCHES_WHEELS = 7.75 * Math.PI * .1; 

    public static final double KICKER_FORWARD_SPEED = 1;
    public static final double KICKER_BACKWARDS_SPEED = -KICKER_FORWARD_SPEED;

    public static final double INTAKE_SPEED = 1;
    public static final double INTAKE_SPEED_REVERSE = -INTAKE_SPEED;

    public static final double SHOOTER_SPEED = 1;
    public static final double SHOOTER_SPEED_REVERSE = -SHOOTER_SPEED;

    public static final double CAROUSEL_FORWARD_SPEED = 1;
    public static final double CAROUSEL_BACKWARD_SPEED = -CAROUSEL_FORWARD_SPEED;
}
