package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;
import org.usfirst.frc.team1922.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevateToScale_Command extends Command{

	public ElevateToScale_Command() {
		super();
		requires(Robot.m_elevator);
	}
	
	@Override
	protected void initialize() {
		//Robot.m_elevator.goTo(100);
		Robot.m_elevator.set(.5);
		SmartDashboard.putNumber("Elevator Target", (double)RobotMap.ELEVATOR_SCALE_HEIGHT);
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
		return Robot.m_elevator.isTop();
		//return false;
	}
	
	@Override 
	protected void interrupted() {
		end();
	}

	
}
