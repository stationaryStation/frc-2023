package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CamSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.math.controller.PIDController;


public class alignToTarget extends CommandBase {
    private final CamSubsystem aSubsystem;
    private final DriveSubsystem dSubsystem;
    private final PIDController pid = new PIDController(0.1, 0.04, 0);
    private final DriveSubsystem robotDrivetrain = new DriveSubsystem();

    
    public alignToTarget(CamSubsystem camS, DriveSubsystem drivetrain) {
        aSubsystem = camS;
        dSubsystem = drivetrain;
        addRequirements(aSubsystem, dSubsystem);
        pid.enableContinuousInput(-180, 180);

    }

    @Override
    public void execute() {
        robotDrivetrain.arcadeDrive(0, pid.calculate(aSubsystem.getY(),0));
    }
    @Override
    public boolean isFinished() {
      return false;
    }
}
