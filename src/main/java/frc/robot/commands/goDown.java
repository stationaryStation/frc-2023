package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

public class goDown extends CommandBase {
    private final ArmSubsystem aSubsystem;

    /**
     * Command that moves the arm down slowly by applying a really low amount of
     * upwards velocity.
     * 
     * @param a ArmSubsystem
     */
    public goDown(ArmSubsystem a) {
        aSubsystem = a;
        addRequirements(aSubsystem);
    }

    @Override
    public void execute() {
        aSubsystem.moveY(ArmConstants.downVel);
    }
}
