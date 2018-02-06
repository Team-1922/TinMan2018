/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1922.robot;

import org.usfirst.frc.team1922.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	/**
	CREATING BUTTONS

	One type of button is a joystick button which is any button on a
	joystick.
	You create one by telling it which joystick it's on and which button
	number it is.
	Joystick stick = new Joystick(port);
	Button button = new JoystickButton(stick, buttonNumber);

	There are a few additional built in buttons you can use. Additionally,
	by subclassing Button you can create custom triggers and bind those to
	commands the same as any other Button.

	TRIGGERING COMMANDS WITH BUTTONS
	Once you have a button, it's trivial to bind it to a button in one of
	three ways:

	Start the command when the button is pressed and let it run the command
	until it is finished as determined by it's isFinished method.
	button.whenPressed(new ExampleCommand());

	Run the command while the button is being held down and interrupt it once
	the button is released.
	button.whileHeld(new ExampleCommand());

	Start the command when the button is released and let it run the command
	until it is finished as determined by it's isFinished method.
	button.whenReleased(new ExampleCommand());
	**/

	private Joystick m_leftStick;
	private Joystick m_rightStick;
	private Joystick m_operator;
	private Button leftTrigger;
	private Button operatorTrigger;
	private Button operatorSecond;
	
	
	public OI() {			
		m_leftStick = new Joystick(1);
		m_rightStick = new Joystick(0);
		m_operator = new Joystick(2);
		leftTrigger = new JoystickButton(getLeftStick(), 1);
		operatorTrigger = new JoystickButton(getOperator(), 1);
		operatorSecond = new JoystickButton(getOperator(), 2);
		//kTrigger = new JoystickButton(rightStick, ButtonType.kTrigger);
		//leftTrigger.whenPressed(new HighGear_Command());
		//leftTrigger.whenReleased(new TankDrive_Command());
		
		operatorTrigger.whenPressed(new RaiseToScale_Command());
	}
	
	
	public Joystick getLeftStick() {
		return m_leftStick;
	}
	public Joystick getRightStick() {
		return m_rightStick;
	}
	public Joystick getOperator() {
		return m_operator;
	}
	public boolean leftTriggerIsPressed() {
		return leftTrigger.get();
	}
	public boolean operatorTriggerIsPressed() {
		return operatorTrigger.get();
	}
	public boolean operatorSecondIsPressed() {
		return operatorSecond.get();
	}
	
	
}
