package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OperateElevator_Command extends Command{

	int last; 
	public OperateElevator_Command() {
		super();
		requires(Robot.m_elevator);
		//int last = 0;
	}
	
	@Override
	protected void initialize() {
		last = Robot.m_elevator.getPosition();
	}
	
	@Override
	protected void execute() {
		if(Robot.m_oi.getOperator().getRawAxis(3) > 0 || Robot.m_oi.getOperator().getRawAxis(2) > 0) {
			Robot.m_elevator.set(Robot.m_oi.getOperator().getRawAxis(3)
							   - Robot.m_oi.getOperator().getRawAxis(2));
			last = Robot.m_elevator.getPosition();
		}
		else {
			Robot.m_elevator.stop();
			//obot.m_elevator.freeze(last);
		}
		Robot.m_elevator.readEncoder();
		SmartDashboard.putNumber("Elevator Height", last);
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
