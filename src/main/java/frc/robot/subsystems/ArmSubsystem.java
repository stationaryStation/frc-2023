package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;
import edu.wpi.first.wpilibj.Compressor;

public class ArmSubsystem extends SubsystemBase {
    private final MotorControllerGroup yControllerGroup = new MotorControllerGroup(
            new WPI_TalonSRX(ArmConstants.topTalonSRXPort),
            new WPI_TalonSRX(ArmConstants.bottomTalonSRXPort));

    private final Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.CTREPCM);
    private final DoubleSolenoid armDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 4, 5);
    private final DoubleSolenoid grabDoubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

    
    
    public ArmSubsystem() {
        yControllerGroup.setInverted(true);
        armDoubleSolenoid.set(kReverse);
        grabDoubleSolenoid.set(kReverse);
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
    public void toggleX() {
        armDoubleSolenoid.toggle();
    }

    public void toggleGrab() {
        grabDoubleSolenoid.toggle();
    }

    public void stopY() {
        yControllerGroup.stopMotor();
    }

    public void stopX() {
        armDoubleSolenoid.set(kOff);
    }
}
