/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1922.robot;

public class RobotMap {

	
	/*
	//Motor Ids OLD
	public static final int REARLEFT = 8;
	public static final int FRONTLEFT = 1;
	public static final int REARRIGHT = 3;
	public static final int FRONTRIGHT = 4;
	
	public static final int INTAKERIGHT = 5;
	public static final int INTAKELEFT = 7; 
	
	public static final int ELEVATOR = 8;
	*/
	
	
	//Motor IDs
	public static final int REARLEFT = 7;
	public static final int FRONTLEFT = 1;
	public static final int REARRIGHT = 8;
	public static final int FRONTRIGHT = 3;
	
	public static final int INTAKERIGHT = 5;
	public static final int INTAKELEFT = 6; //was 7
	
	public static final int ELEVATOR = 2;
	
		
		
	//Solenoids
	public static final int GEARSHIFT = 1;
	public static final int DEPLOYER = 0;
	public static final int RATCHET = 2; 
	
	//Encoder Constants 
	public static final int ELEVATOR_SCALE_HEIGHT = -27000;  //measured: 29700
	public static final int ELEVATOR_BOTTOM = -10000;
	public static final int ELEVATOR_SWITCH_HEIGHT = -10000; //-9000; 
	public static final double BotLength = 3.25; 
	
}