/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.VisionCode;
import frc.robot.subsystems.IRSensor;
//import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.commands.MoveDistance;


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  //private final VisionCode vision = new VisionCode();
  private final ExampleCommand m_autoCommand = new ExampleCommand();
  public static TankDrive tankDriveSubsystem = new TankDrive(); 
  public static IRSensor sensor = new IRSensor();
  //TANK DRIVE MOTORS
  public static final WPI_TalonSRX frontLeft = new WPI_TalonSRX(4); 
  public static final WPI_TalonSRX middleLeft = new WPI_TalonSRX(5); 
  public static final WPI_TalonSRX rearLeft = new WPI_TalonSRX(6); 

  public static final WPI_TalonSRX frontRight = new WPI_TalonSRX(1); 
  public static final WPI_TalonSRX middleRight = new WPI_TalonSRX(2);
  public static final WPI_TalonSRX rearRight = new WPI_TalonSRX(10);
  public static final Joystick stick = new Joystick(0);
  
  public static final JoystickButton tankDriveButton = new JoystickButton(stick, 5);



  private static final SpeedControllerGroup leftSide = new SpeedControllerGroup(frontLeft, middleLeft, rearLeft);

  private static final SpeedControllerGroup rightSide = new SpeedControllerGroup(frontRight, middleRight, rearRight);

  public static final DifferentialDrive difDrive = new DifferentialDrive(leftSide, rightSide);

  //INDEXER MOTORS

  public static final WPI_TalonSRX intakeMotor = new WPI_TalonSRX(11);
  public static final WPI_VictorSPX indexerMotor = new WPI_VictorSPX(7);
  public static final WPI_TalonSRX indexerReverseMotor = new WPI_TalonSRX(6);
  
  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    RobotContainer.frontLeft.follow(RobotContainer.middleLeft);
    RobotContainer.rearLeft.follow(RobotContainer.middleLeft);
  
    RobotContainer.frontLeft.setInverted(true);
    RobotContainer.rearLeft.setInverted(true);
    
    RobotContainer.frontRight.follow(RobotContainer.middleRight);
    RobotContainer.rearRight.follow(RobotContainer.middleRight); 

    RobotContainer.frontRight.setInverted(true);
    RobotContainer.rearRight.setInverted(true);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    tankDriveButton.whenPressed(new MoveDistance(tankDriveSubsystem, 36));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}

