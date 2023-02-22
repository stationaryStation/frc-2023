package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class moveBackward extends CommandBase {
    private final ArmSubsystem aSubsystem;
    
    public moveBackward(ArmSubsystem a) {
        aSubsystem = a;
        addRequirements(aSubsystem);
    }

    @Override
    public void execute() {
        aSubsystem.moveX(false);
    }
}
