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
        double angle = gyroscope.getAngle() % 360;

        if ( angle > 0 ){
            angle = angle % 360;
            if ( angle > 180 ){
                angle = angle - 360;
            }
        } else if ( angle < 0 ){
            if ( angle < -180 ){
                angle = 360 + angle;
            }
        }
        return angle;
    }
}
