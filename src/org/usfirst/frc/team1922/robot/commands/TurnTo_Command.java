package org.usfirst.frc.team1922.robot.commands;
import org.usfirst.frc.team1922.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnTo_Command extends Command{
    private int direction;
    private double start;
    private boolean isFinished = false;
    private double angle;
    public TurnTo_Command(double angle) {
        super();
        requires(Robot.m_driveTrain);
        direction = 1;
        SmartDashboard.putString("Turn_Command", "Created");
        this.angle = angle;
    }
    
    public TurnTo_Command(int direction) {
        super();
        requires(Robot.m_driveTrain);
        this.direction = direction;
    }
    
    @Override
    protected void initialize() {
        start = Robot.m_driveTrain.getAngle();
        Robot.m_driveTrain.drive(direction*(.2), -direction*(.2));
        SmartDashboard.putString("Turn_Command", "intialized");
    }
    
    @Override
    protected void execute() {
        //if(direction != -1);  
            if(Robot.m_driveTrain.getAngle() <= start + angle) {
                SmartDashboard.putString("Turn_Command", "pass");
            }
            else {
                SmartDashboard.putString("Turn_Command", "fail");
                isFinished = true;
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