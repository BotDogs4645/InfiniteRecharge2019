/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.subsystems.LEDSubsystem;

public class LEDS extends CommandBase {
  
  private final LEDSubsystem implementedSubsystem;
  public LEDS(LEDSubsystem subsystem) {
    implementedSubsystem = subsystem;
    addRequirements(implementedSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue) {
      RobotContainer.ledSubsystemObject.blueLEDS();
    } else if (DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Red) {
      RobotContainer.ledSubsystemObject.redLEDS();
    } else {
      RobotContainer.ledSubsystemObject.chicagoLEDS();
    }*/
    /*RobotContainer.ledSubsystemObject.blueLEDS();
    Robot.m_led.setData(Robot.m_ledBuffer);*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}