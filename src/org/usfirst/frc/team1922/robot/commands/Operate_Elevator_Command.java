package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

public class Operate_Elevator_Command extends Command{

	public Operate_Elevator_Command() {
		super();
		requires(Robot.m_elevator);
	}

	@Override
	protected void initialize() {
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}
	
	@Override
	protected void execute() {
		double value = Robot.m_oi.getOperator().getRawAxis(3) 
					 - Robot.m_oi.getOperator().getRawAxis(2);
		Robot.m_elevator.set(value);
		Robot.m_elevator.readEncoder();
	}
	
	@Override
	protected void end() {
		Robot.m_elevator.stop();
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
}
