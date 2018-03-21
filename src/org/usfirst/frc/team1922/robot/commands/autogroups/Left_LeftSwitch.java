package org.usfirst.frc.team1922.robot.commands.autogroups;

import org.usfirst.frc.team1922.robot.commands.DriveTo_Command;
import org.usfirst.frc.team1922.robot.commands.Wait;
import org.usfirst.frc.team1922.robot.commands.ZeroDrive_Command;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Left_LeftSwitch extends CommandGroup{
	
	public Left_LeftSwitch() {
		
		addSequential( new ZeroDrive_Command());
		addSequential( new DriveTo_Command(0, 1)); 
		addSequential( new Wait(1));
		
		addSequential( new ZeroDrive_Command());
		addSequential( new Wait(1));
		addSequential( new DriveTo_Command(19.653, 7.933));
		addSequential( new Wait(1));
		
		addSequential( new ZeroDrive_Command());
		addSequential( new Wait(1));
		addSequential( new DriveTo_Command(0, 3));
		addSequential( new Wait(1));
		

	}
}
