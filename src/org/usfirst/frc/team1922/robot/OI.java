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
import edu.wpi.first.wpilibj.XboxController; 


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	private Joystick m_leftStick;
	private Joystick m_rightStick;
	private XboxController xCont;
	private Button leftTrigger;
	private Button operatorTrigger;
	private Button operatorSecond;
	private Button operatorThird;
	private Button operatorFourth;
	
	public OI() {			
		m_leftStick = new Joystick(1);
		m_rightStick = new Joystick(0);
		xCont = new XboxController(3);
		leftTrigger = new JoystickButton(getLeftStick(), 1);
		operatorTrigger = new JoystickButton(getOperator(), 1);
		operatorSecond = new JoystickButton(getOperator(), 2);
		operatorThird = new JoystickButton(getOperator(), 3);
		operatorFourth = new JoystickButton(getOperator(), 4);

		operatorTrigger.whenPressed(new ElevateToScale_Command());
		operatorSecond.whenPressed(new ElevateToSwitch_Command());
		operatorThird.whenPressed(new ElevateToGround_Command());
		operatorFourth.whenPressed(new Deposit_Command());
	}
	
	
	public Joystick getLeftStick() {
		return m_leftStick;
	}
	public Joystick getRightStick() {
		return m_rightStick;
	}
	public XboxController getOperator() {
		return xCont;
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

	public boolean operatorThirdIsPressed() {
		return operatorThird.get();
	}
	
	
}