package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.RobotMap;
import org.usfirst.frc.team1922.robot.commands.TankDrive_Command;
import edu.wpi.first.wpilibj.SPI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain_Subsystem extends Subsystem{

	private WPI_TalonSRX rearLeft = new WPI_TalonSRX(RobotMap.REARLEFT);
	private WPI_TalonSRX frontLeft = new WPI_TalonSRX(RobotMap.FRONTLEFT);
	private WPI_TalonSRX rearRight = new WPI_TalonSRX(RobotMap.REARRIGHT);
	private WPI_TalonSRX frontRight = new WPI_TalonSRX(RobotMap.FRONTRIGHT);
	private Solenoid gearShift = new Solenoid(RobotMap.GEARSHIFT);
	private AHRS gyro = new AHRS(SPI.Port.kMXP);
	
	public DriveTrain_Subsystem()
	{
		super();
		SmartDashboard.putString("DriveTrain_Subsytem", "Created");
		//rearLeft.config
		//rearLeft.setSelectedSensorPosition(0, 0, 10);
		//rearRight.setSelectedSensorPosition(0, 0, 10);
		
		frontLeft.set(ControlMode.Follower, rearLeft.getDeviceID());
		frontRight.set(ControlMode.Follower, rearRight.getDeviceID());
		
		
	}
	
	public double getAngle() {
		return gyro.getAngle();
	}
	
	public void lowGear(){
		gearShift.set(true);
	}
	public void highGear(){
		gearShift.set(false);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TankDrive_Command());
		SmartDashboard.putString("DriveTrain_Subsytem default", "default set: TankDrive_Command");
	}
	
	public void lowDrive(Joystick leftStick, Joystick rightStick) {
		lowGear();
		double left = -rightStick.getY();
		double right = leftStick.getY();
		
		rearLeft.set(left);
		//frontLeft.set(left);
		rearRight.set(right);
		//frontRight.set(right);
		SmartDashboard.putString("DriveTrain_Subsytem mode", "lowDrive");
	}

	public void highDrive(Joystick rightStick) {
		highGear();
		double right = rightStick.getX() + rightStick.getY();
		double left = rightStick.getX() - rightStick.getY();
		
		rearLeft.set(left);
		//frontLeft.set(left);
		rearRight.set(right);
		//frontRight.set(right);
		SmartDashboard.putString("DriveTrain_Subsytem mode", "highDrive");
	}
	
	public void stop() {
		rearLeft.set(0);
		//frontLeft.set(0);
		rearRight.set(0);
		//frontRight.set(0);
		SmartDashboard.putString("DriveTrain_Subsytem stop", "ran");
	}

	/*
	public void readEncoders() {
		SmartDashboard.putNumber("Right Drive", (double)(getRightPos()));
		SmartDashboard.putNumber("Left Drive", (double)(getLeftPos()));
	}
	
	public int getRightPos() {
		return rearRight.getSensorCollection().getQuadraturePosition();
	}

	public int getLeftPos() {
		return rearLeft.getSensorCollection().getQuadraturePosition();
	}
	*/
	
	public void drive(double left, double right) {
		rearLeft.set(left);
		//frontLeft.set(left);
		rearRight.set(-right);
		//frontRight.set(right);
		SmartDashboard.putString("DriveTrain_Subsytem mode", "drive" + left + " / " + right);
	}
}