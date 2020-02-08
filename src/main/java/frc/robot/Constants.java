/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
    public static final double shooterTargetRPM = 6000;//9375

    //Static gain of feedforward
    public static final double shooterKS = .5; //0.005
    //Velocity gain of feedforward
    public static final double shooterVS = 12.0 / shooterFreeRPM;

    //Shooter PID gains
    public static final double shooterP = .01575;//.0072;//0.05; //0.005
    public static final double shooterI = 0.0005;//0;//.047;//0.01;
    public static final double shooterD = .00062;//.0006;//0.0006;//0.0007;
    public static final double shooterPIDTolerance = 100;

    //Shooter Ports
    public static final int shooterMotor1 = 6;
    public static final int shooterMotor2 = 5;

    


}
