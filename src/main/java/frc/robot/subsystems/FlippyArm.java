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
public class FlippyArm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  /**FLIPPY ARM TURNING WILL BE DONE DIRECTLY IN COMMANDS**/

  public void intakeIn()
  {
    RobotMap.armIntake.set(0.4);
  }

  public void intakeOut()
  {
    RobotMap.armIntake.set(-0.4);
  }

  public void clawIn()
  {
    RobotMap.pivotArm.set(Value.kForward);
  }

  public void clawOut()
  {
    RobotMap.pivotArm.set(Value.kReverse);
  }
}
