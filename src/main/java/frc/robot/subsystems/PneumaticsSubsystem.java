package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;


public class PneumaticsSubsystem extends SubsystemBase {
    //Creates solenoid object
    //hi its me, natarichard :) ٩(♡ε♡ )۶ 

    public PneumaticsSubsystem() {  
        
    }
    
    public void getpistonsstatus (){
    }
    public void rightpiston (DoubleSolenoid.Value state){
        SmartDashboard.putString("Right Piston", state + "");

        RobotContainer.RightPiston.set(state);
    }
    
    public void leftpiston (DoubleSolenoid.Value state){
        SmartDashboard.putString("Left Piston", state + "");

        RobotContainer.LeftPiston.set(state);
    }
}
