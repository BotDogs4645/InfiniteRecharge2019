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
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.Align;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ManualIndexer;
import frc.robot.commands.ManualIntake;
import frc.robot.commands.RunIntake;
import frc.robot.subsystems.GearShiftSubsystem;
import frc.robot.subsystems.IRSensor;
import frc.robot.subsystems.IntakeMotor;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.PneumaticsSubsystem;
import frc.robot.subsystems.PressureSensor;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.commands.RunShooter;
import frc.robot.commands.ToggleLimelight;
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
  private final ExampleCommand m_autoCommand = new ExampleCommand();

  
  private static final IntakeMotor m_intakeSub = new IntakeMotor();
  private static final Shooter shooterSub = new Shooter();

  public static final Limelight limelight = new Limelight();

  private static final IRSensor sensor = new IRSensor();

  private static final TankDrive tankDriveSubsystem = new TankDrive(); 
  private static final PneumaticsSubsystem m_pneumaticssubsytem = new PneumaticsSubsystem();
  private static final GearShiftSubsystem m_gearshiftsubsystem = new GearShiftSubsystem();
  private static final PressureSensor m_pressuresensorsubsytem = new PressureSensor();



  //TANK DRIVE MOTORS
  public static final WPI_TalonSRX frontLeft = new WPI_TalonSRX(15); //0
  public static final WPI_TalonSRX middleLeft = new WPI_TalonSRX(13); //13
  public static final WPI_TalonSRX rearLeft = new WPI_TalonSRX(11); //11

  public static final WPI_TalonSRX frontRight = new WPI_TalonSRX(12); //12
  public static final WPI_TalonSRX middleRight = new WPI_TalonSRX(14); //1
  public static final WPI_TalonSRX rearRight = new WPI_TalonSRX(10);

  private static final SpeedControllerGroup leftSide = new SpeedControllerGroup(frontLeft, middleLeft, rearLeft);
  private static final SpeedControllerGroup rightSide = new SpeedControllerGroup(frontRight, middleRight, rearRight);
  public static final DifferentialDrive difDrive = new DifferentialDrive(leftSide, rightSide);
  

  //INDEXER MOTORS
  public static final WPI_TalonSRX IntakeMotor = new WPI_TalonSRX(4);
  public static final WPI_TalonSRX IndexerMotor = new WPI_TalonSRX(5);
  public static final WPI_TalonSRX ShooterMotor= new WPI_TalonSRX(2);

  //CLIMBING PNEUMATICS
  public static final DoubleSolenoid RightPiston = new DoubleSolenoid(3,2);
  public static final DoubleSolenoid LeftPiston = new DoubleSolenoid(1,0);

  //GEARSHIFT SOLENOIDS
  public static final Solenoid gearshift1 = new Solenoid(4);
  public static final Solenoid gearshift2 = new Solenoid(5);

  //MAIN JOYSTICK
  public static final Joystick stick = new Joystick(0);

  public static JoystickButton GearShiftButton = new JoystickButton(stick,1);


  //XBOX CONTROLLER
  public static XboxController Xbox = new XboxController(1);

  public static JoystickButton indexerIntakeButton = new JoystickButton(Xbox,3);


  public static JoystickButton leftjoystickbutton = new JoystickButton(Xbox, 9);
  public static JoystickButton rightjoystickbutton = new JoystickButton(Xbox,10);

  public static JoystickButton forwardIndexerButton = new JoystickButton(Xbox,1);
  public static JoystickButton reverseIndexerButton = new JoystickButton(Xbox,2);

  public static JoystickButton shooterButton = new JoystickButton(Xbox,6);

  public static JoystickButton alignButton = new JoystickButton(stick,11);
  public static JoystickButton limelightToggleButton = new JoystickButton(stick,12);

  

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_gearshiftsubsystem.in();
    m_pneumaticssubsytem.rightpiston(Value.kReverse);
    m_pneumaticssubsytem.leftpiston(Value.kReverse);


    double ramptime = 1.5;
    NeutralMode coast = NeutralMode.Coast;


    middleLeft.configClosedloopRamp(ramptime);
    middleRight.configClosedloopRamp(ramptime);

    middleLeft.configOpenloopRamp(ramptime);
    middleRight.configOpenloopRamp(ramptime);

    rearLeft.configClosedloopRamp(ramptime);
    rearRight.configClosedloopRamp(ramptime);

    rearLeft.configOpenloopRamp(ramptime);
    rearRight.configOpenloopRamp(ramptime);
    
    frontLeft.configClosedloopRamp(ramptime);
    frontRight.configClosedloopRamp(ramptime);
        
    frontLeft.configOpenloopRamp(ramptime);
    frontRight.configOpenloopRamp(ramptime);


    middleLeft.setNeutralMode(coast);
    middleRight.setNeutralMode(coast);

    rearLeft.setNeutralMode(coast);
    rearRight.setNeutralMode(coast);
    
    frontRight.setNeutralMode(coast);
    frontLeft.setNeutralMode(coast);

    
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
   // tankDriveButton.whenPressed(new MoveDistance(tankDriveSubsystem, 36));

    GearShiftButton.whileHeld(new GearShiftCommand(m_gearshiftsubsystem), true);
    

    leftjoystickbutton.whileActiveOnce(new PneumaticsToggle(m_pneumaticssubsytem));
    rightjoystickbutton.whileActiveOnce(new PneumaticsToggle(m_pneumaticssubsytem));
    shooterButton.whileHeld(new RunShooter(shooterSub, Constants.shooterTargetRPM));

    //BothUp.whileHeld(new BothPUpCommand(m_pneumaticssubsytem));
    //BothDown.whileHeld(new BothDownCommand(m_pneumaticssubsytem));

    forwardIndexerButton.whileHeld(new ManualIndexer(sensor, 0.5));
    reverseIndexerButton.whileHeld(new ManualIndexer(sensor, -0.5));

    //indexerIntakeButton.whileHeld(new ManualIndexer(sensor, -0.5));
    indexerIntakeButton.whileHeld(new ManualIntake(m_intakeSub, sensor, -0.7));

    limelightToggleButton.whenPressed(new ToggleLimelight(limelight));
    alignButton.whileHeld(new Align(limelight, tankDriveSubsystem));


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

