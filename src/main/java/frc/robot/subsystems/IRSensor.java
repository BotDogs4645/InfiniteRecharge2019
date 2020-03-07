/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//import edu.wpi.first.hal.sim.DigitalPWMSim;

//import org.frc.robot.RobotContainer;
//import org.frc.robot.commands.DetectBrokenBeam


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
import frc.robot.commands.RunIndexer;
//import edu.wpi.first.wpilibj.InterruptableSensorBase;
//import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** 
 * Add your docs here.
 */
public class IRSensor extends SubsystemBase{

  DigitalInput IRIntake = new DigitalInput(5);
  DigitalInput IRIndexer = new DigitalInput(7);
  DigitalInput IROutake = new DigitalInput(9);
  public int count = 2;
  Boolean LastIntakeValue = true;
  Boolean LastOuttakeValue = true;

  public IRSensor() {  
    setDefaultCommand(new RunIndexer(this));
  }  


  public void readIR(){
 
    if(!IRIntake.get()) { 
    //Roller Begins to Move; Counts # of new balls in the indexer
      if(LastIntakeValue == true) {
        count++;
        RobotContainer.IndexerMotor.set(0.5);
        RobotContainer.ShooterMotor.set(0.5);
      }
    }
    else if((IRIndexer.get())){
      //Roller Stops and hold the ball in the first position
      RobotContainer.IndexerMotor.set(0);
      RobotContainer.ShooterMotor.set(0);
    }
    
    if  (!(IROutake.get())){
      //counts the # of balls exiting
      if(LastOuttakeValue == true){
        count--; 
      } 
      RobotContainer.ShooterMotor.set(0); 
    }
    if (count > 5){
      count = 5;
    }
    if (count < 0){
      count = 0;
    }
    
  
    
    //SmartDashboard.putBoolean("Intake IR: ", IRIntake.get());
    //SmartDashboard.putBoolean("Indexer IR: ", IRIndexer.get());
    //SmartDashboard.putBoolean("Outtake IR: ", IROutake.get());
  
    SmartDashboard.putNumber("Number of Balls: ", count);
    LastIntakeValue = IRIntake.get();
    LastOuttakeValue = IROutake.get();
  }
    
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

}
