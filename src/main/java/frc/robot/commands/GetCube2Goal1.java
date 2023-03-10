package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Constants.ArmConstants;
import frc.robot.Constants.GetCube2Goal1Constants;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.Timer;

public class GetCube2Goal1 extends CommandBase {
  private final DriveSubsystem dSubsystem;
  private final ArmSubsystem aSubsystem;

  private Timer timer = new Timer();
  private Timer armUpDownTimer = new Timer();

  private int step = 0;
  private double speed = 0;
  private double rspeed = 0;
  /**
   * Initialize Balance Command
   * 
   * @param drivetrain
   * @param 
   */
  public GetCube2Goal1(DriveSubsystem drivetrain, ArmSubsystem arm) {
    dSubsystem = drivetrain;
    aSubsystem = arm;
    addRequirements(dSubsystem, aSubsystem);
  }

  @Override
  public void initialize(){
    step = 0;
    timer.reset();
    armUpDownTimer.reset();
  }
  
  // Everything inside of this execute function will run until it is finished or
  // when the command ends.
  @Override
  public void execute() {
    dSubsystem.arcadeDrive(speed, rspeed);
    SmartDashboard.putNumber("vel", speed);
    SmartDashboard.putNumber("time", timer.get());
    SmartDashboard.putNumber("step", step);
    SmartDashboard.putNumber("armtimer", armUpDownTimer.get());
    
      
    if(step == 0){
      speed = GetCube2Goal1Constants.speed1;
      aSubsystem.moveY(ArmConstants.upVel);
      armUpDownTimer.start();
      timer.start();
      step+=1;
    }
    if (timer.hasElapsed(GetCube2Goal1Constants.backwardTime1) == true && step == 1){
      speed = 0;
      rspeed = 0;
      step+=1;
    }
    if (step == 2 && armUpDownTimer.hasElapsed(GetCube2Goal1Constants.armUpTime)){
      rspeed = GetCube2Goal1Constants.rspeed1;
      timer.reset();
      step+=1;
    }
    if (step == 3 && timer.hasElapsed(GetCube2Goal1Constants.rotateTime1) == true){
      step+=1;
      rspeed = 0;
      aSubsystem.setGrabberPos(false);
      timer.reset();
    }
    if (step  == 4 && timer.hasElapsed(GetCube2Goal1Constants.releaseTime1) == true){
      speed = GetCube2Goal1Constants.speed2;
      timer.restart();
      aSubsystem.moveY(ArmConstants.downVel);
      armUpDownTimer.reset();
      step+=1;
    }
    if (step == 5 && timer.hasElapsed(2)){
      speed = 0;
      step += 1;
    }
    if (step == 6 && armUpDownTimer.hasElapsed(GetCube2Goal1Constants.armDown)){
      aSubsystem.moveY(0);
      armUpDownTimer.reset();
      step+=1;
    }

  }

  @Override
  public boolean isFinished() {
      return false;
  }
}