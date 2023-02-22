# Team Force 2023 Codebase
Code generated using WPILib

## Commands

Run commands using `./gradlew` or the [official WPILib Extension](https://github.com/wpilibsuite/vscode-wpilib)

| command | action                            |
|---------|-----------------------------------|
| deploy  | send code to robot                |
| build   | download deps and build java code |

## Creating New Commands

To create a new command, create a new file in `src/main/java/frc/robot/commands` and make a class that extends `CommandBase`. Then add the needed subsytems (aka. Parts of the robot you want to manipulate) to the class.

```java
private final DriveSubsystem drivetrain;

public CommandNameHere(DriveSubsystem d) {
    drivetrain = d;
    addRequirements(drivetrain);
}
```

Functions in `public void execute()` run constantly, use `@Override`

## Contributors

| user               | contributions    |
|--------------------|------------------|
| @stationaryStation | repo owner, base |
| @LewisMojica       | #1, #5           |
| @teamforcerd       | bug fixes        |