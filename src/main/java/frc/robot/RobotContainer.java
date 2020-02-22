/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.VisionCode;
import frc.robot.subsystems.GearShiftSubsystem;
import frc.robot.subsystems.IRSensor;
import frc.robot.subsystems.Motor;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.PressureSensor;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.commands.MoveDistance;
import frc.robot.commands.MoveMotor;
import frc.robot.commands.RunShooter;
import frc.robot.commands.gearshift.GearShiftCommand;
import frc.robot.commands.pneumatics.PneumaticsToggle;



/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final VisionCode vision = new VisionCode();
  private final ExampleCommand m_autoCommand = new ExampleCommand();
  private final Motor motorSub = new Motor();
  public static final Shooter shooterSub = new Shooter();

  public static IRSensor sensor = new IRSensor();

  public static TankDrive tankDriveSubsystem = new TankDrive(); 
  public static PneumaticsSubsystem m_pneumaticssubsytem = new PneumaticsSubsystem();
  public static GearShiftSubsystem m_gearshiftsubsystem = new GearShiftSubsystem();
  public static PressureSensor m_pressuresensorsubsytem = new PressureSensor();



  //TANK DRIVE MOTORS
  public static final WPI_TalonSRX frontLeft = new WPI_TalonSRX(0); //0
  public static final WPI_TalonSRX middleLeft = new WPI_TalonSRX(13); //13
  public static final WPI_TalonSRX rearLeft = new WPI_TalonSRX(11); //11

  public static final WPI_TalonSRX frontRight = new WPI_TalonSRX(12); //12
  public static final WPI_TalonSRX middleRight = new WPI_TalonSRX(1); //1
  public static final WPI_TalonSRX rearRight = new WPI_TalonSRX(10);

  //INDEXER MOTORS

  public static final WPI_TalonSRX OuttakeHold = new WPI_TalonSRX(11);
  public static final WPI_VictorSPX indexerMotor = new WPI_VictorSPX(7);
  public static final WPI_VictorSPX intakeMotor= new WPI_VictorSPX(1);


  public static final DoubleSolenoid RightPiston = new DoubleSolenoid(0,1);
  public static final DoubleSolenoid LeftPiston = new DoubleSolenoid(2,3);

  public static Solenoid gearshift1 = new Solenoid(4);
  public static Solenoid gearshift2 = new Solenoid(5);


  public static final Joystick stick = new Joystick(0);
  
  //public static final JoystickButton tankDriveButton = new JoystickButton(stick, 2);//change back to 5


  //change all these to xbox controller

  public static JoystickButton GearShiftButton = new JoystickButton(stick,1);

  public static JoystickButton intakeButton = new JoystickButton(stick,2);

  public static XboxController Xbox = new XboxController(1);

  public static JoystickButton leftjoystickbutton = new JoystickButton(Xbox, 9);
  public static JoystickButton rightjoystickbutton = new JoystickButton(Xbox,10);

  public static JoystickButton shooterButton = new JoystickButton(Xbox,1);


  private static final SpeedControllerGroup leftSide = new SpeedControllerGroup(frontLeft, middleLeft, rearLeft);

  private static final SpeedControllerGroup rightSide = new SpeedControllerGroup(frontRight, middleRight, rearRight);

  public static final DifferentialDrive difDrive = new DifferentialDrive(leftSide, rightSide);
  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    RobotContainer.frontLeft.follow(RobotContainer.middleLeft);
    /*
    frontLeft.configClosedloopRamp(2);
    frontRight.configClosedloopRamp(2);

    middleLeft.configClosedloopRamp(2);
    middleRight.configClosedloopRamp(2);

    rearLeft.configClosedloopRamp(2);
    rearRight.configClosedloopRamp(2);
    */
    //frontLeft.con

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
   // tankDriveButton.whenPressed(new MoveDistance(tankDriveSubsystem, 36));

    GearShiftButton.whileHeld(new GearShiftCommand(m_gearshiftsubsystem), true);
    
    intakeButton.whileHeld(new MoveMotor(motorSub));

    leftjoystickbutton.whileActiveOnce(new PneumaticsToggle(m_pneumaticssubsytem));
    rightjoystickbutton.whileActiveOnce(new PneumaticsToggle(m_pneumaticssubsytem));
    shooterButton.whileHeld(new RunShooter(shooterSub, Constants.shooterTargetRPM));

    //BothUp.whileHeld(new BothUpCommand(m_pneumaticssubsytem));
    //BothDown.whileHeld(new BothDownCommand(m_pneumaticssubsytem));
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

