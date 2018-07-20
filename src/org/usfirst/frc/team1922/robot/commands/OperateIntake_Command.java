package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OperateIntake_Command extends Command{
	public  OperateIntake_Command() {
		super();
		requires(Robot.m_intake);
		SmartDashboard.putString("OperateIntake_Command", "Created");
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
			}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.m_intake.runLeft(-Robot.m_oi.getOperator().getRawAxis(1));
		Robot.m_intake.runRight(Robot.m_oi.getOperator().getRawAxis(5));
		SmartDashboard.putString("OperateIntake_Command execute", "execute");

	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_intake.stop();
		SmartDashboard.putString("OperateIntake_Command", "ended");

	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
		SmartDashboard.putString("OperateIntake_Command interrupted", "true");

	}
}
