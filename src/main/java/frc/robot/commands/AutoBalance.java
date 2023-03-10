package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class AutoBalance extends SequentialCommandGroup {
  /**
   * Creates a new ComplexAuto.
   *
   * @param drive The drive subsystem this command will run on
   * @param hatch The hatch subsystem this command will run on
   */
  public AutoBalance(DriveSubsystem drivetrain, ArmSubsystem arm, GyroSubsystem gyro) {
    addCommands(
        new getToRamp(drivetrain, arm, gyro),
        new Balance(drivetrain,gyro));
  }
}