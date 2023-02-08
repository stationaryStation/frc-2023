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
import edu.wpi.first.wpilibj2.command.CommandScheduler;

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

  private RobotContainer rbContainer;
  
  private final Timer matchTimer = new Timer();

  private void startMode() {
    matchTimer.reset();
    matchTimer.start();
  }


  @Override
  public void robotInit() {
    rbContainer = new RobotContainer();
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
    // FIXME: ADD AUTONOMOUS COMMAND
  }

  @Override
  public void teleopInit() {
    startMode();
  }

  @Override
  public void teleopPeriodic() {
    // Overriden by default command under RobotContainer
  }

  @Override
  public void disabledInit() {
    CommandScheduler.getInstance().cancelAll();
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
