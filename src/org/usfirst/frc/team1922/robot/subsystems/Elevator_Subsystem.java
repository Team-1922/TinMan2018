package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.RobotMap;
import org.usfirst.frc.team1922.robot.commands.OperateElevator_Command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Elevator_Subsystem extends Subsystem{

	private WPI_TalonSRX elevator;

	
	public Elevator_Subsystem() {
		super();
		elevator = new WPI_TalonSRX(RobotMap.ELEVATOR);
	}
	
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new OperateElevator_Command());
	}
	
	public void up(){
		elevator.set(1);
	}
	public void down() {
		elevator.set(-1);
	}
	public void brake() {
		//unimplemented brake command
		elevator.set(0);
	}

}
