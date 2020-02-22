/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.RunShooter;

public class Shooter extends SubsystemBase {
  /**
   * Creates a new Motor.
   */
  private final WPI_TalonSRX motor1 = new WPI_TalonSRX(Constants.shooterMotor1);
  private final WPI_TalonSRX motor2 = new WPI_TalonSRX(Constants.shooterMotor2);

  private final SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(Constants.shooterKS, Constants.shooterVS);


  private final PIDController shooterpid = new PIDController(Constants.shooterP,Constants.shooterI,Constants.shooterD);
  private boolean shooting;
  
  public Shooter() {
    motor2.setInverted(true);
    motor2.follow(motor1);
    shooterpid.setTolerance(Constants.shooterPIDTolerance);
    shooting = false;
    //setDefaultCommand(new RunShooter(this, Constants.shooterTargetRPM));
  }

  public void move(double targetRPM) {
    if (shooting) {
      shooterpid.setSetpoint(targetRPM);
      double ffvalue = feedforward.calculate(targetRPM);
      double pidvalue = shooterpid.calculate(getRPM(), targetRPM);
      double voltage = ffvalue+pidvalue;

      SmartDashboard.putNumber("feedforward", ffvalue);
      SmartDashboard.putNumber("pid", pidvalue);
      SmartDashboard.putNumber("voltage", voltage);
      SmartDashboard.putNumber("RPM", getRPM());


      motor1.setVoltage(voltage);
      
    }
  }

  public double getRPM() {
    //sensor velocity measured in counts/100ms
    double RPM = (
     (motor1.getSelectedSensorVelocity()/100) //counts/ms
      *60000                                  //counts/min
      /1024                                   //revolutions/min
    );
    return RPM;
  }

  public void stopShooting() {
    shooting = false;
    motor1.setVoltage(0);
  }
  public void startShooting() {
    shooterpid.reset();
    shooting = true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
