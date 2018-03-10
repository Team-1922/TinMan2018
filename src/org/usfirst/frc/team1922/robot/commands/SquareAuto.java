package org.usfirst.frc.team1922.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SquareAuto extends CommandGroup{

	public SquareAuto(){
		for(int i = 0; i < 4; i++){
			addSequential(new DriveStraight_Command());
			addSequential(new Turn_Command(1));
		}
	}
}
