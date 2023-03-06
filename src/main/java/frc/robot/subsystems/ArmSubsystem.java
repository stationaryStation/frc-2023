package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    private final MotorControllerGroup yControllerGroup = new MotorControllerGroup(
            new WPI_TalonSRX(ArmConstants.topTalonSRXPort),
            new WPI_TalonSRX(ArmConstants.bottomTalonSRXPort));

    private final DoubleSolenoid armDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, ArmConstants.armForwardChannel, ArmConstants.armReverseChannel);
    private final DoubleSolenoid grabDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, ArmConstants.clawForwardChannel, ArmConstants.clawReverseChannel);

    
    /**
     *
     * Initialize the arm's subsystem.
     *
     */
    public ArmSubsystem() {
        yControllerGroup.setInverted(true);
        armDoubleSolenoid.set(kReverse);
        grabDoubleSolenoid.set(kReverse);
    }

    /**
     * Moves the arm frame vertically
     * 
     * @param vel
     */
    public void moveY(double vel) {
        yControllerGroup.set(vel);
    }

    /**
     * Moves the arm horizontally, true is forward, false is backwards
     * @param vel
     */
    public void toggleX() {
        armDoubleSolenoid.toggle();
    }

    /**
     * Toggles the claw movement
     */
    public void toggleGrab() {
        grabDoubleSolenoid.toggle();
    }

    /**
     * Stops the arm frame motors
     */
    public void stopY() {
        yControllerGroup.stopMotor();
    }
}
