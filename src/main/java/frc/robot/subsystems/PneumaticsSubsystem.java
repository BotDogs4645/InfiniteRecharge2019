package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.pneumatics.PneumaticsJoysticks;


public class PneumaticsSubsystem extends SubsystemBase {
    //Creates solenoid object
    //hi its me, natarichard :) ٩(♡ε♡ )۶ 
    
    Boolean onoroff = false;
    //if onoroff true that means controls are enabled
    //if onoroff false that means controls are disabled

    public PneumaticsSubsystem() {  
        setDefaultCommand(new PneumaticsJoysticks(this));
    }

    public void joystickpistons(){
        double leftstickY = -1 * RobotContainer.Xbox.getRawAxis(1);
        double rightstickY = -1 * RobotContainer.Xbox.getRawAxis(5);

        DoubleSolenoid.Value leftstate;
        if (leftstickY > .9){
            leftstate = Value.kForward;
        }
        else if (leftstickY < -.9){
            leftstate = Value.kReverse;
        }
        else{
            leftstate = Value.kOff;
        }
        DoubleSolenoid.Value rightstate;
        if (rightstickY > .9){
            rightstate = Value.kForward;
        }
        else if (rightstickY < -.9){
            rightstate = Value.kReverse;
        }
        else{
            rightstate = Value.kOff;
        }
        

        SmartDashboard.putBoolean("Pneumatics Controls onoroff", onoroff);

        if (onoroff){
        SmartDashboard.putString("Left Piston", leftstate + "");
        SmartDashboard.putString("Right Piston", rightstate + "");

        RobotContainer.LeftPiston.set(leftstate);
        RobotContainer.RightPiston.set(rightstate);
        }
        else{
        leftpiston(Value.kOff);
        rightpiston(Value.kOff);
        }
    }


    public void toggle (){

        if (!onoroff){
            onoroff = true;
        }
        else
        {
            onoroff = false;
        }
        SmartDashboard.putBoolean("onorofoff", onoroff);
        
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
