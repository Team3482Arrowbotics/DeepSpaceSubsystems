/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Climber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  /** CLIMBER ARM TURNING WILL BE DONE DIRECTLY IN COMMANDS**/

  public void backPistonUp()
  {
    RobotMap.climbBackOne.set(Value.kForward);
    RobotMap.climbBackTwo.set(Value.kForward);
  }

  public void backPistonDown()
  {
    RobotMap.climbBackOne.set(Value.kReverse);
    RobotMap.climbBackTwo.set(Value.kReverse);
  }
}
