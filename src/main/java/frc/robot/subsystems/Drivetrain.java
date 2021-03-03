package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.Drivetrain.DriveWithJoy;
import frc.robot.commands.Utility.TimerCommand;
import frc.robot.lib.Output;
import frc.robot.lib.TankDrive;


public class Drivetrain extends Subsystem implements ISubsystem {

  private static Drivetrain instance = new Drivetrain();

  /**
   * @return A new instance of the Drivetrain
   */
  public static Drivetrain getInstance() {
    return instance;
  }

  
  private CANSparkMax topLeftMotor;
  private CANSparkMax topRightMotor;
  private CANSparkMax bottomLeftMotor;
  private CANSparkMax bottomRightMotor;

  
  private CANEncoder topLeftEncoder;
  private CANEncoder topRightEncoder;
  private CANEncoder bottomLeftEncoder;
  private CANEncoder bottomRightEncoder;

  

  private TankDrive drivetrain;
  private Output driveOutput;

  /**
   * @return A new instance of the Drivetrain
   */
  public Drivetrain() {
    topLeftMotor = new CANSparkMax(RobotMap.DRIVE_TOP_LEFT_MOTOR, MotorType.kBrushless);
    topRightMotor = new CANSparkMax(RobotMap.DRIVE_TOP_RIGHT_MOTOR, MotorType.kBrushless);
    bottomLeftMotor = new CANSparkMax(RobotMap.DRIVE_BOTTOM_LEFT_MOTOR, MotorType.kBrushless);
    bottomRightMotor = new CANSparkMax(RobotMap.DRIVE_BOTTOM_RIGHT_MOTOR, MotorType.kBrushless);

    topLeftEncoder = topLeftMotor.getEncoder();
    topRightEncoder = topRightMotor.getEncoder();
    bottomLeftEncoder = bottomLeftMotor.getEncoder();
    bottomRightEncoder = bottomRightMotor.getEncoder();


    resetSubsystem();

    drivetrain = new TankDrive();
  }

  private double DefaultSpeedScale = Constants.DRIVETRAIN_SPEED_SCALE;

  private double SlowSpeedScale = Constants.DRIVETRAIN_SLOW_SCALE;

  private double SpeedScale = DefaultSpeedScale;

  private boolean isSlow = false;

  private double RampRate = Constants.DRIVETRAIN_RAMP_RATE;

  private boolean DriveMode = true;

  /**
   * This is the main method for driving the robot. It determines which drive mode
   * is currently selected and outputs to the motors accordingly. For tank drive
   * mode, the left stick controls the left wheels and the right stick controls
   * the right wheels. In arcade mode, the left stick controls forward/reverse
   * motion and the right stick controls turning. Arcade mode has gyro correction
   * to keep the robot moving in a straight line.
   * 
   * @param leftStick  : Y value of left XBox joystick.
   * @param rightStick : Y value of right XBox joystick.
   * @param rotation   : X value of right XBox joystick.
   */
  public void driveWithJoy(double leftStick, double rightStick, double rotation) {
    // Tank Drive (no gyro correction)
    if (!DriveMode) {
      driveOutput = drivetrain.tankDrive(leftStick * SpeedScale, rightStick * SpeedScale);

      topLeftMotor.set(driveOutput.getLeftValue());
      bottomLeftMotor.set(driveOutput.getLeftValue());

      topRightMotor.set(driveOutput.getRightValue());
      bottomRightMotor.set(driveOutput.getRightValue());
    }

    
    else {


     
        driveOutput = drivetrain.arcadeDrive(leftStick * SpeedScale, rotation * SpeedScale * 0.8);

      topLeftMotor.set(driveOutput.getLeftValue());
      bottomLeftMotor.set(driveOutput.getLeftValue());

      topRightMotor.set(-driveOutput.getRightValue());
      bottomRightMotor.set(-driveOutput.getRightValue());

    }
  }

  /**
   * Toggle slow mode. Robot will be in slow mode as this method is repeatedly
   * called.
   * 
   * @param slow : set this to true for slow mode
   */
  public void slowMode(boolean slow) {
    if (slow) {
      isSlow = true;
      SpeedScale = SlowSpeedScale;
    } else {
      isSlow = false;
      SpeedScale = DefaultSpeedScale;
    }

  }

  public void toggleDriveMode() {
    DriveMode = !DriveMode;
  }

  /**
   * Drives the robot forward a given number of inches and stops the drivetrain
   * after
   * 
   * @param inches
   * @param speed
   */
  public void driveInches(double inches, double speed) {

    while (getForwardVelocityAbs() > 0) {
      stopDrivetrain();
    }

    zeroEncoders();
    TimerCommand.PauseCode(0.1);
    outputSmartdashboard();
    double distanceDriven = 0;

    while (Math.abs(distanceDriven) <= inches) {

      driveWithJoy(speed, 0, 0);
      distanceDriven = getForwardDistanceAbs();

      outputSmartdashboard();

      if (getForwardVelocity() == 0 && Math.abs(getForwardDistance()) * Constants.TICKS_TO_INCHES_WHEELS > 10) {
        break;
      }
    }

    setSparkOpenLoopRampRate(0.3);
    stopDrivetrain();

    setSparkOpenLoopRampRate(RampRate);
  }

