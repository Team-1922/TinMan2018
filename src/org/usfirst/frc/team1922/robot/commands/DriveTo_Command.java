package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTo_Command extends Command{

	private double heading, destination, error, speed, kp;
	
	public DriveTo_Command(double heading, double feet) {
		super();
		requires(Robot.m_driveTrain);
		this.destination += feet;
		this.heading = heading;
	}
	
	@Override
	protected void initialize() {
		SmartDashboard.putString("Drive_To_Command", "Is Running");
		SmartDashboard.putNumber("Current Gyro:", Robot.m_driveTrain.getAngle());
		SmartDashboard.putNumber("Input Heading:", heading);
		destination *= 1410.5;
		SmartDashboard.putNumber("Drive to Destination", destination);
		error = 0;
		speed = .5;
		//kp = 2.0/90.0;
		kp = .01;
		//Robot.m_driveTrain.zeroEncoders();
		//Robot.m_driveTrain.readEncoders(); //this doesn't work // added zero command to Center_Switch_Auto
		SmartDashboard.putNumber("Drive to heading", heading);
	}
	
	@Override
	protected void execute() {
		error = heading - Robot.m_driveTrain.getAngle();
		Robot.m_driveTrain.drive(speed + kp*error , speed - kp*error);
		SmartDashboard.putNumber("Drive Error", error);
		SmartDashboard.putNumber("GYRO2", Robot.m_driveTrain.getAngle());	
	}
	
	@Override
	protected boolean isFinished() {
		if ( ( ((double) (Robot.m_driveTrain.getPosLeft() - Robot.m_driveTrain.getPosRight()) ) /2) >= destination) {
			SmartDashboard.putString("Drive_To_Command", "Is Finished");
			 return true;
		}
		else {
			SmartDashboard.putNumber("Drive To progress", ( ((double) (Robot.m_driveTrain.getPosLeft() 
					- Robot.m_driveTrain.getPosRight()) ) /2));
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
