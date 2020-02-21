package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {
    public LEDSubsystem() {  
        
    }

    @Override
    public void periodic() {

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

    public void chicagoLEDS() {
        AddressableLED m_led = new AddressableLED(0);
        AddressableLEDBuffer chicagoBuffer = new AddressableLEDBuffer(5);
        m_led.setLength(chicagoBuffer.getLength());
    }
}