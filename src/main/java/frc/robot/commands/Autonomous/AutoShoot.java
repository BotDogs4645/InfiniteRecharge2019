/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.commands.ManualIndexer;
import frc.robot.commands.RunShooter;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoShoot extends SequentialCommandGroup {
  /**
   * Creates a new DriveByTimer.
   */
  public AutoShoot() {
    // Add your commands in the super() call.  Add the deadline first.
    super(
      /*
      new ParallelDeadlineGroup(
        new Delay(0.5),
        new AutoDrive(0.5,0)
        ),
      new ParallelDeadlineGroup(
        new Delay(1.5),
        new AutoDrive(-0.5,0)
        ),
        */
      new DrivePastLine(),
      new ParallelDeadlineGroup(
          new Delay(8),
          new RunShooter(RobotContainer.shooterSub, Constants.shooterTargetRPM),
          
          new SequentialCommandGroup(
            new Delay(3),
            new ManualIndexer(RobotContainer.sensor, .3)
            )
    
            )
    );
  }
}
