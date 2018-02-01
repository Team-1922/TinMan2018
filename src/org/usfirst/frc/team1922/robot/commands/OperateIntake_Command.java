package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OperateIntake_Command extends Command{
	public  OperateIntake_Command() {
		super();
		SmartDashboard.putString("Intake", "Created");
		requires(Robot.m_intake);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		//SmartDashboard.putString("Intake", "Initialize");
	}
	
	

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		SmartDashboard.putString("Intake", "execute");
		Robot.m_intake.run(Robot.m_oi.getOperator());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
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
