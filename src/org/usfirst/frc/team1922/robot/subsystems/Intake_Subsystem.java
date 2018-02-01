package org.usfirst.frc.team1922.robot.subsystems;

import org.usfirst.frc.team1922.robot.RobotMap;
import org.usfirst.frc.team1922.robot.commands.OperateIntake_Command;
import org.usfirst.frc.team1922.robot.commands.TankDrive_Command;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake_Subsystem extends Subsystem{

	private WPI_TalonSRX leftIntake = new WPI_TalonSRX(RobotMap.INTAKELEFT);
	private WPI_TalonSRX rightIntake = new WPI_TalonSRX(RobotMap.INTAKERIGHT);

	
	public Intake_Subsystem()
	{
		super();
		SmartDashboard.putString("Intake Subsytem", "Created");
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new OperateIntake_Command());
	}
	
	public void run(Joystick operator) {
		SmartDashboard.putString("Intake Subsystem", "Running");
		leftIntake.set(operator.getY());
		rightIntake.set(operator.getY());

	}

	public void stop() {
		rightIntake.set(0);
		leftIntake.set(0);
	}
}
