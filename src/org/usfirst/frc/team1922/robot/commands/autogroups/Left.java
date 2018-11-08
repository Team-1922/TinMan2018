package org.usfirst.frc.team1922.robot.commands.autogroups;

import org.usfirst.frc.team1922.robot.Robot;
import org.usfirst.frc.team1922.robot.RobotMap;
import org.usfirst.frc.team1922.robot.commands.DeployElevator_Command;
import org.usfirst.frc.team1922.robot.commands.Deposit_Command;
import org.usfirst.frc.team1922.robot.commands.DriveStraight_Command;
import org.usfirst.frc.team1922.robot.commands.ElevateToSwitch_Command;
import org.usfirst.frc.team1922.robot.commands.TurnTo_Command;
import org.usfirst.frc.team1922.robot.commands.Wait;
import org.usfirst.frc.team1922.robot.commands.ZeroDrive_Command;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Left extends CommandGroup{
	
	public Left() {
		
		if(Robot.getPositions().substring(0,1).equals("L")) {
			
			addSequential( new ZeroDrive_Command());
			addSequential( new Wait(.1));
			addSequential( new DeployElevator_Command());
			addSequential( new Wait(.5));
			addParallel( new ElevateToSwitch_Command());
			addSequential( new Wait(.5)); 
			
			addSequential( new DriveStraight_Command(13.75 - (RobotMap.BotLength/2)));
			//addSequential( new DriveTo_Command(0, 11 - RobotMap.BotLength)); 
			addSequential( new Wait(.2));
			
			addSequential( new ZeroDrive_Command());
			addSequential( new Wait(.5));
			addSequential( new TurnTo_Command(90));
			
			addSequential( new Wait(.2));
			
			addSequential( new Deposit_Command());	
		}
//		else if(Robot.getPositions().substring(1,2).equals("L")){
//				addSequential( new ZeroDrive_Command());
//				addSequential( new Wait(.1));
//				addSequential( new DeployElevator_Command());
//				addSequential( new Wait(.5));
//				
//				addSequential( new DriveStraight_Command (27 - RobotMap.BotLength)); //22
//				addSequential( new Wait(.2));
//				
//				
//				addSequential( new ZeroDrive_Command());
//				addSequential( new Wait(.5));
//				addSequential( new TurnTo_Command(90));
//				addSequential( new Wait(.2));
//				addSequential( new ElevateToScale_Command());
//				addSequential( new Wait(.5));
//
//				
//				addSequential( new Deposit_Command());
//		} 
		else {
			addParallel( new DeployElevator_Command());
			addSequential( new DriveStraight_Command(11));
		}
	}
	
}
