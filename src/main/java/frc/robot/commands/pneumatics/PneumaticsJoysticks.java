/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pneumatics;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.PneumaticsSubsystem;

public class PneumaticsJoysticks extends CommandBase {
  private static Timer timer = new Timer();
  //Subsystem the command runs on
  public static PneumaticsSubsystem subsystem;
    public PneumaticsJoysticks(PneumaticsSubsystem sub)
    {
        subsystem = sub;
        addRequirements(subsystem); 
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    /*

    This method only runs once: when this command is first scheduled
    Motor move method only needs to be called once, 
    because when the motor speed is set, it will not change unless it is set again

    Sets motor speed to 50%

    */
    timer.reset();
    timer.start();
    subsystem.rightpiston(Value.kReverse);
    subsystem.leftpiston(Value.kReverse);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //if(timer.get() > 15){
      SmartDashboard.putNumber("time", timer.get());
      subsystem.joystickpistons();
    //}
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Set the motor speed back to 0% (stop) when command is finished
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return false;
  }
}