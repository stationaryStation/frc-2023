package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.Timer;

public class GetCone2Goal0 extends CommandBase {
  private final DriveSubsystem dSubsystem;
  private final ArmSubsystem aSubsystem;

  private Timer timer = new Timer();
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
  public GetCone2Goal0(DriveSubsystem drivetrain, ArmSubsystem arm) {
    dSubsystem = drivetrain;
    aSubsystem = arm;
    addRequirements(dSubsystem, aSubsystem);
  }

  @Override
  public void initialize(){
    step = 0;
    timer.reset();
    timer.start();
  }

  // Everything inside of this execute function will run until it is finished or
  // when the command ends.
  @Override
  public void execute() {
    dSubsystem.arcadeDrive(speed, rspeed);
    SmartDashboard.putNumber("vel", speed);
    SmartDashboard.putNumber("time", timer.get());
    SmartDashboard.putNumber("step", step);
    
    if(step == 0){
      speed = 0.7;
      step+=1;
    }
    if (timer.advanceIfElapsed(fordwardTime1) == true && step == 1){
      speed = 0;
      rspeed = 0;
      step+=1;
    }
    if (step == 2){
      rspeed = 0.5;
      timer.reset();
      step+=1;
    }
    if (step == 3 && timer.advanceIfElapsed(rotateTime1) == true){
      step+=1;
      rspeed = 0;
    }
    if (step == 4){
      aSubsystem.setGrabberPos(false);
      step+=1;
      timer.reset();
    }
    if (step  == 5 && timer.advanceIfElapsed(releaseTime) == true){
      step+=1;
    }

  }

  @Override
  public boolean isFinished() {
      return false;
  }
}