/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.RunIntake;

public class IntakeMotor extends SubsystemBase {
  /**
   * Creates a new Motor.
   */
  private final WPI_TalonSRX motor = new WPI_TalonSRX(4);

  private final double speed;

  public IntakeMotor() {
    speed = 0.7;
    setDefaultCommand(new RunIntake(this));
  }

  public void move(double pSpeed) {

    motor.set(pSpeed);
  }

  

  public void controlledIntake() {
    int pov = RobotContainer.Xbox.getPOV();
    if (pov == 0) {
      move(speed);
    } else if (pov == 180) {
      move(-speed);
    } else {
      move(0);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
