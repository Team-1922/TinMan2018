package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.Robot;
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
		rearLeft.setSelectedSensorPosition(0, 0, 10);
		rearRight.setSelectedSensorPosition(0, 0, 10);
		
		frontLeft.set(ControlMode.Follower, rearLeft.getDeviceID());
		frontRight.set(ControlMode.Follower, rearRight.getDeviceID());
		
		
	}
	
	public double getAngle() {
		return gyro.getAngle();
	}
	
	public int getPosLeft() {
		return rearLeft.getSensorCollection().getQuadraturePosition();
	}
	
	public int getPosRight() {
		return rearRight.getSensorCollection().getQuadraturePosition();
	}
	
	public void lowGear(){
		gearShift.set(false);
	}
	public void highGear(){
		gearShift.set(true);
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
		readEncoders();
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
		readEncoders();
	}
	
	public void stop() {
		rearLeft.set(0);
		//frontLeft.set(0);
		rearRight.set(0);
		//frontRight.set(0);
		SmartDashboard.putString("DriveTrain_Subsytem stop", "ran");
	}

	public void readEncoders() {
		SmartDashboard.putNumber("getPosRight", (double)(getPosRight()));
		SmartDashboard.putNumber("getPosLeft", (double)(getPosLeft()));
		SmartDashboard.putNumber("Average Distance Travelled", (getPosLeft()-getPosRight())/2);
		SmartDashboard.putNumber("GYRO2", getAngle());
	}
	
	public void drive(double left, double right) {
		rearLeft.set(left);
		//frontLeft.set(left);
		rearRight.set(-right);
		//frontRight.set(right);
		SmartDashboard.putNumber("Drive Speed Right", right);
		SmartDashboard.putNumber("Drive Speed Left", left);
		readEncoders();
	}

	public void zeroEncoders() {
		rearLeft.setSelectedSensorPosition(0, 0, 0);
		rearRight.setSelectedSensorPosition(0, 0 , 0);
		
	}
}