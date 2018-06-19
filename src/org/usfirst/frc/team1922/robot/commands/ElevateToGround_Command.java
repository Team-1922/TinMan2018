package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;
import org.usfirst.frc.team1922.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevateToGround_Command extends Command{
	public ElevateToGround_Command() {
		super();
		requires(Robot.m_elevator);
	}
	
	@Override
	protected void initialize() {
		Robot.m_elevator.set(-.6);
		SmartDashboard.putNumber("Elevator Target", (double)RobotMap.ELEVATOR_BOTTOM);
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
		return false;
	}
	
	@Override 
	protected void interrupted() {
		end();
	}
}
