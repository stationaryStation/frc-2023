package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.math.controller.PIDController;




public class Balance extends CommandBase {
  private final DriveSubsystem dSubsystem;
  private final GyroSubsystem gSubsystem;
  private final PIDController pid = new PIDController(0.1, 0.04, 0);


  /**
   * Initialize Balance Command
   * @param drivetrain
   * @param gyro
   */
  public Balance(DriveSubsystem drivetrain, GyroSubsystem gyro) {
    dSubsystem = drivetrain;
    gSubsystem = gyro;
    addRequirements(dSubsystem, gSubsystem);
    pid.enableContinuousInput(-180, 180);
  }

  // Everything inside of this execute function will run until it is finished or
  // when the command ends.
  @Override
  public void execute() {
    
    SmartDashboard.putNumber("pid output",-1*pid.calculate(gSubsystem.getAngle(),0));
    
    dSubsystem.arcadeDrive(0,-1*pid.calculate(gSubsystem.getAngle(),0));

    SmartDashboard.putNumber("ang",gSubsystem.getAngle());

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
