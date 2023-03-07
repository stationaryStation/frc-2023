package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.GyroSubsystem;

public class ResetGyro extends CommandBase {
  private final GyroSubsystem gSubsystem;

  /**
   * Initialize Balance Command
   * 
   * @param drivetrain
   * @param gyro
   */
  public ResetGyro(GyroSubsystem gyro) {
    gSubsystem = gyro;
    addRequirements(gSubsystem);
  }


  // Everything inside of this execute function will run until it is finished or
  // when the command ends.
  @Override
  public void execute() {
    gSubsystem.reset();
  }

  @Override
  public boolean isFinished() {
    return true;
  }
}
