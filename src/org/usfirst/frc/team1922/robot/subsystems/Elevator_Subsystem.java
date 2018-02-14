package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.RobotMap;
//import org.usfirst.frc.team1922.robot.commands.Operate_Elevator_Command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator_Subsystem extends Subsystem{

	private WPI_TalonSRX elevator; 
	private WPI_TalonSRX elevator2;
	
	public Elevator_Subsystem() {
		super();
		elevator = new WPI_TalonSRX(RobotMap.ELEVATOR);
		elevator.setSelectedSensorPosition(0, 0, 10);
		elevator.configForwardSoftLimitEnable(true, 10);
		elevator.configForwardSoftLimitThreshold(RobotMap.ELEVATOR_SCALE_HEIGHT, 10);
		elevator.configReverseSoftLimitEnable(true, 10);
		elevator.configReverseSoftLimitThreshold(RobotMap.ELEVATOR_BOTTOM, 10);
		//elevator.configReverseSoftLimitEnable(false, 10);
		//elevator.configForwardSoftLimitEnable(false, 10);
		
		elevator2 = new WPI_TalonSRX(RobotMap.ELEVATOR2);
		//elevator2.setSelectedSensorPosition(0, 0, 10);
		//elevator2.configForwardSoftLimitEnable(true, 10);
		//elevator2.configForwardSoftLimitThreshold(RobotMap.ELEVATOR_SCALE_HEIGHT, 10);
		//elevator2.configReverseSoftLimitEnable(true, 10);
		//elevator2.configReverseSoftLimitThreshold(RobotMap.ELEVATOR_BOTTOM, 10);
		//elevator2.configReverseSoftLimitEnable(false, 10);
		//elevator2.configForwardSoftLimitEnable(false, 10);
		
		SmartDashboard.putString("Elevator_Subsytem", "created");
	}
	
	
	@Override
	protected void initDefaultCommand() {
		//setDefaultCommand(new Operate_Elevator_Command());
	}
		
	public void set(double in) { 
		elevator.set(in);
		elevator2.set(in);
	}
	
	/**
	 * give position of the elevator
	 * @return elevator position in pulses
	 */
	public int getPosition() {
		return elevator.getSensorCollection().getQuadraturePosition(); 
	}
	
	public void readEncoder(){
		int i = elevator.getSensorCollection().getQuadraturePosition();
		SmartDashboard.putNumber("encoder get:", (double)i);
		//4,096 pulses per rotation
	}
	
	public void stop() {
		elevator.set(0);
		elevator2.set(0);
	}
	
	/*
	public boolean isTop() {
		if (getPosition() >= RobotMap.ELEVATOR_SCALE_HEIGHT) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isBot() {
		if (getPosition() <= RobotMap.ELEVATOR_BOTTOM) {
			return true;
		}
		return false;
	}
	
	public boolean isBelowSwitch() {
		if(getPosition() <= RobotMap.ELEVATOR_SWITCH_HEIGHT) {
			return true;
		}
		return false;
	}
	
	public boolean isSwitch() {
		if(getPosition() <= RobotMap.ELEVATOR_SWITCH_HEIGHT + 1000 && getPosition() >= RobotMap.ELEVATOR_SWITCH_HEIGHT - 1000) {
			return true;
		}
		return false;
	}

	public void setSwitchLimit() {
		elevator.configForwardSoftLimitThreshold(RobotMap.ELEVATOR_SWITCH_HEIGHT+500, 0);
		elevator.configReverseSoftLimitThreshold(RobotMap.ELEVATOR_SWITCH_HEIGHT-500, 0);
	}
	
	public void removeSwitchLimit() {
		elevator.configForwardSoftLimitThreshold(RobotMap.ELEVATOR_SCALE_HEIGHT, 0);
		elevator.configReverseSoftLimitThreshold(RobotMap.ELEVATOR_BOTTOM, 0);
	}
*/

}