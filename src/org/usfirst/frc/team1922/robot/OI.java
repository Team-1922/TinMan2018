/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1922.robot;

import org.usfirst.frc.team1922.robot.commands.*;
//import org.usfirst.frc.team1922.robot.extras.LimitSwitch;

import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Solenoid;
//import edu.wpi.first.wpilibj.Joystick.ButtonType;
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
	private XboxController m_operator;
	//private Joystick m_operator;
	private Button leftTrigger;
//	private Button rightTrigger;
	private Button operatorFirst;
	private Button operatorSecond;
	private Button operatorThird;
	private Button operatorFourth;
	private Button operatorRB;
	private Button operatorLB;
	private Button left4, leftSecond;
	
//	private Button limitSwitch_bot;
	
	public OI() {			
		m_leftStick = new Joystick(1); 
		m_rightStick = new Joystick(0);
		m_operator = new XboxController(2);
		//m_operator = new Joystick(2); //Previously the third joystick used in 2017
		leftTrigger = new JoystickButton(getLeftStick(), 1); 
//		rightTrigger = new JoystickButton(getRightStick(), 1); 
		operatorFirst = new JoystickButton(getOperator(), 1); 
		operatorSecond = new JoystickButton(getOperator(), 2);
		operatorThird = new JoystickButton(getOperator(), 3);
		operatorFourth = new JoystickButton(getOperator(), 4);
		operatorRB = new JoystickButton(getOperator(), 6);
		operatorLB = new JoystickButton(getOperator(), 5);
//		limitSwitch_bot = new LimitSwitch(1); 
		left4 = new JoystickButton(getLeftStick(), 4);
		leftSecond = new JoystickButton(getLeftStick(), 2);

		
		//important key binds
		operatorRB.whileHeld(new ElevatorUp_Command());
		operatorLB.whileHeld(new ElevatorDown_Command());
		
		
		//testing keybinds
		//operatorFourth.whenPressed(new ZeroGyro_Command());
		//limitSwitch_bot.whenPressed(new ZeroDrive_Command());
		//rightTrigger.whenPressed(new DriveStraight_Command());
		operatorThird.whenPressed(new Deposit_Command());
		//operatorTrigger.whenPressed(new ZeroDrive_Command());
		//operatorTrigger.whenPressed(new ElevateToScale_Command());
		operatorSecond.whenPressed(new ElevateToScale_Command());
		//operatorFourth.whenPressed(new ElevateToScale_Command());
		operatorFirst.whenPressed(new DeployElevator_Command());
	}
	
	public Joystick getLeftStick() {
		return m_leftStick;
	}
	public Joystick getRightStick() {
		return m_rightStick;
	}
	public XboxController getOperator() {
		return m_operator;
	}
	//public Joystick getOperator() {
	//	return m_operator;
	//}
	public boolean leftTriggerIsPressed() {
		return leftTrigger.get();
	}
	public boolean operatorTriggerIsPressed() {
		return operatorFirst.get();
	}
	public boolean operatorSecondIsPressed() {
		return operatorSecond.get();
	}

	public boolean operatorThirdIsPressed() {
		return operatorThird.get();
	}

	public boolean leftSecond() {
		// TODO Auto-generated method stub
		return leftSecond.get();
	}
	
	
}