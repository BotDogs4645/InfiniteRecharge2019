/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autonomous;

import java.util.List;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.ManualIndexer;
import frc.robot.commands.RunShooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoLeft extends SequentialCommandGroup {
  /**
   * Creates a new AutoLeft.
   */



  public AutoLeft() {
     Trajectory autoTrajectory = TrajectoryGenerator.generateTrajectory(
      // Start at origin facing the +X direction
      new Pose2d(0, 0, new Rotation2d(0)),
      // Wavepoints making a S curve path
      List.of(new Translation2d(Units.inchesToMeters(12), 0), 
        new Translation2d(Units.inchesToMeters(36), 0),
          new Translation2d(Units.inchesToMeters(60), 0),
          new Translation2d(Units.inchesToMeters(113), Units.inchesToMeters(68)),
          new Translation2d(Units.inchesToMeters(142), Units.inchesToMeters(68)),
          new Translation2d(Units.inchesToMeters(176), Units.inchesToMeters(68)),
          new Translation2d(Units.inchesToMeters(207), Units.inchesToMeters(68)),
          new Translation2d(Units.inchesToMeters(60), 0)),
      // End 3 feet ahead of where robot start, facing forward
      new Pose2d(Units.feetToMeters(3), 0, new Rotation2d(0)),
      // Pass config
      RobotContainer.config);

   RamseteCommand ramseteCommand = new RamseteCommand(autoTrajectory, RobotContainer.tankDriveSubsystem::getPose,
      new RamseteController(Constants.kRamseteB, Constants.kRamseteZeta),
      new SimpleMotorFeedforward(Constants.ksVolts, Constants.kvVoltSecondsPerMeter,
          Constants.kaVoltSecondsSquaredPerMeter),
      Constants.kDriveKinematics, RobotContainer.tankDriveSubsystem::getWheelSpeeds,
      new PIDController(Constants.kPDriveVel, 0, 0), new PIDController(Constants.kPDriveVel, 0, 0),
      // RamseteCommand passes volts to the callback
      RobotContainer.tankDriveSubsystem::tankDriveVolts, RobotContainer.tankDriveSubsystem);

    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());

    addCommands(
      new ParallelDeadlineGroup(
        ramseteCommand, 
        new AutoIntake(RobotContainer.m_intakeSub)
        ),
      
      new ParallelCommandGroup(
        new RunShooter(RobotContainer.shooterSub, Constants.shooterTargetRPM),
        
        new SequentialCommandGroup(
          new Delay(3),
          new ManualIndexer(RobotContainer.sensor, .5)
          )

        )
      
      );
  }
}
