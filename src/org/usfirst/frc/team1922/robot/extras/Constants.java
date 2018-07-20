package org.usfirst.frc.team1922.robot.extras;

public class Constants {
	public static final int ELEVATOR_SCALE_HEIGHT = -27000;  //measured: 29700
	public static final int ELEVATOR_BOTTOM = -10000;
	public static final int ELEVATOR_SWITCH_HEIGHT = -9000; 
	public static final double BotLength = 3.25; 
	private double pulsesPerFoot;
//	pulsesPerFoot =  1300.0;
	
	public double getPulsesPerFoot(){
		return pulsesPerFoot;
	}
	public void setPPF(double PPFtemp){
		pulsesPerFoot = PPFtemp;
	}

}
