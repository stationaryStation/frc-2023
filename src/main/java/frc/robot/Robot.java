// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the
 * name of this class or
 * the package after creating this project, you must also update the
 * build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */

  private final WPI_TalonSRX frontRightMotor = new WPI_TalonSRX(2);
  private final WPI_TalonSRX rearRightMotor = new WPI_TalonSRX(1);
  private final WPI_TalonSRX frontLeftMotor = new WPI_TalonSRX(3);
  private final WPI_TalonSRX rearLeftMotor = new WPI_TalonSRX(4);

  private final MotorControllerGroup rightDrivetrain = new MotorControllerGroup(frontRightMotor, rearRightMotor);
  private final MotorControllerGroup leftDrivetrain = new MotorControllerGroup(frontLeftMotor, rearLeftMotor);

  private final DifferentialDrive robotDrivetrain = new DifferentialDrive(leftDrivetrain, rightDrivetrain);

  private final XboxController controller = new XboxController(0);

  private final Timer matchTimer = new Timer();

  private void startMode() {
    matchTimer.reset();
    matchTimer.start();
  }

  private void enableSafety() {
    // Enable motor safety for all motors
    robotDrivetrain.setSafetyEnabled(true);
    robotDrivetrain.setExpiration(.1);
    robotDrivetrain.feed();
  }

  @Override
  public void robotInit() {
    // When turning to right the robot steers to the left but if inverted, it will
    // steer
    // to the right successfully.
    rightDrivetrain.setInverted(true);
    enableSafety();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    startMode();
  }

  @Override
  public void autonomousPeriodic() {
    if (matchTimer.get() > 2.0) {
      // This should go forwards
      robotDrivetrain.arcadeDrive(0.5, 0.5, false);
    } else {
      robotDrivetrain.stopMotor();
    }
  }

  @Override
  public void teleopInit() {
    startMode();
  }

  @Override
  public void teleopPeriodic() {
    robotDrivetrain.tankDrive(-controller.getRawAxis(1)-.2, -controller.getRawAxis(5)-.2);
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {
  }

  @Override
  public void testPeriodic() {
  }
}
