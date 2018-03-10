package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDrive_Command extends Command{

		public TankDrive_Command() {
		super();
		SmartDashboard.putString("TankDrive_Command", "Created");
		requires(Robot.m_driveTrain);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.m_driveTrain.lowGear();
		SmartDashboard.putString("TankDrive_Command initialize", "Initialize");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putString("TankDrive_Command execute", "execute");
		if (Robot.m_oi.leftTriggerIsPressed()) {
			Robot.m_driveTrain.highDrive(Robot.m_oi.getRightStick());
		}
		else {
			Robot.m_driveTrain.lowDrive(Robot.m_oi.getLeftStick(), Robot.m_oi.getRightStick());
		}
		SmartDashboard.putString("gyro", Double.toString(Robot.m_driveTrain.getAngle()));
		//Robot.m_driveTrain.readEncoders();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		SmartDashboard.putString("TankDrive_Command end", "ended");
		Robot.m_driveTrain.stop();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		SmartDashboard.putString("TankDrive_Command interrupted", "interrupted");
		end();
	}
}