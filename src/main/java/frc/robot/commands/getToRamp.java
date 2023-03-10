package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.GetToRampConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.Timer;

public class getToRamp extends CommandBase {
  private final DriveSubsystem dSubsystem;
  private final ArmSubsystem aSubsystem;
  private final GyroSubsystem gSubsystem;

  private Timer timer = new Timer();
  private Timer findRampTimeOut = new Timer();

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
      speed = GetToRampConstants.speed1;
      findRampTimeOut.start();
      step+=1;
    }
    if (step == 1){
      if (findRampTimeOut.hasElapsed(GetToRampConstants.findRampTimeOut)){
        speed = 0;
        step = -1;
      } else if(gSubsystem.getRawAngle() > GetToRampConstants.triggerAngle || gSubsystem.getRawAngle() < -GetToRampConstants.triggerAngle){
          speed = 0;
          step+=1;
        }
      }
      if (step == 2){
        step+=1;
        timer.reset();
      }
      if (step == 3 && timer.hasElapsed(GetToRampConstants.waitAfterOnRamp)){
        step +=1;
      }
  }

  @Override
  public boolean isFinished() {
      return step == 4;
  }
}