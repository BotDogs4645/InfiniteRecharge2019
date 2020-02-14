/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PowerDistribution extends SubsystemBase {
  /**
   * Creates a new PowerDistributionPanel.
   */
  private final static PowerDistributionPanel pdp = new PowerDistributionPanel();

  public PowerDistribution() {
    RobotContainer.Motor.set(0.5);
  }

  public void powerdis()
  {
    double x;
    for (int i = 0; i < 15; i++) {
      //pdp.getCurrent(i);
      x = pdp.getCurrent(i);
      SmartDashboard.putNumber("The Current of "+ i + " is ", x);
    }
    double z = pdp.getVoltage();
    SmartDashboard.putNumber("Voltage of PDP: ", z);
  }

  public void running(){
    
    RobotContainer.Motor.set(0.5);
  }
 
  @Override
  public void periodic() {
    running();
    powerdis();    // This method will be called once per scheduler run
  }
}
