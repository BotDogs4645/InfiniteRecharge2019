/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Shooter;

public class RunShooter extends CommandBase {
  
  //Subsystem the command runs on
  private final Shooter motorSub;
  private final double target;

  public RunShooter(Shooter pMotorSub, double targetRPM) {
    motorSub = pMotorSub;
    target = targetRPM;
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

    

    */
    motorSub.startShooting();
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    motorSub.move(target);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    motorSub.stopShooting();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
