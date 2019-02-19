/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.Climber.*;
import frc.robot.commands.TalonZero;
import frc.robot.commands.Arm.*;
import frc.robot.commands.Hatch.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static Joystick logitech;
  public static Joystick flightStick;

  JoystickButton climbUp; //logitech a
  JoystickButton climbDown; //logitech b
  JoystickButton climberPistonUp; //logitech x
  JoystickButton climberPistonDown; //logitech y

  JoystickButton spintake; //logitech lb
  JoystickButton spouttake; //logitech rb

  JoystickButton wholeArmOut;
  JoystickButton wholeArmIn;
  JoystickButton clawDown;
  JoystickButton clawUp;

  JoystickButton hatchSet;
  JoystickButton hatchGo;

  public static JoystickButton temp;

  public OI()
  {
    logitech = new Joystick(1);
    flightStick = new Joystick(0);

    climbUp = new JoystickButton(logitech, 1);
    climbDown = new JoystickButton(logitech, 2);
    climberPistonUp = new JoystickButton(logitech, 3);
    climberPistonDown = new JoystickButton(logitech, 4);

    spintake = new JoystickButton(logitech, 5);
    spouttake = new JoystickButton(logitech, 6);

    wholeArmOut = new JoystickButton(flightStick, 1);
    wholeArmIn = new JoystickButton(flightStick, 2);
    clawDown = new JoystickButton(flightStick, 3);
    clawUp = new JoystickButton(flightStick, 4);

    hatchSet = new JoystickButton(flightStick, 11);
    hatchGo = new JoystickButton(flightStick, 12);

    temp = new JoystickButton(flightStick, 10);

    climbUp.whileHeld(new ClimberTimedTurn());
    climbDown.whileHeld(new ClimberReset());
    climberPistonUp.whileHeld(new ClimberBackUp());
    climberPistonDown.whileHeld(new ClimberBackDown());

    spintake.whenPressed(new ClawSpintake());
    spintake.whenReleased(new TalonZero(RobotMap.armIntake)); 

    spouttake.whenPressed(new ClawSpouttake());
    spouttake.whenReleased(new TalonZero(RobotMap.armIntake)); 
    
    wholeArmOut.whileHeld(new FlippyArmTimedTurn());
    wholeArmIn.whileHeld(new FlippyArmReset());
    clawDown.whileHeld(new ClawIn());
    clawUp.whileHeld(new ClawOut());

    hatchSet.whileHeld(new HatchIn());
    hatchGo.whileHeld(new HatchOut());

    //temp.whileHeld(new TalonZero(RobotMap.elevatorTalonOne));
  }
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
