/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.TankDrive;

public class Align extends CommandBase {
    public static Limelight limelightsubsytem;
    public static TankDrive tankdrivesubsystem;

  public Align(Limelight sub,TankDrive subtwo) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    limelightsubsytem = sub;
    tankdrivesubsystem = subtwo;
    addRequirements(limelightsubsytem); 
    addRequirements(tankdrivesubsystem); 
    
  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    tankdrivesubsystem.limelightAlign();
    /*
  double offset = limelightsubsytem.getXOffset();
      if (offset < -1.5){
        tankdrivesubsystem.limelightAlign();
        //tankdrivesubsytem.turn(false);
      } else if(offset > 1.5){
        
        tankdrivesubsystem.limelightAlign();
        //tankdrivesubsytem.turn(true);
      } else {
        tankdrivesubsystem.stop();
        //return true;
      }
      */
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() { 
    return false;
  }

  // Called once after isFinished returns true
  protected void end() {
    tankdrivesubsystem.stop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  protected void interrupted() {
    
    tankdrivesubsystem.stop();
  }
}

