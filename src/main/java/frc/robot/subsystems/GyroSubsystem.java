package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class GyroSubsystem extends SubsystemBase {
    private ADXRS450_Gyro gyroscope = new ADXRS450_Gyro();

    /** Creates a new GyroSubsystem */
    public GyroSubsystem() {
        //gyroscope.reset();
    }

    /**
     * Returns the gyroscope's current angle
     * 
     * @return angle
     */
    public double getAngle() {
        return gyroscope.getAngle();
    }

    /**
     * Checks if the robot is balanced
     * 
     * @return status
     */
    public boolean isBalanced() {
        if (gyroscope.getAngle() > 5 || gyroscope.getAngle() < -5) {
            return false;
        } else {
            return true;
        }
    }
}
