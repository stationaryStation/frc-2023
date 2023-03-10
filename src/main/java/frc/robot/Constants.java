package frc.robot;

public final class Constants {
    /**
     * Constants related to the robot's drivetrain
     */
    public static final class DriveConstants {
        public static final int frontRightPort = 2;
        public static final int frontLeftPort = 3;
        public static final int rearRightPort = 1;
        public static final int rearLeftPort = 4;
        public static final double powerMultiplier = 0.7;
    }
    /**
     * Constants related to the auto Balance pid
     */
    public static final class BalancePIDConstatants{
        public static final double p = 0.1;
        public static final double i = 0.004;
        public static final double d = 0;
    }

    /*
     * Constants related to GetCone2Goal0 command
     */

     public static final class GetCone2Goal0Constants{
        public static final double fordwardTime1 = 2;
        public static final double releaseTime1 = 2;
        public static final double rspeed1 = 0.5;
        public static double rotateTime1 = 1;
     }

    /*
     * Constants related to GetCube2Goal0 command
     */

     public static final class GetCube2Goal0Constants{
        public static final double fordwardTime1 = 2;
        public static final double releaseTime1 = 2;
        public static final double rspeed1 = 0.5;
        public static double rotateTime1 = 1;
     }

    /*
    * Constants related to GetCube2Goal1 command
    */

    public static final class GetCube2Goal1Constants{
        public static double backwardTime1 = 2;
        public static double releaseTime1 = 2;
        public static double rotateTime1 = 1;
        public static double speed1 = 0.7;
        public static double armUpTime = 7;
        public static double rspeed1 = 0.5;
        public static double speed2 = -0.7;
        public static double armDown = 20;
     }

    /*
    * Constants related to GetToRamp command
    */

    public static final class GetToRampConstants{
        public static double speed1 = 0.7;
        public static double findRampTimeOut = 15;
        public static double triggerAngle = 10;
        public static double waitAfterOnRamp = 2;
     }

    /**
     * Constants related to the robot's arm
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
     * Constants related to external devices used to
     * drive the robot
     */
    public static final class DriverContstants {
        public static final int driverControllerPort = 0;
    }
}
