package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ZeroElevator_Command extends Command{
	
	//does not need to require elevator
	
	@Override
	protected void initialize() {
		Robot.m_elevator.zeroEncoder();
		SmartDashboard.putString("Zero Elevator", "call");
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
