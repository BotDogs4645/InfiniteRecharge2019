package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
    public AddressableLED m_led = new AddressableLED(0);
    public AddressableLEDBuffer m_ledBuffer = new AddressableLEDBuffer(5);
    public LEDSubsystem() {  
        
    }

    @Override
    public void periodic() {
        blueLEDS();
        m_led.setData(m_ledBuffer);
    }

    // Red LED buffer method (sets buffer defined in Robot.java to all red)
    public void redLEDS() {
        for (int i = 0; i < m_ledBuffer.getLength(); i++) {
            m_ledBuffer.setRGB(i, 128, 0, 0);
        }
    }

    // Blue LED buffer method (sets buffer defined in Robot.java to all blue)
    public void blueLEDS() {
        for (int i = 0; i < m_ledBuffer.getLength(); i++) {
            m_ledBuffer.setRGB(i, 0, 0, 128);
        }
    }

    // Chicago pattern LED buffer method
    /*public void chicago() {
        AddressableLED m_led = new AddressableLED(0);
        AddressableLEDBuffer chicagoBuffer = new AddressableLEDBuffer(5);
        m_led.setLength(chicagoBuffer.getLength());
        // loop through 3 colors
        for (int i = 0; int bluState = 0; i < chicagoBuffer.getLength(); bluState < 256; i++; bluState++) {
            chicagoBuffer.setRGB(i, 0, 0, bluState);
        }
        for (int i = 0; int bluState = 255; i < chicagoBuffer.getLength(); bluState > -1; i++; bluState--) {
            chicagoBuffer.setRGB(i, 0, 0, bluState);
        }
        for (int i = 0; int redState = 0; i < chicagoBuffer.getLength(); redState < 256; i++; redState++) {
            chicagoBuffer.setRGB(i, redState, 0, 0);
        }
        for (int i = 0; int redState = 255; i < chicagoBuffer.getLength(); redState > -1; i++; redState--) {
            chicagoBuffer.setRGB(i, redState, 0, 0);
        }        
        for (int i = 0; int whiteState = 0; i < chicagoBuffer.getLength(); whiteState < 256; i++; whiteState++) {
            chicagoBuffer.setRGB(i, whiteState, whiteState, whiteState);
        }
        for (int i = 0; int whiteState = 255; i < chicagoBuffer.getLength(); whiteState < 256; i++; whiteState--) {
            chicagoBuffer.setRGB(i, whiteState, whiteState, whiteState);
        }        
        m_led.setData(blueBuffer);
        m_led.start();
    }*/
    // public enum PinType { DigitalIO, PWM, AnalogIn, AnalogOut };
    /*public int getChannelFromPin( PinType type, int io_pin_number ) throws IllegalArgumentException {
        int roborio_channel = 0;
        if ( io_pin_number < 0 ) {
            throw new IllegalArgumentException("Error: Invalid navX-MXP I/O Pin #");
        }
        switch ( type ) {
            case PWM:
                if ( io_pin_number > 9 ) {
                    throw new IllegalArgumentException("Error:  Invalid navX-MXP Digital I/O Pin #");
                }
                roborio_channel = io_pin_number + 10;
                break;
        }
        return roborio_channel;
    }*/ 
}
