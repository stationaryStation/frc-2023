package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class stopArmMotors extends CommandBase {
    private final ArmSubsystem aSubsystem;
    
    public stopArmMotors(ArmSubsystem a) {
        aSubsystem = a;
        addRequirements(aSubsystem);
    }

    @Override
    public void execute() {
        aSubsystem.stopY();
    }
}
