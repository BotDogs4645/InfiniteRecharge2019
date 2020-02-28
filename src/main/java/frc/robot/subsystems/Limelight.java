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
   * Creates a new Limlight.
   */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  public Limelight() {
  }
  
  public void switchPipelines(int pipline){
    table.getEntry("pipeline").setNumber(pipline);

  }
  public void toggle (){
    if (table.getEntry("ledMode").getDouble(0)== 1)
    {
        table.getEntry("ledMode").setNumber(3);
    }
    else
    {
        table.getEntry("ledMode").setNumber(1);
    }
  }
  public double getXOffset(){
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    NetworkTableEntry tx = table.getEntry("tx");

    return tx.getDouble(0);

  }
  
  
  

  public void display(){

    

    NetworkTableEntry tx = table.getEntry("tx");
    NetworkTableEntry ty = table.getEntry("ty");
    NetworkTableEntry ta = table.getEntry("ta");
    NetworkTableEntry ts = table.getEntry("ts");


    //read values periodically
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double targetArea = ta.getDouble(0.0);
    double skew = ts.getDouble(0.0);


    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("Target Area", targetArea);
    SmartDashboard.putNumber("Skew", skew);
    
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    display();
  }
}
