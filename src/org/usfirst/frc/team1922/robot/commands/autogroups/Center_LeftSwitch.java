package org.usfirst.frc.team1922.robot.commands.autogroups;

import org.usfirst.frc.team1922.robot.commands.DriveTo_Command;
import org.usfirst.frc.team1922.robot.commands.Wait;
import org.usfirst.frc.team1922.robot.commands.ZeroDrive_Command;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Center_LeftSwitch extends CommandGroup{
	
	public Center_LeftSwitch() {
		
		addSequential( new ZeroDrive_Command());
		addSequential( new DriveTo_Command(0, 1)); 
		addSequential( new Wait(1));
		
		addSequential( new ZeroDrive_Command());
		addSequential( new Wait(1));
		addSequential( new DriveTo_Command(-46.979, 10.259));
		addSequential( new Wait(1));
		
		addSequential( new ZeroDrive_Command());
		addSequential( new Wait(1));
		addSequential( new DriveTo_Command(0, 3));
		addSequential( new Wait(1));
	}
}
