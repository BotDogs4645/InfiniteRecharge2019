package frc.robot.commands.pneumatics;


import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.PneumaticsSubsystem;

public class BothOffCommand extends CommandBase  
{
    
    public static PneumaticsSubsystem subsystem;
    public BothOffCommand(PneumaticsSubsystem sub)
    {
        subsystem = sub;
        addRequirements(subsystem); 
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize(){
        //RobotContainer.m_pneumaticssubsytem.leftpiston(Value.kOff);
       //RobotContainer.m_pneumaticssubsytem.rightpiston(Value.kOff);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute()
    {   
        
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished()
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end()
    {

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        
    }


} 