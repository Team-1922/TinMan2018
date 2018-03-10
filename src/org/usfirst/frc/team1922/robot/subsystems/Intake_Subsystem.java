package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.RobotMap;
import org.usfirst.frc.team1922.robot.commands.OperateIntake_Command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController; 

public class Intake_Subsystem extends Subsystem{

	private WPI_TalonSRX leftIntake = new WPI_TalonSRX(RobotMap.INTAKELEFT);
	private WPI_TalonSRX rightIntake = new WPI_TalonSRX(RobotMap.INTAKERIGHT);

	
	public Intake_Subsystem()
	{
		super();
		SmartDashboard.putString("Intake_Subsytem", "Created");
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new OperateIntake_Command());
	}
	
	public void run(XboxController operator) {
		leftIntake.set(operator.getRawAxis(1));
		rightIntake.set(operator.getRawAxis(1));
		SmartDashboard.putString("Intake_Subsystem", "Running");
	}
	
	//public void run(Joystick operator) {
		//leftIntake.set(operator.getY());
		//rightIntake.set(operator.getY());
		//SmartDashboard.putString("Intake_Subsystem", "Running");
	//}
	
	public void set(double in) {
		leftIntake.set(in);
		rightIntake.set(in);
	}

	public void stop() {
		rightIntake.set(0);
		leftIntake.set(0);
		SmartDashboard.putString("Intake_Subsytem", "stopped");
	}

	public void runLeft(double value) {
		leftIntake.set(value);
	}
	public void runRight(double value) {
		rightIntake.set(value);
	}
}