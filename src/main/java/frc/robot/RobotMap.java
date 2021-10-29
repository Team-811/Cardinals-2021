package frc.robot;

public class RobotMap {
    //all of these are placeholders

    // Spark MAX CAN bus addresses - Neo Motors
    public static final int DRIVE_TOP_LEFT_MOTOR = 1; 
    public static final int DRIVE_TOP_RIGHT_MOTOR = 3;
    public static final int DRIVE_BOTTOM_LEFT_MOTOR = 2;
    public static final int DRIVE_BOTTOM_RIGHT_MOTOR = 4;
    public static final int INTAKE = 7;  
    public static final int SHOOTER = 13;

    //PG 71
    public static final int CLIMBER = 0;
    // Talon SRX

    public static final int KICKER     = 10; //ball injection wheel
    public static final int TBD2     = 11; //shooter turntable (snowblower)
    public static final int CAROUSEL = 12;
   
    //public static final int KICKER = 5;

    //solenoid
    public static final int INTAKE_PISTON_EXTENTION = 1; 
    public static final int INTAKE_PISTON_RETRACTION = 3; 
    public static final int KICKER_PISTON_EXTENTION = 0;
    public static final int KICKER_PISTON_RETRACTION = 2;
    public static final int PCM_CAN_ID = 0;

    //Limit switches
    public static final int CAROUSEL_LIMIT_SWITCH = 5; //placeholde
}
