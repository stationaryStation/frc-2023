package frc.robot

import edu.wpi.first.wpilibj.Joystick
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX

/**
 * The VM is configured to automatically run this object (which basically functions as a singleton class),
 * and to call the functions corresponding to each mode, as described in the TimedRobot documentation.
 * This is written as an object rather than a class since there should only ever be a single instance, and
 * it cannot take any constructor arguments. This makes it a natural fit to be an object in Kotlin.
 *
 * If you change the name of this object or its package after creating this project, you must also update
 * the `Main.kt` file in the project. (If you use the IDE's Rename or Move refactorings when renaming the
 * object or package, it will get changed everywhere.)
 */
object Robot : TimedRobot()
{

    // Initialize Drivetrain Motors
    private val frontRightMotor: PWMTalonSRX = PWMTalonSRX(0)
    private val frontLeftMotor: PWMTalonSRX = PWMTalonSRX(1)
    private val rearRightMotor: PWMTalonSRX = PWMTalonSRX(2)
    private val rearLeftMotor: PWMTalonSRX = PWMTalonSRX(3)


    // Group Motors
    private val rightMotorGroup = MotorControllerGroup(frontRightMotor, rearRightMotor)
    private val leftMotorGroup = MotorControllerGroup(frontLeftMotor, rearLeftMotor)

    // Initialize DifferentialDrive
    private val diffDrive: DifferentialDrive = DifferentialDrive(rightMotorGroup, leftMotorGroup)

    // Initialize the controller
    private val controller: Joystick = Joystick(0)

    // Create a new timer
    private val timer: Timer = Timer()


    /**
     * This method is run when the robot is first started up and should be used for any
     * initialization code.
     */
    override fun robotInit()
    {
        rightMotorGroup.inverted = true
    }

    /**
     * This method is called every 20 ms, no matter the mode. Use this for items like
     * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
     *
     * This runs after the mode specific periodic methods, but before LiveWindow and
     * SmartDashboard integrated updating.
     */
    override fun robotPeriodic() {}

    override fun autonomousInit() {
        timer.reset()
        timer.start()
    }

    /** This method is called periodically during autonomous.  */
    override fun autonomousPeriodic() {
        TODO("Robot is not built yet")
    }


    /** This method is called once when teleop is enabled.  */
    override fun teleopInit() {}

    /** This method is called periodically during operator control.  */
    override fun teleopPeriodic() {
        diffDrive.tankDrive(-controller.y, -controller.x)
    }

    /** This method is called once when the robot is disabled.  */
    override fun disabledInit() {}

    /** This method is called periodically when disabled.  */
    override fun disabledPeriodic() {}

    /** This method is called once when test mode is enabled.  */
    override fun testInit() {}

    /** This method is called periodically during test mode.  */
    override fun testPeriodic() {}

    /** This method is called once when the robot is first started up.  */
    override fun simulationInit() {}

    /** This method is called periodically whilst in simulation.  */
    override fun simulationPeriodic() {}
}