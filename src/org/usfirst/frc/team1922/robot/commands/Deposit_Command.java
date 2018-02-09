package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Deposit_Command extends Command{

	@Override
	protected void initialize() {
		setTimeout(4);
		Robot.m_intake.set(.55);
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected void end() {
		Robot.m_intake.stop();
	}
	
	@Override
	protected void interrupted() {
		end();
	}

	
}
