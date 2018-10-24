
package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight_Command extends Command{

	private final double kP = .03;
	private double error = 0;
	//Unused, but unsure if I should comment out 
	private double destination, start, heading;
	
	public DriveStraight_Command(double d) {
		super();
		requires(Robot.m_driveTrain);
		this.destination = d;
		this.heading = start;		
	}
	
	private void readValues() {
		SmartDashboard.putNumber("Current Gyro:", Robot.m_driveTrain.getAngle());
		SmartDashboard.putNumber("Drive to Destination", destination);
	}
	
	@Override 
	protected void initialize() {
		start = Robot.m_driveTrain.getAngle();
		SmartDashboard.putNumber("start", start);
	}
	
	@Override 
	protected void execute() {
		error = heading -     Robot.m_driveTrain.getAngle();
		Robot.m_driveTrain.drive(.4, .4);
		//Robot.m_driveTrain.drive(.5 + kP*error , .5 - kP*error);
		readValues();
	}
	
	@Override
	protected boolean isFinished() {
		if ( Robot.m_driveTrain.getAverageDistanceFeet() >= destination) {
			SmartDashboard.putString("Drive_To_Command", "Is Finished");
			 return true;
		}
		else if (Math.abs(Robot.m_driveTrain.getPitch()) >= 10) {
			SmartDashboard.putString("Drive_To_Command", "Terminated: pitch error");
			return true;
		}
		else {
			SmartDashboard.putNumber("Drive To progress", Robot.m_driveTrain.getDisplacement());
			SmartDashboard.putNumber("Drive to destination", destination);
			return false; 
		}

}
	
}


