package org.usfirst.frc.team1922.robot.commands;
import org.usfirst.frc.team1922.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ZeroDrive_Command extends Command{
	
	public ZeroDrive_Command() {
		super();
		requires(Robot.m_driveTrain);
	}
	
	@Override
	protected void initialize() {
		Robot.m_driveTrain.zeroEncoders();
		SmartDashboard.putString("Zero Drive Command", "Is Running");
	}
	
	@Override
	protected boolean isFinished() {
		Robot.m_driveTrain.readEncoders();
		SmartDashboard.putString("Zero Drive Command", "Is Finished");
		return true;
	}
}
