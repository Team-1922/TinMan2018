
package org.usfirst.frc.team1922.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Rotate_Command extends Command{

	double angle;
	
	public Rotate_Command(double angle) {
		this.angle = angle;
	}
	
	

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
}
