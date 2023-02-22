package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class stopXArmMovement extends CommandBase {
    private final ArmSubsystem aSubsystem;
    
    public stopXArmMovement(ArmSubsystem a) {
        aSubsystem = a;
        addRequirements(aSubsystem);
    }

    @Override
    public void execute() {
        aSubsystem.stopX();
    }
}
