package frc.robot;

public final class Constants {
    /**
     * Contstants related to the robot's drivetrain
     */
    public static final class DriveConstants {
        public static final int frontRightPort = 2;
        public static final int frontLeftPort = 3;
        public static final int rearRightPort = 1;
        public static final int rearLeftPort = 4;
    }

    /**
     * Contstants related to the robot's arm
     */
    public static final class ArmConstants {
        public static final int topTalonSRXPort = 5;
        public static final int bottomTalonSRXPort = 6;
        public static final double upVel = .3;
        public static final double downVel = .06;
        public static final double horizonalVel = 1;
        public static final int armForwardChannel = 4;
        public static final int armReverseChannel = 5;
        public static final int clawForwardChannel = 2;
        public static final int clawReverseChannel = 3;
    }

    /**
     * Contstants related to external devices used to
     * drive the robot
     */
    public static final class DriverContstants {
        public static final int driverControllerPort = 0;
    }
}
