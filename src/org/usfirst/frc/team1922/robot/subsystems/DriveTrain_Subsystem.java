package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.RobotMap;
import org.usfirst.frc.team1922.robot.commands.TankDrive_Command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

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
	
	public DriveTrain_Subsystem()
	{
		super();
		SmartDashboard.putString("DriveTrain_Subsytem", "Created");
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
		double left = rightStick.getY();
		double right = leftStick.getY();
		
		rearLeft.set(left);
		frontLeft.set(left);
		rearRight.set(right);
		frontRight.set(right);
		SmartDashboard.putString("DriveTrain_Subsytem mode", "lowDrive");
	}

	public void highDrive(Joystick rightStick) {
		highGear();
		double left = rightStick.getY() + rightStick.getX();
		double right = rightStick.getY() - rightStick.getX();
		
		rearLeft.set(left);
		frontLeft.set(left);
		rearRight.set(right);
		frontRight.set(right);
		SmartDashboard.putString("DriveTrain_Subsytem mode", "highDrive");
	}
	
	public void stop() {
		rearLeft.set(0);
		frontLeft.set(0);
		rearRight.set(0);
		frontRight.set(0);
		SmartDashboard.putString("DriveTrain_Subsytem stop", "ran");
	}

	public int getFrontRightPos() {
		return frontRight.getSensorCollection().getQuadraturePosition();
	}

	public void drive(double left, double right) {
		rearLeft.set(left);
		frontLeft.set(left);
		rearRight.set(right);
		frontRight.set(right);
		SmartDashboard.putString("DriveTrain_Subsytem mode", "drive" + left + " / " + right);
	}
}