/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1922.robot;

import edu.wpi.first.wpilibj.CameraServer; //Used for drive camera
import edu.wpi.first.wpilibj.DriverStation; 
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1922.robot.commands.autogroups.*;
import org.usfirst.frc.team1922.robot.subsystems.*;

public class Robot extends TimedRobot {
	public static DriveTrain_Subsystem m_driveTrain; 
	public static Intake_Subsystem m_intake;
	public static Elevator_Subsystem m_elevator;
	public static OI m_oi;


	Command m_autonomousCommand;
	SendableChooser<Integer> m_chooser = new SendableChooser<>(); //Allows options to be added in the SmartDashboard
	
	public static String getPositions() {
		return DriverStation.getInstance().getGameSpecificMessage();
		/** Gets the FMS (Field management system) data, returned in a three char string, EX. RRR, LRL, 
		 depending on the switch and scale alignment
		 */
	}

	@Override
	public void robotInit() { //Runs once when the bot initializes, perfect for declaring variables
		m_driveTrain = new DriveTrain_Subsystem();
		m_intake = new Intake_Subsystem();
		m_elevator = new Elevator_Subsystem();
		
		
		
		m_oi = new OI();
		//CameraServer.getInstance().startAutomaticCapture();
		m_chooser.addDefault("Do Nothing", 0); //Specific option to be added to the SmartDashboard
		m_chooser.addObject("Cross Auto Line", 1);
		
		m_chooser.addObject("Center", 2);
		m_chooser.addObject("Left", 3);
		m_chooser.addObject("Right", 4);
		m_chooser.addObject("Test", 5);
		SmartDashboard.putData("Auto Chooser", m_chooser);
	
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() { //Runs once when Auto begins
		if(m_chooser.getSelected() == 0){ //Links the auto choices in the Dashboard to the autonomous files
			m_autonomousCommand = null;
		}
		else if(m_chooser.getSelected() == 1) {
			m_autonomousCommand = new CrossAutoLine();
		}
		else if(m_chooser.getSelected() == 2) {
			m_autonomousCommand = new Center();
		}
		else if(m_chooser.getSelected() == 3) {
			m_autonomousCommand = new Left();
		}
		else if(m_chooser.getSelected() == 4) {
			m_autonomousCommand = new Right();
		}
		else if(m_chooser.getSelected() == 5) {
			m_autonomousCommand = new Test();
		}
		if (m_autonomousCommand != null) {
			//m_autonomousCommand = new Center_LeftSwitch();
			m_autonomousCommand.start();
		}
	}

	@Override
	public void autonomousPeriodic() { //Periodically called during auto, name checks out
		Scheduler.getInstance().run();
		SmartDashboard.putString("driveMode", "automous");
	}

	@Override
	public void teleopInit() {
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}
	
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putString("driveMode", "teleopPeriodic");
	}
}