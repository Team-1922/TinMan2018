package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;
import org.usfirst.frc.team1922.robot.RobotMap;

//import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ElevateToSwitch_Command extends Command{

	public ElevateToSwitch_Command() {
		super();
		requires(Robot.m_elevator);
	}

	@Override protected void initialize() {
		/*
		Robot.m_elevator.setSwitchLimit();
		if(Robot.m_elevator.isBelowSwitch()) {
			Robot.m_elevator.set(.25);
		}
		else {
			Robot.m_elevator.set(-.25);
		}
		*/
		
		SmartDashboard.putNumber("Elevate To Switch Height", (double)RobotMap.ELEVATOR_SWITCH_HEIGHT);
	}
	
	@Override 
	protected void execute() {
		Robot.m_elevator.freeze(RobotMap.ELEVATOR_SWITCH_HEIGHT);
		Robot.m_elevator.readEncoder();
		SmartDashboard.putString("Elevate To Switch", "Running");
	}
	
	@Override
	protected void end() {
		//Robot.m_elevator.removeSwitchLimit();
		Robot.m_elevator.stop();
		SmartDashboard.putString("Elevate To Switch", "End");
	}
	
	@Override
	protected void interrupted() {
		end();
	}
	
	@Override
	protected boolean isFinished() {
		//if(Robot.m_elevator.isSwitch()) {
		//	return true;
		//}
		return false;
	}


}
