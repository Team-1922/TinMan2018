package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.RobotMap;
//import org.usfirst.frc.team1922.robot.commands.Operate_Elevator_Command;
import org.usfirst.frc.team1922.robot.commands.OperateElevator_Command;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

//import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.PIDController;
//import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Elevator_Subsystem extends Subsystem{

	private WPI_TalonSRX elevator; 
	//private WPI_TalonSRX elevator2; // Placeholder for second elevator motor
	Solenoid deployer;
	private Solenoid ratchet;
	//private PIDController controller;
	int lastEncoder = 0;
	double kp = .0005, ki = 1, kd = 0;
	     
	public Elevator_Subsystem() {
		super();
		elevator = new WPI_TalonSRX(RobotMap.ELEVATOR);
		elevator.enableCurrentLimit(true);
		elevator.configPeakCurrentLimit(0, 0);
		elevator.configContinuousCurrentLimit(30, 0);
		elevator.configPeakCurrentDuration(0, 0);
		
		//elevator.configSelectedFeedbackSensor(FeedbackDevice., arg1, arg2)
		elevator.setSensorPhase(false);
		elevator.setSelectedSensorPosition(0, 0, 10);
		elevator.configForwardSoftLimitEnable(false, 10);
		//elevator.configForwardSoftLimitThreshold(RobotMap.ELEVATOR_SCALE_HEIGHT, 10);
		elevator.configReverseSoftLimitEnable(false, 10);
		//elevator.configReverseSoftLimitThreshold(RobotMap.ELEVATOR_BOTTOM, 10);
		//elevator.configReverseSoftLimitEnable(false, 10);
		//elevator.configForwardSoftLimitEnable(false, 10);
		
		elevator.config_kP(1,.01,10);
		
		//elevator2 = new WPI_TalonSRX(RobotMap.ELEVATOR2);
		//elevator2.setSelectedSensorPosition(0, 0, 10);
		//elevator2.configForwardSoftLimitEnable(true, 10);
		//elevator2.configForwardSoftLimitThreshold(RobotMap.ELEVATOR_SCALE_HEIGHT, 10);
		//elevator2.configReverseSoftLimitEnable(true, 10);
		//elevator2.configReverseSoftLimitThreshold(RobotMap.ELEVATOR_BOTTOM, 10);
		//elevator2.configReverseSoftLimitEnable(false, 10);
		//elevator2.configForwardSoftLimitEnable(false, 10);
		
		deployer = new Solenoid(RobotMap.DEPLOYER);
		ratchet = new Solenoid(RobotMap.RATCHET);
		//retractElevator();
		//controller = new PIDController(kp, ki, kd, , (PIDSource) elevator, elevator);
	}

	public void deployElevator() {
		deployer.set(false);
	}
	
	public void retractElevator() {
		deployer.set(true);
	}
	
	public int getLastEncoder() {
		return lastEncoder;
	}
	
	public void setRatchet(boolean value) {
		ratchet.set(value);;
	}
	
	public void zeroEncoder() {
		elevator.setSelectedSensorPosition(0, 0, 0);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new OperateElevator_Command());
	}
		
	public void set(double in) { 
		elevator.set(in);
		//elevator2.follow(elevator);
		//elevator2.set((elevator.get()));
		lastEncoder = getPosition();
	}
	
	public int getPosition() {
		return elevator.getSensorCollection().getQuadraturePosition(); 
	}
	
	public void readEncoder(){
		int i = elevator.getSensorCollection().getQuadraturePosition();
		SmartDashboard.putNumber("encoder get:", (double)i);
		//4,096 pulses per rotation
	}
	
	public void stop() {
		//elevator.set(ControlMode.Position, lastEncoder);
		//elevator2.follow(elevator);
		elevator.set(0);
		
	}
	
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


	public void freeze(int dest) {
		double error = dest - getPosition();
		elevator.set(-kp*error);

		
		SmartDashboard.putNumber("freeze at", dest);
		SmartDashboard.putNumber("freeze error", error);
		SmartDashboard.putNumber("freeze input speed", -kp*error);
	}
	
	public void goTo(double target){
		//elevator.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		//elevator.reverseSensor(false);
		// _talon.configEncoderCodesPerRev(XXX)
		// _talon.configPotentiometerTurns(XXX)
		// set the peak and nominal outputs, 12V means full 
		//elevator.configNominalOutputVoltage(+0.0f, -0.0f);
		//elevator.configPeakOutputVoltage(+12.0f, -12.0f);
		// set closed loop gains in slot0 - see documentation 
		//elevator.setProfile(0);
		//elevator.setF(0);
		//elevator.setP(0);
		//elevator.setI(0);
		//elevator.setD(0);
		//elevator.setMotionMagicCruiseVelocity(0);
		//elevator.setMotionMagicAcceleration(0);
		//elevator.config_kF(0, .5, 10);
		elevator.set(ControlMode.Position, target);
		//elevator.c
	}

}