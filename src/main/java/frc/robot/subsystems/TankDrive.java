package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpiutil.math.MathUtil;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveCommand;
import edu.wpi.first.wpilibj.smartdashboard.*;




public class TankDrive extends SubsystemBase {
  /**
   * Creates a new ExampleSubsystem.
   */

  public final PIDController pid = new PIDController(0,0, 0);//0.0003397
  public PowerDistributionPanel pdp = new PowerDistributionPanel();
  public static final AHRS ahrs = new AHRS();

  public TankDrive() {
    setDefaultCommand(new DriveCommand(this));
    pid.setTolerance(128); //Error is within 1/8 of a revolution
    
    
  }


  public void driveWithJoystick() {
    //ONE JOYSTICK
    
    double forward = .75*MathUtil.clamp(1 * Math.pow(RobotContainer.stick.getY(), 3),-1,1);
    //double forward = Math.signum(RobotContainer.stick.getY())* Math.pow(RobotContainer.stick.getY(), 2);
    //double forward = RobotContainer.stick.getY()]
    SmartDashboard.putNumber("Forward", forward);
    double turn = .75*MathUtil.clamp(-1 * Math.pow(RobotContainer.stick.getZ(), 3),-1,1);
    //double turn = Math.pow(RobotContainer.stick.getZ(), 2);
    //double turn = -Math.signum(RobotContainer.stick.getZ())* Math.pow(RobotContainer.stick.getZ(), 2);

    SmartDashboard.putNumber("Turn", turn);

    /*deadband*/
    
    if (Math.abs(forward) < 0.05)
    {
      forward = 0;
    } 
    
    if (Math.abs(turn) < 0.05) {
      turn = 0;
    }

    RobotContainer.difDrive.arcadeDrive(forward, turn);
    SmartDashboard.putNumber("Total current", pdp.getTotalCurrent()); 
  }
  
  

  public void stop() {
    RobotContainer.difDrive.arcadeDrive(0, 0);
  }
  


  public void driveDistance(double distance) {
    double count = -distance * (1024 / (6 * Math.PI));
    RobotContainer.middleLeft.setSelectedSensorPosition(0);
    pid.setSetpoint(count);
    
    
  }

  public void turn(boolean isRight) {
    if (isRight) {
      RobotContainer.difDrive.arcadeDrive(0.5, 0.5);
    } else {
      
      RobotContainer.difDrive.arcadeDrive(0.5, -0.5);
    }
  }

  public void updateDrive() {
    double output = pid.calculate(RobotContainer.middleLeft.getSelectedSensorPosition(), pid.getSetpoint());
    SmartDashboard.putNumber("count", pid.getSetpoint());
    SmartDashboard.putNumber("Pid Output", output);
    SmartDashboard.putNumber("current count", RobotContainer.middleLeft.getSelectedSensorPosition());
    /*
    if(output > 0.4) {
      output = 0.4;
    }

    if(output < -0.4){
      output = -0.4;
    }
    */
    RobotContainer.difDrive.arcadeDrive(output, 0);
    SmartDashboard.putNumber("Total auto current", pdp.getTotalCurrent());
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  

}