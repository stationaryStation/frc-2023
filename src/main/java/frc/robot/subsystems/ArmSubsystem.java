package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    private final MotorControllerGroup yControllerGroup = new MotorControllerGroup(
            new WPI_TalonSRX(ArmConstants.topTalonSRXPort),
            new WPI_TalonSRX(ArmConstants.bottomTalonSRXPort));

    private final DoubleSolenoid solenoidGroup = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

    public ArmSubsystem() {
        yControllerGroup.setInverted(true);
    }

    /**
     * Moves the arm frame vertically
     */
    public void moveY(double vel) {
        yControllerGroup.set(vel);
    }

    /**
     * Moves the arm horizontally, true is forward, false is backwards
     * @param vel
     */
    public void moveX(boolean direction) {
        if (direction) {
            solenoidGroup.set(Value.kForward);
        } else {
            solenoidGroup.set(Value.kReverse);
        } 
    }

    public void stopY() {
        yControllerGroup.stopMotor();
    }

    public void stopX() {
        solenoidGroup.set(Value.kOff);
    }
}
