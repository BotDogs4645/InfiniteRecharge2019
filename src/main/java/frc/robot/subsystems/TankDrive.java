package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.smartdashboard.*;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;



public class TankDrive extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */
  public final PIDController pid = new PIDController(1, 0, 0);
  public final AHRS ahrs = new AHRS();
  public final WPI_TalonSRX talon = new WPI_TalonSRX(0);  
  
  public TankDrive() {
    setDefaultCommand(new DriveCommand(this));
    pid.setTolerance(128); //Error is within 1/8 of a revolution
    
    
  }


  public void driveWithJoystick() {
    //ONE JOYSTICK
    //make sure throttle is at 1 or -1
    double forward = (RobotContainer.stick.getY())*.8;
    double turn = (RobotContainer.stick.getZ())*.8;

    /*deadband*/
    
    if ((Math.abs(forward)<0.05) && (Math.abs(turn)<0.05))
    {
      stop();
    }

    else 
    {
      RobotContainer.difDrive.arcadeDrive(forward, turn);
    }
    
    
  }
  
  

  public void stop() {
    RobotContainer.difDrive.arcadeDrive(0, 0);
  }
  


  public void driveDistance(double distance) {
    double count = -distance * (1024 / (6 * Math.PI));
    RobotContainer.middleLeft.setSelectedSensorPosition(0);
    pid.setSetpoint(count);
    
    
  }
  public void updateDrive() {
    double output = pid.calculate(RobotContainer.middleLeft.getSelectedSensorPosition(), pid.getSetpoint());
    SmartDashboard.putNumber("count", pid.getSetpoint());
    SmartDashboard.putNumber("current count", RobotContainer.middleLeft.getSelectedSensorPosition());

    
    if (output > 0.4) {
      output = 0.4;
    }
    if (output < -0.4) {
      output = -0.4;
    }
    RobotContainer.difDrive.arcadeDrive(output, 0);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  

}