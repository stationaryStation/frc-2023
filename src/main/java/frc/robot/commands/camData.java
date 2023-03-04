package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.CamSubsystem;

public class camData extends CommandBase {
    private final CamSubsystem aSubsystem;
    
    public camData(CamSubsystem a) {
        aSubsystem = a;
        addRequirements(aSubsystem);
    }

    @Override
    public void execute() {
        aSubsystem.refreshDashBoard();
    }
    @Override
    public boolean isFinished() {
      return false;
    }
}
