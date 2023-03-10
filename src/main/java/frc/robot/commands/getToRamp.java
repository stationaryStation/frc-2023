package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.interfaces.Gyro;

public class getToRamp extends CommandBase {
  private final DriveSubsystem dSubsystem;
  private final ArmSubsystem aSubsystem;
  private final GyroSubsystem gSubsystem;

  private Timer timer = new Timer();
  private Timer findRampTimeOut = new Timer();
  private final int fordwardTime1 = 2;
  private final int releaseTime = 2;

  private final int rotateTime1 = 1;

  private int step = 0;
  private double speed = 0;
  private double rspeed = 0;
  /**
   * Initialize Balance Command
   * 
   * @param drivetrain
   * @param 
   */
  public getToRamp(DriveSubsystem drivetrain, ArmSubsystem arm, GyroSubsystem gyro) {
    dSubsystem = drivetrain;
    aSubsystem = arm;
    gSubsystem = gyro;
    addRequirements(dSubsystem, aSubsystem);
  }

  @Override
  public void initialize(){
    step = 0;
    timer.reset();
    timer.start();
    findRampTimeOut.reset();
  }

  // Everything inside of this execute function will run until it is finished or
  // when the command ends.
  @Override
  public void execute() {
    dSubsystem.arcadeDrive(speed, rspeed);
    SmartDashboard.putNumber("vel", speed);
    SmartDashboard.putNumber("time", timer.get());
    SmartDashboard.putNumber("timeout", findRampTimeOut.get());
    SmartDashboard.putNumber("step", step);
    SmartDashboard.putNumber("gyro", gSubsystem.getRawAngle());
    
    if(step == 0){
      speed = 0.7;
      findRampTimeOut.start();
      step+=1;
    }
    if (step == 1){
      if (findRampTimeOut.hasElapsed(15)){
        speed = 0;
        step = -1;
      } else if(gSubsystem.getRawAngle() > 10 || gSubsystem.getRawAngle() < -10){
          speed = 0;
          step+=1;
        }
      }
      if (step == 2){
        step+=1;
        timer.reset();
      }
      if (step == 3 && timer.hasElapsed(2)){
        step +=1;
      }
  }

  @Override
  public boolean isFinished() {
      return step == 4;
  }
}