package org.usfirst.frc.team1922.robot.commands.autogroups;

import org.usfirst.frc.team1922.robot.Robot;
import org.usfirst.frc.team1922.robot.RobotMap;
import org.usfirst.frc.team1922.robot.commands.DeployElevator_Command;
import org.usfirst.frc.team1922.robot.commands.Deposit_Command;
import org.usfirst.frc.team1922.robot.commands.DriveStraight_Command;
//import org.usfirst.frc.team1922.robot.commands.DriveStraight_Command;
import org.usfirst.frc.team1922.robot.commands.DriveTo_Command;
import org.usfirst.frc.team1922.robot.commands.ElevateToScale_Command;
import org.usfirst.frc.team1922.robot.commands.ElevateToSwitch_Command;
import org.usfirst.frc.team1922.robot.commands.TurnTo_Command;
import org.usfirst.frc.team1922.robot.commands.Wait;
import org.usfirst.frc.team1922.robot.commands.ZeroDrive_Command;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Center extends CommandGroup{
	
	public Center() {
	addSequential( new DeployElevator_Command());
		if (Robot.getPositions().substring(0,1).equals("L")) {

			addSequential( new ZeroDrive_Command());
			addSequential (new Wait(.5));
			
			addSequential( new DriveStraight_Command(3)); 
			addSequential( new Wait(.2));
			addSequential( new ZeroDrive_Command());
			addSequential (new Wait(.5));
			
			addSequential( new TurnTo_Command(-90));
			addSequential( new Wait(.2));
			addSequential( new ZeroDrive_Command());
			addSequential (new Wait(.5));
			
			addSequential( new DriveStraight_Command(10.0 - RobotMap.BotLength));
			addSequential( new Wait(.2));
			addSequential( new ZeroDrive_Command());
			addSequential (new Wait(.5));
			
			addSequential( new TurnTo_Command(90));
			addSequential( new Wait(.2));
			addSequential( new ZeroDrive_Command());
			addSequential (new Wait(.5));
			
			addSequential( new DriveStraight_Command(8.6 - RobotMap.BotLength));
			addParallel(new ElevateToScale_Command());
			addSequential( new Wait(.2));
			
			addSequential( new Deposit_Command());
			
			
			
			
			
			
			
//			addSequential( new ZeroDrive_Command());
//			addSequential (new Wait(.2));
//			addSequential( new DriveStraight_Command(1)); 
//			addSequential( new Wait(.2));
//		
//			addSequential( new ZeroDrive_Command());
//			addSequential( new Wait(.2));
//			addSequential (new TurnTo_Command (-39.792));
//			//addSequential( new DriveTo_Command(-46.979, 9.6 - RobotMap.BotLength)); 
//		
//			addSequential( new Wait (.2));
//			addSequential( new ZeroDrive_Command());
//			addSequential( new Wait (.2));
//			addSequential( new DriveStraight_Command(13 - RobotMap.BotLength));
//			
//			
//			addSequential( new Wait(.2));
//		
//			addSequential( new ZeroDrive_Command());
//			addSequential( new Wait(.2));
//			addParallel( new ElevateToSwitch_Command());
//			addParallel( new Wait(.5));
//			addSequential( new DriveTo_Command(0, 3));
//			
//			addSequential( new Deposit_Command());
		}
		else if(Robot.getPositions().substring(0,1).equals("R")) {
			
			addSequential( new ZeroDrive_Command());
			addSequential( new Wait(.2));;
//			addSequential( new DriveTo_Command(0, 2)); 
//			addSequential( new Wait(.2));
//			
//			addSequential( new ZeroDrive_Command());
//			addSequential( new Wait(.2));
//			
			addSequential( new DriveStraight_Command(7.67 - RobotMap.BotLength));
			addParallel( new ElevateToSwitch_Command());
			addSequential( new Wait(.2));
			addSequential( new ZeroDrive_Command());
			addSequential( new Wait (.2));
			
			addSequential( new DriveStraight_Command(2));
			addSequential( new Wait(.2));
			addSequential( new ZeroDrive_Command());
			addSequential( new Wait (.2));
			
			
			
//			addSequential (new TurnTo_Command (19.877));
//			//addSequential( new DriveTo_Command(26.562, 7.826  - RobotMap.BotLength));
//			
//			addSequential( new Wait(.2));
//			addSequential( new ZeroDrive_Command());
//			addSequential( new Wait (.2));
//			addSequential( new DriveStraight_Command(11.70 - RobotMap.BotLength));
//			
//			addSequential( new ZeroDrive_Command());
//			addSequential( new Wait(.2));
//			addParallel( new ElevateToSwitch_Command());
//			addParallel( new Wait(.5));
//			addSequential( new DriveTo_Command(0, 3));
//			addSequential( new Deposit_Command());
			
		}
		else {
			addParallel( new Wait(.2));
			addSequential( new DriveTo_Command(0, 10));
		}
	}
}
