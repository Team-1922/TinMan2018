package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Deposit_Command extends Command{

	public Deposit_Command() {
		super();
		requires(Robot.m_intake);
	}
	
	@Override
	protected void initialize() {
		setTimeout(4);
		Robot.m_intake.set(.55);
		SmartDashboard.putString("Desposit_Comand", "run");
	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
		//return false;
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected void end() {
		Robot.m_intake.stop();
		SmartDashboard.putString("Deposit_Command", "ended");
	}
	
	@Override
	protected void interrupted() {
		end();
	}

	
}
