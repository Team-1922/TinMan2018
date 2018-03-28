package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;
//import org.usfirst.frc.team1922.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveToScale_Command extends Command{

	
	public DriveToScale_Command() {
		super();
		requires(Robot.m_driveTrain);
		setTimeout(5);
	}
	
	@Override 
	protected void initialize() {
		Robot.m_driveTrain.drive(.25, .25); 
		
	}
	
	@Override
	protected void end() {
		Robot.m_driveTrain.stop();
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
	@Override 
	protected void execute() {}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
}
