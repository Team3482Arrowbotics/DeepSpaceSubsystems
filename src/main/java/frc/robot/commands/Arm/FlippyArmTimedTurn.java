/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Arm;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * An example command.  You can replace me with your own command.
 */
public class FlippyArmTimedTurn extends Command {
    static long startTime;
    static final long MAX_TIME = 1000 * 4;
    public static final double MAX_POS = 107520;
    static boolean isFinished = false;
  public FlippyArmTimedTurn() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.m_subsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      startTime = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
      double elapsedTime = System.currentTimeMillis() - startTime;
      if(elapsedTime < MAX_TIME && !isFinished)
      {
          double newPosition = MAX_POS * (elapsedTime / MAX_TIME);
          RobotMap.armTurn.set(ControlMode.Position, newPosition);
          System.out.println("New Pos: " + newPosition); //debugging
      }
      else{
          isFinished = true;
      }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isFinished;
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
