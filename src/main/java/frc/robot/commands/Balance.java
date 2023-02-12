package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class Balance extends CommandBase {
  private final DriveSubsystem dSubsystem;
  private final GyroSubsystem gSubsystem;

  public Balance(DriveSubsystem drivetrain, GyroSubsystem gyro) {
    dSubsystem = drivetrain;
    gSubsystem = gyro;
    addRequirements(dSubsystem, gSubsystem);
  }

  // Everything inside of this execute function will run until it is finished or
  // when the command ends.
  @Override
  public void execute() {
    if (gSubsystem.getAngle() > 5) {
      dSubsystem.arcadeDrive(0, .3);
    } else if (gSubsystem.getAngle() > -5) {
      dSubsystem.arcadeDrive(0, -.3);
    } else {
      dSubsystem.stopMotors();
    }
  }

  @Override
  public boolean isFinished() {
    if (gSubsystem.getAngle() > -5 && gSubsystem.getAngle() < 5) {
      return false;
    } else {
      return true;
    }
  }
}
