/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IRSensor;
import frc.robot.subsystems.IntakeMotor;

public class ManualIntake extends CommandBase {
  
  //Subsystem the command runs on
  private final IntakeMotor subsystem;
  private final IRSensor indexerSub;
  private final double speed;

  public ManualIntake(IntakeMotor intakemotorSub, IRSensor pIndexerSub,double pSpeed) {
    subsystem = intakemotorSub;
    speed = pSpeed;
    indexerSub = pIndexerSub;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    addRequirements(indexerSub);

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
    subsystem.move(speed);

    if (speed < 0) {
      RobotContainer.ShooterMotor.set(speed*.5);
    } else {
      RobotContainer.ShooterMotor.set(speed);

    }
    RobotContainer.IndexerMotor.set(speed);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //Set the motor speed back to 0% (stop) when command is finished
    RobotContainer.ShooterMotor.set(0);
    RobotContainer.IndexerMotor.set(0);
    subsystem.move(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    
    return false;
  }
}
