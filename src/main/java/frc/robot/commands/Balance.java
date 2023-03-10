package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants.BalancePIDConstatants;

public class Balance extends CommandBase {
  private final DriveSubsystem dSubsystem;
  private final GyroSubsystem gSubsystem;
  private final PIDController pid = new PIDController(BalancePIDConstatants.p, BalancePIDConstatants.i, BalancePIDConstatants.d);

  /**
   * Initialize Balance Command
   * 
   * @param drivetrain
   * @param gyro
   */
  public Balance(DriveSubsystem drivetrain, GyroSubsystem gyro) {
    dSubsystem = drivetrain;
    gSubsystem = gyro;
    addRequirements(dSubsystem, gSubsystem);
    pid.enableContinuousInput(-180, 180);
  }

  @Override
  public void initialize(){
    pid.reset();
  }
  // Everything inside of this execute function will run until it is finished or
  // when the command ends.
  @Override
  public void execute() {

    SmartDashboard.putNumber("pid output",pid.calculate(gSubsystem.getAngle(), 0));

    double speed = pid.calculate(gSubsystem.getAngle(), 0);
    double angle = gSubsystem.getAngle();


    dSubsystem.arcadeDrive(speed,0);


    SmartDashboard.putNumber("ang", gSubsystem.getAngle());

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
