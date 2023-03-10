package frc.robot;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DriverContstants;
import frc.robot.commands.AutoBalance;
import frc.robot.commands.GetCube2Goal0;
import frc.robot.commands.GetCube2Goal1;
import frc.robot.commands.GetCone2Goal0;
import frc.robot.commands.Balance;
import frc.robot.commands.goDown;
import frc.robot.commands.goUp;
import frc.robot.commands.toggleX;
import frc.robot.commands.toggleGrab;
import frc.robot.commands.stopYArmMovement;
import frc.robot.commands.ResetGyro;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class RobotContainer {
    private final SlewRateLimiter acelLimiter = new SlewRateLimiter(1.3);

    // Initialize robot subsytems
    private final DriveSubsystem robotDrivetrain = new DriveSubsystem();
    private final GyroSubsystem gyroscope = new GyroSubsystem();
    private final ArmSubsystem arm = new ArmSubsystem();

    // Initialize the driver's controller
    CommandXboxController driverController = new CommandXboxController(DriverContstants.driverControllerPort);

    // Import Commands
    private Balance balanceCommand = new Balance(robotDrivetrain, gyroscope);
    private goUp upCommand = new goUp(arm);
    private goDown downCommand = new goDown(arm);
    private toggleX fordward = new toggleX(arm);
    private toggleGrab grab = new toggleGrab(arm);
    private stopYArmMovement stopYArm = new stopYArmMovement(arm);
    private ResetGyro resetGy = new ResetGyro(gyroscope);
    private final Command m_complexAuto = new AutoBalance(robotDrivetrain, arm, gyroscope);
    private final Command cubeTo0 = new GetCube2Goal0(robotDrivetrain, arm);
    private final Command cubeTo1 = new GetCube2Goal1(robotDrivetrain, arm);
    private final Command coneTo0 = new GetCone2Goal0(robotDrivetrain, arm);

    
    // A chooser for autonomous commands
    SendableChooser<Command> m_chooser = new SendableChooser<>();

    /**
     * The container for the robot. Contains subsystems, controllers devices and
     * commands
     */
    public RobotContainer() {
        // Configure bindings
        configureButtonBindings();

        robotDrivetrain.setDefaultCommand(Commands.run(
                () -> robotDrivetrain.arcadeDrive(-acelLimiter.calculate(driverController.getLeftY()), -driverController.getLeftX()),
                robotDrivetrain));

        
        // Add commands to the autonomous command chooser
        m_chooser.setDefaultOption("AutoBalance", m_complexAuto);
        m_chooser.addOption("cube on fisrt", cubeTo0);
        m_chooser.addOption("cone on fisrt", coneTo0);
        m_chooser.addOption("cube on second", cubeTo1);
            // Put the chooser on the dashboard
        Shuffleboard.getTab("Autonomous").add(m_chooser);
        // Put subsystems to dashboard.
        Shuffleboard.getTab("Drivetrain").add(robotDrivetrain);
        Shuffleboard.getTab("HatchSubsystem").add(arm);

    }

    /**
     * Configures bindings for the controller
     * See
     * https://docs.wpilib.org/en/stable/docs/software/commandbased/binding-commands-to-triggers
     */
    private void configureButtonBindings() {
        driverController.y().toggleOnTrue(balanceCommand);
        driverController.a().onTrue(fordward);
        driverController.b().onTrue(grab);
        driverController.povUp().onTrue(upCommand);
        driverController.povDown().onTrue(downCommand);
        driverController.x().toggleOnTrue(stopYArm);

        driverController.rightTrigger().toggleOnTrue(resetGy);
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
        return m_chooser.getSelected();
    }
}
