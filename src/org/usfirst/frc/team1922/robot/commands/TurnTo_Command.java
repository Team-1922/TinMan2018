package org.usfirst.frc.team1922.robot.commands;
import org.usfirst.frc.team1922.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnTo_Command extends Command{
    private double direction;
    private double start;
    private boolean isFinished = false;
    private boolean isLeft = false;
//    private double angle;
    
//    public TurnTo_Command(double angle) {
//        super();
//        requires(Robot.m_driveTrain);
//        direction = 1;
//        SmartDashboard.putString("Turn_Command", "Created");
//        this.angle = angle;
//    }
    
    public TurnTo_Command(double direction) {
        super();
        requires(Robot.m_driveTrain);
        this.direction = direction;
    }
    
    @Override
    protected void initialize() {
        start = Robot.m_driveTrain.getAngle();
        if( direction >= 0 ){
        	Robot.m_driveTrain.drive(.5,-.5);
        }else{ 
        	isLeft = true;
        	Robot.m_driveTrain.drive(-.5,.5);
        	
        }
        SmartDashboard.putString("Turn Direction", "" + direction);
        SmartDashboard.putString("Start Start", "" + start);
        
        SmartDashboard.putString("Turn_Command", "intialized");
    }
    
    @Override
    protected void execute() {
        //if(direction != -1);  
    	  if(isLeft == false){
            if(Robot.m_driveTrain.getAngle() <= start + direction) {
                SmartDashboard.putString("Turn_Command", "pass");
            }
            else {
                SmartDashboard.putString("Turn_Command", "fail");
                isFinished = true;
            }
    	  } else { //is turning left
    		  if(Robot.m_driveTrain.getAngle() >= start + direction) {
                  SmartDashboard.putString("Turn_Command", "pass left");
                  SmartDashboard.putString("Current Angle", "" + Robot.m_driveTrain.getAngle());
              }
              else {
                  SmartDashboard.putString("Turn_Command", "fail");
                  isFinished = true;
              }
    	  }
    }
    
    @Override protected void end() {
        Robot.m_driveTrain.stop();
    }
    
    @Override 
    protected void interrupted() {
        end();
    }
    
    @Override
    protected boolean isFinished() {
        return isFinished;
    }
    
}