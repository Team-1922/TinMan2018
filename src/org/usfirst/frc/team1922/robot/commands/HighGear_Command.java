package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class HighGear_Command extends Command{

	
	public HighGear_Command() {
		super();
		SmartDashboard.putString("High Gear", "Creating...");
		//requires(Robot.m_driveTrain);
		SmartDashboard.putString("High Gear", "Created");
	}
	
	// Called just before this Command runs the first time
		@Override
		protected void initialize() {
			SmartDashboard.putString("High Gear 2", "Initialize");
			Robot.m_driveTrain.highGear();
		}
		

		// Called repeatedly when this Command is scheduled to run
		@Override
		protected void execute() {
			SmartDashboard.putString("High Gear 3", "Execute");
			Robot.m_driveTrain.highDrive(Robot.m_oi.getRightStick(), Robot.m_oi.getLeftStick());
		}

		// Make this return true when this Command no longer needs to run execute()
		@Override
		protected boolean isFinished() {
			return !Robot.m_oi.leftTriggerIsPressed();
			//return false;
		}

		// Called once after isFinished returns true
		@Override
		protected void end() {
			Robot.m_driveTrain.stop();
		}

		// Called when another command which requires one or more of the same
		// subsystems is scheduled to run
		@Override
		protected void interrupted() {
			end();
		}

}
