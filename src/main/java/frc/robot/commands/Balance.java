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
    if (gSubsystem.getAngle() > 2.0) {
      SmartDashboard.putBoolean("go left", true);
      SmartDashboard.putBoolean("go right",false);
      dSubsystem.arcadeDrive(0, 1);

    } else if (gSubsystem.getAngle() < -2.0) {
      SmartDashboard.putBoolean("go left", false);
      SmartDashboard.putBoolean("go right",true);
      dSubsystem.arcadeDrive(0, -1);

    } else {

    }
    SmartDashboard.putNumber("ang",gSubsystem.getAngle());

  }

  @Override
  public boolean isFinished() {
    return false;
    //return (gSubsystem.getAngle() > -5 && gSubsystem.getAngle() < 5);
  }
}
