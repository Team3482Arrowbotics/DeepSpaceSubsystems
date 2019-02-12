/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Arm;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.FlippyArm;

/**
 * An example command.  You can replace me with your own command.
 */
public class ClawSpouttake extends Command {
    FlippyArm intakeOut;
  public ClawSpouttake() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_subsystem);
    intakeOut = new FlippyArm();
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    intakeOut.intakeOut();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
