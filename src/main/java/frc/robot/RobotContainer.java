package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriverContstants;
import frc.robot.commands.PlatformBalance;
import frc.robot.commands.goDown;
import frc.robot.commands.goUp;
import frc.robot.commands.toggleX;
import frc.robot.commands.toggleGrab;
import frc.robot.commands.stopArmMotors;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class RobotContainer {
    // Initialize robot subsytems
    private final DriveSubsystem robotDrivetrain = new DriveSubsystem();
    private final GyroSubsystem gyroscope = new GyroSubsystem();
    private final ArmSubsystem arm = new ArmSubsystem();

    // Initialize the driver's controller
    CommandXboxController driverController = new CommandXboxController(DriverContstants.driverControllerPort);

    // Import Commands
    private PlatformBalance balanceCommand = new PlatformBalance(robotDrivetrain, gyroscope);
    private goUp upCommand = new goUp(arm);
    private goDown downCommand = new goDown(arm);
    private toggleX forwardCommand = new toggleX(arm);
    private toggleGrab grabCommand = new toggleGrab(arm);
    private stopArmMotors stopArmCommand = new stopArmMotors(arm);

    /**
     * The container for the robot. Contains subsystems, controllers devices and
     * commands
     */
    public RobotContainer() {
        // Configure bindings
        configureButtonBindings();

        robotDrivetrain.setDefaultCommand(Commands.run(
                () -> robotDrivetrain.arcadeDrive(-driverController.getLeftY(), -driverController.getLeftX()),
                robotDrivetrain));
    }

    /**
     * Configures bindings for the controller
     * See
     * https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers
     */
    private void configureButtonBindings() {
        driverController.a().onTrue(forwardCommand);
        driverController.b().onTrue(grabCommand);
        driverController.povUp().onTrue(upCommand);
        driverController.povDown().onTrue(downCommand);
        driverController.x().toggleOnTrue(stopArmCommand);
        // TODO: Find a button that is available for the balance command.
    }
}
