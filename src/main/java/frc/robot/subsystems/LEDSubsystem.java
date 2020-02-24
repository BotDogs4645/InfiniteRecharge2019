package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
    public LEDSubsystem() {  
        
    }

    @Override
    public void periodic() {
        chicago();
        m_led.setData(m_ledBuffer);
    }

    public void redLEDS() {
        AddressableLED m_led = new AddressableLED(0);
        AddressableLEDBuffer redBuffer = new AddressableLEDBuffer(5);
        m_led.setLength(redBuffer.getLength());
        for (int i = 0; i < redBuffer.getLength(); i++) {
            redBuffer.setRGB(i, 255, 0, 0);
        }
        m_led.setData(redBuffer);
        m_led.start();
    }

    public void blueLEDS() {
        AddressableLED m_led = new AddressableLED(0);
        AddressableLEDBuffer blueBuffer = new AddressableLEDBuffer(5);
        m_led.setLength(blueBuffer.getLength());
        for (int i = 0; i < blueBuffer.getLength(); i++) {
            blueBuffer.setRGB(i, 0, 0, 255);
        }
        m_led.setData(blueBuffer);
        m_led.start();
    }

    public void chicago() {
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
    }
}
