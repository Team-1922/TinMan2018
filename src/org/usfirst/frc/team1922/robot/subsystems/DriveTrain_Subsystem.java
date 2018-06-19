package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.RobotMap;
import org.usfirst.frc.team1922.robot.commands.TankDrive_Command;
import edu.wpi.first.wpilibj.SPI;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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
	private AHRS ahrs = new AHRS(SPI.Port.kMXP);
	private double pulsesPerFoot =  1300.0; //(1900 old)
	
	public DriveTrain_Subsystem()
	{
		super();
		SmartDashboard.putString("DriveTrain_Subsytem", "Created");
		rearLeft.setSelectedSensorPosition(0, 0, 10);
		rearRight.setSelectedSensorPosition(0, 0, 10);
		rearLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		rearLeft.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
		
		frontLeft.set(ControlMode.Follower, rearLeft.getDeviceID());
		frontRight.set(ControlMode.Follower, rearRight.getDeviceID());
		//gyro.reset();
		
		
		frontRight.enableCurrentLimit(false);
		//frontRight.configContinuousCurrentLimit(100, 0);
		//frontRight.configPeakCurrentLimit(0, 0);
		//frontRight.configPeakCurrentDuration(0, 0);
		
		frontLeft.enableCurrentLimit(false);
		//frontLeft.configContinuousCurrentLimit(100, 0);
		//frontLeft.configPeakCurrentLimit(0, 0);
		//frontLeft.configPeakCurrentDuration(0, 0);
		
		rearRight.enableCurrentLimit(false);
		//rearRight.configContinuousCurrentLimit(100, 0);
		//rearRight.configPeakCurrentLimit(0, 0);
		//rearRight.configPeakCurrentDuration(0, 0);
		
		rearLeft.enableCurrentLimit(false);
		//rearLeft.configContinuousCurrentLimit(100, 0);
		//rearLeft.configPeakCurrentLimit(0, 0);
		//rearLeft.configPeakCurrentDuration(0, 0);

		
		
		
	}
	
	public double getPitch() {
		return ahrs.getPitch();
	}
	
	public double getAngle() {
		return ahrs.getAngle();
	}
	
	public int getPosLeft() {
		return -rearLeft.getSensorCollection().getQuadraturePosition();
	}
	
	public int getPosRight() {
		return rearRight.getSensorCollection().getQuadraturePosition();
	}
	
	
	/**
	 * Method gives the the total distance traveled by the right side of the robot using encoders
	 * @return distance traveled by right side
	 */
	public double getRightDistFeet() {
		return (double)getPosRight()/pulsesPerFoot;  //2608
	}

	/**
	 * Method gives the the total distance traveled by the left side of the robot using encoders
	 * @return distance traveled by left side
	 */
	public double getLeftDistFeet() {
		return (double)getPosLeft()/pulsesPerFoot; //2608
	}
	
	public double getAverageDistanceFeet() {
		return (getLeftDistFeet() + getRightDistFeet())/2.0;
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
	}
	
	public void lowDrive(Joystick leftStick, Joystick rightStick) { 
		lowGear();
		double right = rightStick.getY(); //Gets the joystick position, stores it to a local variable
		double left = -leftStick.getY();
		
		rearLeft.set(left); //Specific line that sets the motor speed to the above variable
		//frontLeft.set(left);
		
		rearRight.set(right);
		//frontRight.set(right);
		
		SmartDashboard.putString("Drive Mode", "Normal Low");
		readEncoders();
	}

	public void highDrive(Joystick rightStick) {
		highGear();
		SmartDashboard.putString("Drive Mode", "Normal High");
		
		//Only takes imput from one joystick, also takes Y imput from the joystick.
		//The speed of the right motor is the base X, added to the Y of the stick, causing it to turn right with a positive Y,
		//and left with a negative Y. In addition, the left motor mirrors this, causing double the turn effect. 
	
		double right = rightStick.getX() + rightStick.getY(); 
		double left = rightStick.getX() - rightStick.getY();
		
		rearLeft.set(left);
		//frontLeft.set(left);
		rearRight.set(right);
		//frontRight.set(right);
		readEncoders();
	}
	
	public void stop() { 
		rearLeft.set(0); //Zeros the motors
		//frontLeft.set(0);
		rearRight.set(0);
		//frontRight.set(0);
		}

	public void readEncoders() {
		SmartDashboard.putNumber("getPosRight", (double)(getPosRight()));
		SmartDashboard.putNumber("getPosLeft", (double)(getPosLeft()));
		SmartDashboard.putNumber("Average Distance Travelled", getAverageDistanceFeet());
		
		
		SmartDashboard.putNumber("gyro yaw", getAngle());
		SmartDashboard.putNumber("Gyro pitch", getPitch());
		SmartDashboard.putNumber("Gyro roll", ahrs.getRoll());
		//SmartDashboard.putNumber("Displacement Y", ahrs.getDisplacementY());
		//SmartDashboard.putNumber("Displacement X" , ahrs.getDisplacementX());
		//SmartDashboard.putNumber("Displacement Z", ahrs.getDisplacementZ());
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
	
	public double getDispX() {
		return 3.28084 * ahrs.getDisplacementX();
	}
	
	public double getDispY() {
		return 3.28084 * ahrs.getDisplacementY();
	}
	
	public double getDisplacement() {
		return Math.sqrt(Math.pow(getDispX(), 2) + Math.pow(getDispY(), 2));
	}
	
	public void ZeroDisplacement() {
		ahrs.resetDisplacement();
	}

}