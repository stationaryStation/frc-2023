package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriverContstants;
import frc.robot.subsystems.DriveSubsystem;

public class RobotContainer {
    // Initialize robot subsytems
    private final DriveSubsystem robotDrivetrain = new DriveSubsystem();

    // Initialize the driver's controller
    CommandXboxController driverController = new CommandXboxController(DriverContstants.driverControllerPort);

    /**
     * The container for the robot. Contains subsystems, controllers devices and
     * commands
     */
    public RobotContainer() {
        // Configure bindings
        configureButtonBindings();

        robotDrivetrain.setDefaultCommand(Commands.run(
                () -> robotDrivetrain.tankDrive(driverController.getLeftY(), driverController.getRightY()),
                robotDrivetrain));
    }

    private void configureButtonBindings() {
        // Configure bindings to commands here
    }
}
