package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class ArmSubsystem extends SubsystemBase {
    private final MotorControllerGroup yControllerGroup = new MotorControllerGroup(
            new WPI_TalonSRX(ArmConstants.topTalonSRXPort),
            new WPI_TalonSRX(ArmConstants.bottomTalonSRXPort));

    private final MotorControllerGroup xControllerGroup = new MotorControllerGroup(
            new WPI_TalonSRX(ArmConstants.xTalonSRXPort1),
            new WPI_TalonSRX(ArmConstants.xTalonSRXPort2));

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
     * Moves the arm horizontally
     * @param vel
     */
    public void moveX(double vel) {
        xControllerGroup.set(vel);
    }

    public void stopY() {
        yControllerGroup.stopMotor();
    }

    public void stopX() {
        xControllerGroup.stopMotor();
    }
}
