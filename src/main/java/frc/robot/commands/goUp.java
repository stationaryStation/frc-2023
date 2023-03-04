package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.ArmSubsystem;

public class goUp extends CommandBase {
    private final ArmSubsystem aSubsystem;
    
    /**
     * Command that moves the arm up in a constant velocity
     * 
     * @param a ArmSubsystem
     */
    public goUp(ArmSubsystem a) {
        aSubsystem = a;
        addRequirements(aSubsystem);
    }

    @Override
    public void execute() {
        aSubsystem.moveY(ArmConstants.upVel);
    }
}
