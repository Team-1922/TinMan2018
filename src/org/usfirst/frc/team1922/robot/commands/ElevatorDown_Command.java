package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ElevatorDown_Command extends Command {

	public ElevatorDown_Command() {
		super();
		requires(Robot.m_elevator);
	}
	@Override
	protected void initialize() {
		Robot.m_elevator.set(-.6);
		
	}
	
	@Override
	protected void execute() {
		Robot.m_elevator.readEncoder();
	}
	
	@Override
	protected void end() {
		Robot.m_elevator.stop();
	}
	
	@Override
	protected boolean isFinished() {
		//return Robot.m_elevator.isTop();
		return false;
	}
	
	@Override 
	protected void interrupted() {
		end();
	}

}
