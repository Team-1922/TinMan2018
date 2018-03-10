
package org.usfirst.frc.team1922.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScaleAuto extends CommandGroup{

	public ScaleAuto(){
		addSequential(new DriveToScale_Command());
		addSequential(new ElevateToScale_Command());
		
		//addSequential(new Turn_Command());
		addSequential(new Deposit_Command());
	}
}
