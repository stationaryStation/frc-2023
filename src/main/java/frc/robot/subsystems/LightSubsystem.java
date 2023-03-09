package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LightSubsystem extends SubsystemBase {
    private final Relay Red = new Relay(7);
    private final Relay Green = new Relay(8);
    private final Relay Blue = new Relay(9);

    /**
     * Initialize the Light Subsystem
     */
    public LightSubsystem() {
        Red.set(Relay.Value.kOn);
        Green.set(Relay.Value.kOn);
        Blue.set(Relay.Value.kOn);
    }

    /**
     * Change Led Relay Values
     * 
     * You need to feed it {@link edu.wpi.first.wpilibj.Relay.Value}
     * 
     * @param red
     * @param green
     * @param blue
     */
    public void changeLeds(Relay.Value red, Relay.Value green, Relay.Value blue) {
        Red.set(red);
        Green.set(green);
        Blue.set(blue);
    }
    
}
