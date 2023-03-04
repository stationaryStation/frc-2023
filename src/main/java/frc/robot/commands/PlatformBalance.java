package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.math.controller.PIDController;

public class PlatformBalance extends CommandBase {
  private final DriveSubsystem dSubsystem;
  private final GyroSubsystem gSubsystem;
  private final PIDController pid = new PIDController(0.1, 0.04, 0);

  /**
   * Initialize Balance Command
   * 
   * @param drivetrain
   * @param gyro
   */
  public PlatformBalance(DriveSubsystem drivetrain, GyroSubsystem gyro) {
    dSubsystem = drivetrain;
    gSubsystem = gyro;
    addRequirements(dSubsystem, gSubsystem);
    pid.enableContinuousInput(-180, 180);
  }

  // Everything inside of this execute function will run until it is finished or
  // when the command ends.
  @Override
  public void execute() {

    SmartDashboard.putNumber("PID output", -1 * pid.calculate(gSubsystem.getClampedAngle(), 0));

    dSubsystem.arcadeDrive(0, -1 * pid.calculate(gSubsystem.getClampedAngle(), 0));

    SmartDashboard.putNumber("Current Clamped Angle", gSubsystem.getClampedAngle());
    dSubsystem.arcadeDrive(0, -1 * pid.calculate(gSubsystem.getClampedAngle(), 0));

    SmartDashboard.putNumber("Current Clamped Angle", gSubsystem.getClampedAngle());
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
