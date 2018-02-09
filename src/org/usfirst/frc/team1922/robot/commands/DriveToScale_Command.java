package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;
import org.usfirst.frc.team1922.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DriveToScale_Command extends Command{
	
	public DriveToScale_Command(){
		super();
		requires(Robot.m_driveTrain);
	}
	
	@Override protected void initialize() {
		Robot.m_driveTrain.drive( 1, 1 );
	}
	
	@Override 
	protected void execute() {
		
	}
	
	@Override
	protected void end() {
		Robot.m_elevator.stop();
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
	@Override
	protected boolean isFinished() {
		if(Robot.m_driveTrain.getFrontRightPos() >= RobotMap.SCALE_DISTANCE) {
			return true;
		}
		return false;
	}
}
