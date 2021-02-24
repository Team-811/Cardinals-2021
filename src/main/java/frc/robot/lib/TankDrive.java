package frc.robot.lib;


public class TankDrive 
{
    private Output driveOutput;
  
    private int forwardBackwardInvert;
    private int rotationInvert;

    public TankDrive()
    {
        driveOutput = new Output();

        forwardBackwardInvert = 1;
        rotationInvert = 1;
    }

    public Output tankDrive(double leftValue, double rightValue)
    {
        
        leftValue = leftValue * forwardBackwardInvert;
        rightValue = rightValue * rotationInvert;

        driveOutput.updateOutput(leftValue, rightValue);

        return driveOutput;
    }


    public Output arcadeDrive(double forwardValue, double rotationValue)
    {
      
        forwardValue = forwardValue * forwardBackwardInvert;
        rotationValue = rotationValue * rotationInvert;


        double leftValue = forwardValue + rotationValue;
        double rightValue = forwardValue - rotationValue;

        driveOutput.updateOutput(leftValue, rightValue);

        return driveOutput;
    }

    //TODO
    public Output curvatureMecanumDrive(double forwardValue, double rotationValue, boolean isQuickTurn, boolean isHighGear, double strafeValue, double deadbandValue)
    {
        double m_quickStopThreshold = 0.2;
        double m_quickStopAlpha = 0.1;
        double m_quickStopAccumulator = 0;

        forwardValue = limit(forwardValue, 1);
        forwardValue = handleDeadband(forwardValue, deadbandValue);

        rotationValue = limit(rotationValue, 1);
        rotationValue = handleDeadband(rotationValue, deadbandValue);

    double angularPower;
    boolean overPower;

    if (isQuickTurn) {
      if (Math.abs(forwardValue) < m_quickStopThreshold) {
        m_quickStopAccumulator = (1 - m_quickStopAlpha) * m_quickStopAccumulator
            + m_quickStopAlpha * limit(rotationValue, 1) * 2;
      }
      overPower = true;
      angularPower = rotationValue;
    } else {
      overPower = false;
      angularPower = Math.abs(forwardValue) * rotationValue - m_quickStopAccumulator;

      if (m_quickStopAccumulator > 1) {
        m_quickStopAccumulator -= 1;
      } else if (m_quickStopAccumulator < -1) {
        m_quickStopAccumulator += 1;
      } else {
        m_quickStopAccumulator = 0.0;
      }
    }

    double leftMotorOutput = forwardValue + angularPower;
    double rightMotorOutput = forwardValue - angularPower;

    // If rotation is overpowered, reduce both outputs to within acceptable range
    if (overPower) {
      if (leftMotorOutput > 1.0) {
        rightMotorOutput -= leftMotorOutput - 1.0;
        leftMotorOutput = 1.0;
      } else if (rightMotorOutput > 1.0) {
        leftMotorOutput -= rightMotorOutput - 1.0;
        rightMotorOutput = 1.0;
      } else if (leftMotorOutput < -1.0) {
        rightMotorOutput -= leftMotorOutput + 1.0;
        leftMotorOutput = -1.0;
      } else if (rightMotorOutput < -1.0) {
        leftMotorOutput -= rightMotorOutput + 1.0;
        rightMotorOutput = -1.0;
      }
    }

    // Normalize the wheel speeds
    double maxMagnitude = Math.max(Math.abs(leftMotorOutput), Math.abs(rightMotorOutput));
    if (maxMagnitude > 1.0) {
      leftMotorOutput /= maxMagnitude;
      rightMotorOutput /= maxMagnitude;
    }


        driveOutput.updateOutput(leftMotorOutput, rightMotorOutput);

        return driveOutput;
    }



  private double handleDeadband(double val, double deadband) {
      return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
  }

  private double limit(double input, double limit)
  {
      if(input > limit )
      {
          return limit;
      }
      else if(input < -limit)
      {
          return -limit;
      }
      else
      {
          return input;
      }
  }
}
