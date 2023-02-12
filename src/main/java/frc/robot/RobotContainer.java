package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriverContstants;
import frc.robot.commands.Balance;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class RobotContainer {
    // Initialize robot subsytems
    private final DriveSubsystem robotDrivetrain = new DriveSubsystem();
    private final GyroSubsystem gyroscope = new GyroSubsystem();

    // Initialize the driver's controller
    CommandXboxController driverController = new CommandXboxController(DriverContstants.driverControllerPort);

    // Import Balance Command
    private Balance balanceCommand = new Balance(robotDrivetrain, gyroscope);

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
     * See https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers
     */
    private void configureButtonBindings() {
        driverController.a().toggleOnTrue(balanceCommand);
    }
}
