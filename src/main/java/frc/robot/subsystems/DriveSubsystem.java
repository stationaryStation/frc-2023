package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsystem extends SubsystemBase {
    // Left side motors
    private final MotorControllerGroup leftMotors = new MotorControllerGroup(
            new WPI_TalonSRX(DriveConstants.frontLeftPort),
            new WPI_TalonSRX(DriveConstants.rearLeftPort));
    // Right side motors
    private final MotorControllerGroup rightMotors = new MotorControllerGroup(
            new WPI_TalonSRX(DriveConstants.frontRightPort),
            new WPI_TalonSRX(DriveConstants.rearRightPort));
    // Robot's drivetrain
    private final DifferentialDrive drivetrain = new DifferentialDrive(leftMotors, rightMotors);

    /** Creates a new DriveSubsystem */
    public DriveSubsystem() {
        rightMotors.setInverted(true);

        // Enable safety to avoid errors during matches
        drivetrain.setSafetyEnabled(true);
        drivetrain.setExpiration(.1);
        drivetrain.feed();

        // Add velocity limit
        drivetrain.setMaxOutput(.3);
    }

    /**
     * Drives the robot using tank-like controls using
     * {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}.
     * 
     * @param left_pwr
     * @param right_pwr
     */
    public void tankDrive(double left_pwr, double right_pwr) {
        drivetrain.tankDrive(left_pwr, right_pwr);
    }

    /**
     * Drives the robot using arcade-like controls using
     * {@link edu.wpi.first.wpilibj.drive.DifferentialDrive}
     * 
     * @param xSpeed
     * @param zSpeed
     */
    public void arcadeDrive(double xSpeed, double zSpeed) {
        drivetrain.arcadeDrive(xSpeed, zSpeed);
    }

    /**
     * Sets the max output of the drive. Useful for scaling the drive to drive more
     * slowly.
     *
     * @param maxOutput the maximum output to which the drive will be constrained
     */
    public void setMaxOutput(double maxOutput) {
        drivetrain.setMaxOutput(maxOutput);
    }

    /** Stops the motors in the drivetrain */
    public void stopMotors() {
        drivetrain.stopMotor();
    }

}
