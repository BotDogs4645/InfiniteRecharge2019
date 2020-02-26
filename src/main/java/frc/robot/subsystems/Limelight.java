/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase {
  /**
   * Creates a new Limelight.
   */
  NetworkTable table1 = NetworkTableInstance.getDefault().getTable("limelight");
  public Limelight() {

  }
  public void turnOn(){

    table1.getEntry("ledMode").setNumber(3);

  }
  public void turnOff(){

    table1.getEntry("ledMode").setNumber(1);

  }
  public void display(){


    NetworkTableEntry tx = table1.getEntry("tx");
    NetworkTableEntry ty = table1.getEntry("ty");
    NetworkTableEntry ta = table1.getEntry("ta");
    NetworkTableEntry ts = table1.getEntry("ts");


    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double targetArea = ta.getDouble(0.0);
    double skew = ts.getDouble(0.0);
    
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("Target Area", targetArea);
    SmartDashboard.putNumber("Skew", skew);
    
  }

  public double getXOffset(){
    NetworkTableEntry tx = table1.getEntry("tx");

    return tx.getDouble(0);
  }

  public double getYOffset(){
    NetworkTableEntry ty = table1.getEntry("ty");

    return ty.getDouble(0);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
