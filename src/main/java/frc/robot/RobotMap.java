/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.Elevator;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static Elevator e;

  /***DRIVE***/

  public static WPI_TalonSRX frontLeft;
  public static WPI_TalonSRX frontRight;
  public static WPI_TalonSRX backLeft;
  public static WPI_TalonSRX backRight;

  public static SpeedControllerGroup left;
  public static SpeedControllerGroup right;

  public static DifferentialDrive drive;

  /***SUBSYSTEMS***/

  //ELEVATOR
  public static WPI_TalonSRX elevatorTalonOne;
  public static WPI_TalonSRX elevatorTalonTwo;

  /**CLIMB**/

  //TALONS
  public static WPI_TalonSRX climbTalonOne;
  public static WPI_TalonSRX climbTalonTwo;

  //PISTONS
  public static DoubleSolenoid climbBackOne;
  public static DoubleSolenoid climbBackTwo;

  /**FLIPPY ARM**/

  //TALONS
  public static WPI_TalonSRX armTurn;
  public static WPI_TalonSRX armIntake;

  //PISTONS
  public static DoubleSolenoid pivotArm;

  /**HATCH**/

  //PISTONS
  public static DoubleSolenoid hatchPiston;

  public static void init()
  {
    //rename talon IDs
    frontLeft = new WPI_TalonSRX(9);
    frontRight = new WPI_TalonSRX(2);
    backLeft = new WPI_TalonSRX(10);
    backRight = new WPI_TalonSRX(1);

    left = new SpeedControllerGroup(frontLeft, backLeft);
    right = new SpeedControllerGroup(frontRight, backRight);

    drive = new DifferentialDrive(left,right);
    
    elevatorTalonOne = new WPI_TalonSRX(3); //3
    elevatorTalonOne.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    elevatorTalonOne.configAllowableClosedloopError(0,0,30);
    int absPos = elevatorTalonOne.getSensorCollection().getPulseWidthPosition();
    absPos &= 0xFFF;
    elevatorTalonOne.setSelectedSensorPosition(absPos, 0, 30);
    elevatorTalonOne.config_kP(0,0.2,30);
    elevatorTalonOne.config_kI(0,0,30);
    elevatorTalonOne.config_kD(0,10,30);
    elevatorTalonOne.setInverted(false);

    elevatorTalonTwo = new WPI_TalonSRX(8); //8
    elevatorTalonTwo.setInverted(true);
    elevatorTalonTwo.follow(elevatorTalonOne); 

    climbTalonOne = new WPI_TalonSRX(27);
    climbTalonOne.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    climbTalonOne.configAllowableClosedloopError(0,0,30);
    int absPos2 = climbTalonOne.getSensorCollection().getPulseWidthPosition();
    absPos2 &= 0xFFF;
    climbTalonOne.setSelectedSensorPosition(absPos2, 0, 30);
    climbTalonOne.config_kP(0,0.3,30);
    climbTalonOne.config_kI(0,0,30);
    climbTalonOne.config_kD(0,0,30);

    climbTalonTwo = new WPI_TalonSRX(6);
    climbTalonTwo.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    climbTalonTwo.configAllowableClosedloopError(0,0,30);
    int absPos3 = climbTalonTwo.getSensorCollection().getPulseWidthPosition();
    absPos3 &= 0xFFF;
    climbTalonTwo.setSelectedSensorPosition(absPos3, 0, 30);
    climbTalonTwo.config_kP(0,0.3,30);
    climbTalonTwo.config_kI(0,0,30);
    climbTalonTwo.config_kD(0,0,30);

    //climbBackOne = new DoubleSolenoid(0,1);
    //climbBackTwo = new DoubleSolenoid(2,3);

    armTurn = new WPI_TalonSRX(5); //5
    armTurn.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
    armTurn.configAllowableClosedloopError(0,0,30);
    int absPos4 = armTurn.getSensorCollection().getPulseWidthPosition();
    absPos4 &= 0xFFF;
    armTurn.setSelectedSensorPosition(absPos4, 0, 30);
    armTurn.config_kP(0,0.15,30);
    armTurn.config_kI(0,0,30);
    armTurn.config_kD(0,10,30);
     

    armIntake = new WPI_TalonSRX(4); //4

    pivotArm = new DoubleSolenoid(6,7);

    hatchPiston = new DoubleSolenoid(4,5);

    e = new Elevator();
  }  
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
