package org.usfirst.frc.team1922.robot.extras;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;

public class LimitSwitch extends Button{

	private DigitalInput m_switch;
	
	public LimitSwitch(int port) {
		m_switch = new DigitalInput(port);
	}
	
	@Override
	public boolean get() {
		return m_switch.get();
	}

}
