package org.usfirst.frc.team1922.robot.commands.autogroups;

import org.usfirst.frc.team1922.robot.commands.DeployElevator_Command;
import org.usfirst.frc.team1922.robot.commands.DriveStraight_Command;
//import org.usfirst.frc.team1922.robot.commands.DriveTo_Command;
import org.usfirst.frc.team1922.robot.commands.Wait;
import org.usfirst.frc.team1922.robot.commands.ZeroDrive_Command;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class CrossAutoLine extends CommandGroup{
	
	public  CrossAutoLine() {
		addSequential( new ZeroDrive_Command());
		addSequential( new Wait(.25));
		addParallel( new DeployElevator_Command());
		addSequential( new DriveStraight_Command(11));
	}
}
