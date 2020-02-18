/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Use the Robot Characterization Toolsuite to obtain these feedfoward and feedback gains
    public static final double ksVolts = 0;
    public static final double kvVoltSecondsPerMeter = 0;
    public static final double kaVoltSecondsSquaredPerMeter = 0;
    public static final double kPDriveVel = 0;

    //Uses the trackwidth of the robot to covert from chassis speeds to wheel speeds
    public static final double kTrackwidthMeters = 0; //horizontal distance between the wheels in meters
    public static final DifferentialDriveKinematics kDriveKinematics =  new DifferentialDriveKinematics(kTrackwidthMeters);

    /*
     * Sets the maximum velocity and acceleration for the robot during path following
     * The maximum velocity should be somewhat below the nominal free-speed of the robot
     * The maximum acceleration value is not very import as DifferentialDriveVoltageConstraint will limit it
     */
    public static final double kMaxSpeedMetersPerSecond = 0;
    public static final double kMaxAccelerationMetersPerSecondSquared = 0;

     // Reasonable baseline values for a RAMSETE follower in units of meters and seconds
     public static final double kRamseteB = 2;
     public static final double kRamseteZeta = 0.7;

}
