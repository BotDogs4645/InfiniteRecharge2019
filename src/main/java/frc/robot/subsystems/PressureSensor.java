package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.GetPressure;


public class PressureSensor extends SubsystemBase {
    //Creates solenoid object
    //hi its me, natarichard :) ٩(♡ε♡ )۶ 

    public PressureSensor() {  
        setDefaultCommand(new GetPressure(this));
    }
    
    
    AnalogInput pressureanalog = new AnalogInput(3);
    public void getpressure(){
        double voltage = pressureanalog.getVoltage();
        double pressure = (250 * (voltage/5)) - 25;
        SmartDashboard.putNumber("Analog Pressure", pressure);
    }
}
