package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.GetPressure;
import frc.robot.subsystems.TankDrive;


public class PneumaticsSubsystem extends SubsystemBase {
    //Creates solenoid object
    //hi its me, natarichard :) ٩(♡ε♡ )۶ 

    public PneumaticsSubsystem() {  
        setDefaultCommand(new GetPressure(this));
    }
    AnalogInput pressureanalog = new AnalogInput(0);
    public void getpressure(){
        double voltage = pressureanalog.getVoltage();
        double pressure = (250 * (voltage/5)) - 25;
        SmartDashboard.putNumber("", pressure);
    }

    public void rightpiston (DoubleSolenoid.Value state){
        SmartDashboard.putString("Right Piston", state + "");

        RobotContainer.RightPiston.set(state);
    }
    
    public void leftpiston (DoubleSolenoid.Value state){
        SmartDashboard.putString("Left Piston", state + "");

        RobotContainer.LeftPiston.set(state);
    }

    @Override
    public void periodic() {
    // This method will be called once per scheduler run
        SmartDashboard.putNumber("Climb angle", TankDrive.ahrs.getPitch());
    }
}
