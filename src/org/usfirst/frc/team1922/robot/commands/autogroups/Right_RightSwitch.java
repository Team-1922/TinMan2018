package org.usfirst.frc.team1922.robot.commands.autogroups;

import org.usfirst.frc.team1922.robot.commands.Deposit_Command;
import org.usfirst.frc.team1922.robot.commands.DriveTo_Command;
import org.usfirst.frc.team1922.robot.commands.ElevateToSwitch_Command;
import org.usfirst.frc.team1922.robot.commands.Wait;
import org.usfirst.frc.team1922.robot.commands.ZeroDrive_Command;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Right_RightSwitch extends CommandGroup{
	
	public Right_RightSwitch() {
		
		addSequential( new ZeroDrive_Command());
		addSequential( new DriveTo_Command(0, 1)); 
		addParallel( new ElevateToSwitch_Command());
		addSequential( new Wait(1));
		
		addSequential( new ZeroDrive_Command());
		addSequential( new Wait(1));
		addSequential( new DriveTo_Command(-19.653, 7.933));
		addSequential( new Wait(1));
		
		addSequential( new ZeroDrive_Command());
		addSequential( new Wait(1));
		addSequential( new DriveTo_Command(0, 3));
		addSequential( new Deposit_Command());
		addSequential( new Wait(1));
		
	}
	
}
