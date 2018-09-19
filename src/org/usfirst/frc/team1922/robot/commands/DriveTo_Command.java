package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTo_Command extends Command{

	private double heading, destination, error, speed, kp;
	
	public DriveTo_Command(double heading, double feet) {
		super();
		requires(Robot.m_driveTrain);
		this.destination = feet;
		this.heading = heading;
		speed = .5; //.5
	}
	
	public DriveTo_Command(double heading, double feet, double speed) {
		super();
		requires(Robot.m_driveTrain);
		this.destination = feet;
		this.heading = heading;
		this.speed = speed;
	}
	
	
	private void readValues() {
		SmartDashboard.putNumber("Current Gyro:", Robot.m_driveTrain.getAngle());
		SmartDashboard.putNumber("Input Heading:", heading);
		SmartDashboard.putNumber("Drive to Destination", destination);
		SmartDashboard.putNumber("Drive Error", error);
	}
	
	@Override
	protected void initialize() {
		error = 0;
		kp = .01;
		SmartDashboard.putNumber("Drive to heading", heading);
	}
	
	@Override
	protected void execute() {
		error = heading - Robot.m_driveTrain.getAngle();
		Robot.m_driveTrain.drive(speed + kp*error , speed - kp*error);
		readValues();

	}
	
	@Override
	protected boolean isFinished() {
		if ( Robot.m_driveTrain.getAverageDistanceFeet() >= destination) {
			SmartDashboard.putString("Drive_To_Command", "Is Finished");
			 return true;
		}
		else if (Math.abs(Robot.m_driveTrain.getPitch()) >= 10) { //10
			SmartDashboard.putString("Drive_To_Command", "Terminated: pitch error");
			return true;
		}
		else {
			SmartDashboard.putNumber("Drive To progress", Robot.m_driveTrain.getDisplacement());
			SmartDashboard.putNumber("Drive to destination", destination);
			return false; 
		}
	}
	
	@Override
	protected void end() {
		Robot.m_driveTrain.stop();
	}
	
	@Override
	protected void interrupted() {
		end();
	}

}
