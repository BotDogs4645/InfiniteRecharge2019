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

    /*
    SHOOTER CONSTANTS
    */
    /*https://motors.vex.com/other-motors/am-775
    freerpm 5700
    target 3500

    https://www.robotshop.com/en/rs-775-motor-7000rpm-12v-7613oz-in.html
    freerpm 7000
    target 5000

    https://www.vexrobotics.com/775pro.html#Other_Info
    freerpm 18730
    target 9375

    cim
    free 5330
    target 1700

    */
    //From documentation, max speed of motor: 
    public static final double shooterFreeRPM = 18730;

    //an RPM at which efficiency (percent of power not lost thorugh absorbance) and Power Output are at their highest
    public static final double shooterTargetRPM = -13000;//9375

    //Static gain of feedforward
    public static final double shooterKS = .5; //0.005  
    //Velocity gain of feedforward
    public static final double shooterVS = 12.0 / shooterFreeRPM;

    //Shooter PID gains
    public static final double shooterP = 0.00629510;//0.00629510; //05;//.01685;//.0072;//0.05; //0.005
    public static final double shooterI = 0;//0;//0.0005;//0;//.047;//0.01;
    public static final double shooterD = 0.0000401;//0.0000401;//.00068;//.0006;//0.0006;//0.0007;
    public static final double shooterPIDTolerance = 100;


    //Shooter Ports
    public static final int shooterMotor1 = 6;
    public static final int shooterMotor2 = 3;

    
    //Use the Robot Characterization Toolsuite to obtain these feedfoward and feedback gains
    public static final double ksVolts = 1;
    public static final double kvVoltSecondsPerMeter = 1;
    public static final double kaVoltSecondsSquaredPerMeter = 1;
    public static final double kPDriveVel = 1;

    //Uses the trackwidth of the robot to covert from chassis speeds to wheel speeds
    public static final double kTrackwidthMeters = 1; //horizontal distance between the wheels in meters
    public static final DifferentialDriveKinematics kDriveKinematics =  new DifferentialDriveKinematics(kTrackwidthMeters);

    /*
     * Sets the maximum velocity and acceleration for the robot during path following
     * The maximum velocity should be somewhat below the nominal free-speed of the robot
     * The maximum acceleration value is not very import as DifferentialDriveVoltageConstraint will limit it
     */
    public static final double kMaxSpeedMetersPerSecond = 1;
    public static final double kMaxAccelerationMetersPerSecondSquared = 1;

     // Reasonable baseline values for a RAMSETE follower in units of meters and seconds
     public static final double kRamseteB = 2;
     public static final double kRamseteZeta = 0.7;

}
