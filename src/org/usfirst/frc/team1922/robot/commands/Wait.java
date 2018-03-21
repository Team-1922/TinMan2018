package org.usfirst.frc.team1922.robot.commands;

import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Wait extends Command{
	
	public Wait(int duration) {
		super();
		requires(Robot.m_driveTrain);
		setTimeout(duration);
	}
	
	public Wait(double duration) {
		super();
		requires(Robot.m_driveTrain);
		setTimeout(duration);
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}

}
