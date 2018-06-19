
package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight_Command extends Command{

//	private final double kP = .03;
//	private double error = 0;
	//Unused, but unsure if I should comment out 
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
		
		Robot.m_driveTrain.drive(.25, .25);
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
}

