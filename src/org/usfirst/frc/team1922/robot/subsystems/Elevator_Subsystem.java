
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
		elevator.setSelectedSensorPosition(0, 0, 10);
		elevator.configForwardSoftLimitEnable(true, 10);
		elevator.configForwardSoftLimitThreshold(RobotMap.ELEVATOR_SCALE_HEIGHT, 10);
		elevator.configReverseSoftLimitEnable(true, 10);
		elevator.configReverseSoftLimitThreshold(RobotMap.ELEVATOR_BOTTOM, 10);
	}
	
	
	@Override
	protected void initDefaultCommand() {}
	
	public void set(double in) {
		elevator.set(in);
	}
	
	public void readEncoder(){
		String value = "" + elevator.get();
		int i = elevator.getSensorCollection().getQuadraturePosition();
		SmartDashboard.putNumber("encoder get:", (double)i);
		//4,096 pulses per rotation
	}
	
	public boolean isTop() {
		if (elevator.getSensorCollection().getQuadraturePosition() >= RobotMap.ELEVATOR_SCALE_HEIGHT) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void stop() {
		elevator.set(0);
	}
}