  /**
   * Manually set the ramp rate of drivetrain motors
   * 
   * @param rate How fast from 0 to full speed in seconds
   */
  private void setSparkOpenLoopRampRate(double rate) {
    topLeftMotor.setOpenLoopRampRate(rate);
    topRightMotor.setOpenLoopRampRate(rate);
    bottomLeftMotor.setOpenLoopRampRate(rate);
    bottomRightMotor.setOpenLoopRampRate(rate);
  }

  /**
   * 
   * @return Number of rotations of left motor
   */
  public double getLeftEncoder() {
    return (topLeftEncoder.getPosition() + bottomLeftEncoder.getPosition()) / 2;
  }

  /**
   * 
   * @return Number of rotations of right motor
   */
  public double getRightEncoder() {
    return (topRightEncoder.getPosition() + bottomRightEncoder.getPosition()) / -2;
  }

  /**
   * 
   * @return Average of left and right distances
   */
  public double getForwardDistance() {
    return (getLeftEncoder() + getRightEncoder()) / 2;
  }

  /**
   * 
   * @return Absolute value of the current forward distance
   */
  public double getForwardDistanceAbs() {
    return Math.abs(getForwardDistance());
  }

  /**
   * 
   * @return Left side speed
   */
  public double getLeftVelocity() {
    return (topLeftEncoder.getVelocity() + bottomLeftEncoder.getVelocity()) / 2;
  }

  /**
   * 
   * @return Right side speed
   */
  public double getRightVelocity() {
    return (topRightEncoder.getVelocity() + bottomRightEncoder.getVelocity()) / -2;
  }

  /**
   * 
   * @return Average forward speed
   */
  public double getForwardVelocity() {
    return (getLeftVelocity() + getRightVelocity()) / 2;
  }

  /**
   * 
   * @return Absolute value of forward velocity
   */
  public double getForwardVelocityAbs() {
    return Math.abs(getForwardVelocity());
  }


  public void stopDrivetrain() {
    topLeftMotor.set(0);
    bottomLeftMotor.set(0);

    topRightMotor.set(0);
    bottomRightMotor.set(0);
  }

  public void zeroEncoders() {
    topLeftEncoder.setPosition(0);
    topRightEncoder.setPosition(0);
    bottomLeftEncoder.setPosition(0);
    bottomRightEncoder.setPosition(0);
  }

  private void configureMotorControllers() {
    zeroEncoders();
    topLeftMotor.setInverted(false);
    topRightMotor.setInverted(false);
    bottomLeftMotor.setInverted(false);
    bottomRightMotor.setInverted(false);

    topLeftMotor.setIdleMode(IdleMode.kBrake);
    topRightMotor.setIdleMode(IdleMode.kBrake);
    bottomLeftMotor.setIdleMode(IdleMode.kBrake);
    bottomRightMotor.setIdleMode(IdleMode.kBrake);

    topLeftMotor.setOpenLoopRampRate(RampRate);
    topRightMotor.setOpenLoopRampRate(RampRate);
    bottomLeftMotor.setOpenLoopRampRate(RampRate);
    bottomRightMotor.setOpenLoopRampRate(RampRate);

    topLeftEncoder.setPositionConversionFactor(Constants.TICKS_TO_INCHES_WHEELS);
    topRightEncoder.setPositionConversionFactor(Constants.TICKS_TO_INCHES_WHEELS);
    bottomLeftEncoder.setPositionConversionFactor(Constants.TICKS_TO_INCHES_WHEELS);
    bottomRightEncoder.setPositionConversionFactor(Constants.TICKS_TO_INCHES_WHEELS);
  }

  @Override
  public void outputSmartdashboard() {
    SmartDashboard.putNumber("Net Forward Distance (in)", getForwardDistance());
    SmartDashboard.putNumber("Forward Velocity (rpm)", getForwardVelocity());
    SmartDashboard.putBoolean("Slow Mode", isSlow);

    String mode;
    if (DriveMode)
      mode = "Arcade";
    else
      mode = "Tank";
    SmartDashboard.putString("Drive Mode ", mode);

  }

  @Override
  public void resetSubsystem() {
    stopDrivetrain();
    zeroSensors();
    configureMotorControllers();
  }

  @Override
  public void zeroSensors() {
    zeroEncoders();
  }

  @Override
  public void testSubsystem() {

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveWithJoy());
  }

}
