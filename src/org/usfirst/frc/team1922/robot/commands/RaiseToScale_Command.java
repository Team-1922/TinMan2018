package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RaiseToScale_Command extends Command{

	public RaiseToScale_Command() {
		super(1);
		requires(Robot.m_elevator);
	}
	
	@Override
	protected void initialize() {
		Robot.m_elevator.up(.55);
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected void end() {
		Robot.m_elevator.stop();
	}
	
	@Override
	protected boolean isFinished() {
		return Robot.m_elevator.isFlush();
	}
	
	@Override 
	protected void interrupted() {
		end();
	}

	
}
