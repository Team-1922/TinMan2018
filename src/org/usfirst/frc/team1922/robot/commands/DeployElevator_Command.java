package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;
//import org.usfirst.frc.team1922.robot.subsystems.Elevator_Subsystem;
import edu.wpi.first.wpilibj.command.Command;

public class DeployElevator_Command extends Command {
	public DeployElevator_Command(){
		super();
		requires(Robot.m_elevator);
		setTimeout(1);
		
	}
	
	@Override
	protected void initialize() {
		Robot.m_elevator.zeroEncoder();
		Robot.m_elevator.set(.6);

	}
	
	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	@Override
	protected void execute() {
		
	}
	
	@Override
	protected void end() {
		Robot.m_elevator.deployElevator();
	}
	

	
	@Override 
	protected void interrupted() {
		end();
	}

}

