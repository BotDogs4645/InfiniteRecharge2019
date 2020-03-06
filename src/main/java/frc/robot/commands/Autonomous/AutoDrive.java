/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.TankDrive;

public class AutoDrive extends CommandBase {
  /**
   * Creates a new AutoDrive.
   */
  TankDrive subsystem;
  private double forward;
  private double turn;
  public AutoDrive(double pForward, double pTurn) {
    // Use addRequirements() here to declare subsystem dependencies.
    subsystem = RobotContainer.tankDriveSubsystem;
    forward =pForward;
    turn = pTurn;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    subsystem.move(forward,turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem.tankDriveVolts(0,0);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
