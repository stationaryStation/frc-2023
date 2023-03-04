package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class toggleX extends CommandBase {
    private final ArmSubsystem aSubsystem;
    
    /**
     * Toggles whether the arm should retract or expand.
     * 
     * @param a ArmSubsystem
     */
    public toggleX(ArmSubsystem a) {
        aSubsystem = a;
        addRequirements(aSubsystem);
    }

    @Override
    public void execute() {
        aSubsystem.toggleX();
    }
    @Override
    public boolean isFinished() {
      return true;
    }
}
