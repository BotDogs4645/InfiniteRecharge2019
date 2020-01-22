/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Motor;

public class MoveMotor extends CommandBase {
  
  //Subsystem the command runs on
  private final Motor motorSub;

  public MoveMotor(Motor pMotorSub) {
    motorSub = pMotorSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(motorSub);
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
    motorSub.move(0.5);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Set the motor speed back to 0% (stop) when command is finished
    motorSub.move(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return false;
  }
}
