
package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight_Command extends Command{

	private final double kP = .03;
	private double error = 0;
	private double start;
	
	public DriveStraight_Command(int TimeOut) {
		super();
		requires(Robot.m_driveTrain);
		setTimeout(TimeOut);
	}
	
	@Override 
	protected void initialize() {
		start = Robot.m_driveTrain.getAngle();
		SmartDashboard.putNumber("start", start);
	}
	
	@Override 
	protected void execute() {
		
		error = start - Robot.m_driveTrain.getAngle();
		
		if (error > 0) {
			Robot.m_driveTrain.drive(.35, .35-kP*error);
		}
		else if (error < 0) {
			Robot.m_driveTrain.drive(.35+kP*error, .35);
		}
		else {
			Robot.m_driveTrain.drive(.35, .35);
		}
		
		SmartDashboard.putNumber("Error", error);
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
}

