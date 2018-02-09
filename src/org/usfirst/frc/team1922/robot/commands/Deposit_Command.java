package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Deposit_Command extends Command{

	@Override
	protected void initialize() {
		Robot.m_intake.set(.55);
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
}
