
package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.RobotMap;
import org.usfirst.frc.team1922.robot.commands.OperateElevator_Command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator_Subsystem extends Subsystem{

	private WPI_TalonSRX elevator;

	
	public Elevator_Subsystem() {
		super();
		elevator = new WPI_TalonSRX(RobotMap.ELEVATOR);
		SmartDashboard.putString("Elevator_Subsytem", "created");
	}
	
	
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new OperateElevator_Command());
	}
	
	public void up(){
		elevator.set(.75);
		SmartDashboard.putString("ElevatorSubsytem mode", "up");
	}
	public void up(double in) {
		elevator.set(in);
	}
	public void down() {
		elevator.set(-.75);
		SmartDashboard.putString("ElevatorSubsytem mode", "down");
	}
	public void brake() {
		elevator.set(0);
		SmartDashboard.putString("ElevatorSubsytem mode", "brake");
	}
	
	public void setScale(){
		
	}
	public void setSwitch(){
	
	}
	public void setCollect() {
		
	}
	
	public void readEncoder(){
		String value = "" + elevator.get();
		SmartDashboard.putString("Elevator Encoder Get:", value);
		
	}


	public boolean isFlush() {
		if (elevator.get() <= .05 && elevator.get() >= -.05) {
			return true;
		}
		return false;
	}


	public void stop() {
		elevator.set(0);
	}
}

