package org.usfirst.frc.team1922.robot.commands.autogroups;

import org.usfirst.frc.team1922.robot.commands.DriveStraight_Command;
import org.usfirst.frc.team1922.robot.commands.DriveTo_Command;
import org.usfirst.frc.team1922.robot.commands.Wait;
import org.usfirst.frc.team1922.robot.commands.ZeroDrive_Command;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Test extends CommandGroup{
	public Test() {
		addSequential( new ZeroDrive_Command());
		addSequential( new Wait(.3));
		addSequential( new DriveStraight_Command(10));
		addSequential (new Wait (2));
		addSequential (new DriveStraight_Command(10));
		//addSequential (new DriveStraight_Command(20));
	}
}
