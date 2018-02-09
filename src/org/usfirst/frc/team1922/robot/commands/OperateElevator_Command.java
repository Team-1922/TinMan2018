
package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OperateElevator_Command extends Command{

	public OperateElevator_Command() {
		super();
		requires(Robot.m_elevator);
		SmartDashboard.putString("OperateElevator_Command", "Created");
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
	}
	
	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		
			if(Robot.m_oi.operatorTriggerIsPressed()){
				Robot.m_elevator.toScale();
			}
			else if(Robot.m_oi.operatorSecondIsPressed()) {
				Robot.m_elevator.toSwitch();
			}
			else if(Robot.m_oi.operatorThirdIsPressed()) {
				Robot.m_elevator.toBottom();
			}
			else {
				Robot.m_elevator.stop();
			}
		Robot.m_elevator.readEncoder();
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.m_elevator.brake();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}

}