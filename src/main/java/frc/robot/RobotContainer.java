package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.DriverContstants;
import frc.robot.commands.Balance;
import frc.robot.commands.goDown;
import frc.robot.commands.goUp;
import frc.robot.commands.toggleX;
import frc.robot.commands.toggleGrab;
import frc.robot.commands.stopYArmMovement;
import frc.robot.commands.camData;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.CamSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class RobotContainer {
    // Initialize robot subsytems
    private final DriveSubsystem robotDrivetrain = new DriveSubsystem();
    private final GyroSubsystem gyroscope = new GyroSubsystem();
    private final ArmSubsystem arm = new ArmSubsystem();
    private final CamSubsystem cam = new CamSubsystem();

    // Initialize the driver's controller
    CommandXboxController driverController = new CommandXboxController(DriverContstants.driverControllerPort);

    // Import Commands
    private Balance balanceCommand = new Balance(robotDrivetrain, gyroscope);
    private goUp upCommand = new goUp(arm);
    private goDown downCommand = new goDown(arm);
    private toggleX fordward = new toggleX(arm);
    private toggleGrab grab = new toggleGrab(arm);
    private stopYArmMovement stopYArm = new stopYArmMovement(arm);

    private stopXArmMovement stopXArm = new stopXArmMovement(arm);
    private camData sendCamData = new camData(cam);


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
        driverController.y().toggleOnTrue(sendCamData);
        driverController.a().onTrue(fordward);
        driverController.b().onTrue(grab);
        driverController.povUp().onTrue(upCommand);
        driverController.povDown().onTrue(downCommand);
        driverController.x().toggleOnTrue(stopYArm);
    }
}
