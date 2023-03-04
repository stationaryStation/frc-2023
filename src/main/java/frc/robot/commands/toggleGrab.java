package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class toggleGrab extends CommandBase {
    private final ArmSubsystem aSubsystem;
    
    /**
     * Toggles whether the claw should grab onto stuff.
     * 
     * @param a ArmSubsystem
     */
    public toggleGrab(ArmSubsystem a) {
        aSubsystem = a;
        addRequirements(aSubsystem);
    }

    @Override
    public void execute() {
        aSubsystem.toggleGrab();
    }
    @Override
    public boolean isFinished() {
      return true;
    }
}
