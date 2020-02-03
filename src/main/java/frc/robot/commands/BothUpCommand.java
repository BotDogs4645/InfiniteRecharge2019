package frc.robot.commands;


import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.PneumaticsSubsystem;

public class BothUpCommand extends CommandBase  
{
    
    public static PneumaticsSubsystem subsystem;
    public BothUpCommand(PneumaticsSubsystem sub)
    {
        subsystem = sub;
        addRequirements(subsystem); 
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize(){
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute()
    {   
        RobotContainer.m_pneumaticssubsytem.leftpiston(Value.kForward);
        RobotContainer.m_pneumaticssubsytem.rightpiston(Value.kForward);
    }

    // Make this return true when this Command no longer needs to run execute()
    public boolean isFinished()
    {
        return RobotContainer.mainstick.getRawButton(9);
    }

    // Called once after isFinished returns true
    protected void end()
    {
        RobotContainer.m_pneumaticssubsytem.leftpiston(Value.kOff);
        RobotContainer.m_pneumaticssubsytem.rightpiston(Value.kOff);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        RobotContainer.m_pneumaticssubsytem.leftpiston(Value.kOff);
        RobotContainer.m_pneumaticssubsytem.rightpiston(Value.kOff);
    }


} 