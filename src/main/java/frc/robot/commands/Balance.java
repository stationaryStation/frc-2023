package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;




public class Balance extends CommandBase {
  private final DriveSubsystem dSubsystem;
  private final GyroSubsystem gSubsystem;

  public Balance(DriveSubsystem drivetrain, GyroSubsystem gyro) {
    dSubsystem = drivetrain;
    gSubsystem = gyro;
    addRequirements(dSubsystem, gSubsystem);
  }

  @Override
  public void execute() {
    if (gSubsystem.getAngle() > 5) {
      dSubsystem.arcadeDrive(0, .1);
    } else if (gSubsystem.getAngle() > -5) {
      dSubsystem.arcadeDrive(0, -.1);
    } else {
      dSubsystem.stopMotors();
    }
    SmartDashboard.putNumber("ang",gSubsystem.getAngle());

    
  }

  @Override
  public boolean isFinished() {
    return (gSubsystem.getAngle() > -5 && gSubsystem.getAngle() < 5);
  }
}
