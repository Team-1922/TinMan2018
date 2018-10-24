package org.usfirst.frc.team1922.robot.commands.autogroups;

import org.usfirst.frc.team1922.robot.commands.DeployElevator_Command;
import org.usfirst.frc.team1922.robot.commands.DriveStraight_Command;
import org.usfirst.frc.team1922.robot.commands.DriveTo_Command;
import org.usfirst.frc.team1922.robot.commands.TurnTo_Command;
import org.usfirst.frc.team1922.robot.commands.Turn_Command;
import org.usfirst.frc.team1922.robot.commands.Wait;
import org.usfirst.frc.team1922.robot.commands.ZeroDrive_Command;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Test extends CommandGroup{
	public Test() {
		addSequential( new ZeroDrive_Command());
		addSequential( new Wait(.3));
		//addSequential( new DriveTo_Command(-90,5));
		addSequential (new DeployElevator_Command());
		//addSequential (new TurnTo_Command(90));
		//addSequential (new DriveStraight_Command(20));
	}
}
