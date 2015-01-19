package org.usfirst.frc.team4043.robot;

//package edu.wpi.first.wpilibj.templates;


/**-----------------------------------------------------------------------------
/* Copyright (c) FIRST 2008. All Rights Reserved.                             
/* Open Source Software - may be modified and shared by FRC teams. The code   
/* must be accompanied by the FIRST BSD license file in the root directory of 
/* the project.                                                               
/*----------------------------------------------------------------------------*/



//import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SampleRobot;
//import edu.wpi.first.wpilibj.Timer;
//import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends SampleRobot
{
    public Joystick drive_stick1 =  new Joystick(1);//joystick for the drivers to use allows for forward backward left right side side
   public Joystick drive_stick2 = new Joystick(2);

           
    public Victor wheel_l = new Victor(0);//
    public Victor wheel_r = new Victor(1);//     this set defines the ports to which the drive victors attach 
  
  
   // DigitalInput launcher_limit = new DigitalInput(1);
    
 //   public Timer launcher_timer = new Timer();
 //   public Timer wheel_timer = new Timer ();
    
    
    
    RobotDrive myRobot; //  initiates feedback to drivers station
    
    double[][] l_array = new double[10][2];
    double[][] r_array = new double[10][2];
    
    double direction1 = 0;
    double magnitude1 = 0;
     double direction2 = 0;
    double magnitude2 = 0;
    
    double wheel_l_speed = 0;
    double wheel_r_speed = 0;
    
    double wheel_l_offset = 0 ;
    double wheel_r_offset = 0;
    
    double wheel_l_currentval = 0;
    double wheel_l_oldval = 0;
   
    double wheel_r_currentval = 0;
    double wheel_r_oldval = 0;
    
    double old_time = 0;
    double change_in_time = 0;
    double current_time = 0;
    double wheel_l_actspeed;
    double wheel_r_actspeed;
   
    double number;
   
    int array_counter = 0;
    int autoLoopCounter = 0;
   
    boolean wheel_l_direction;
    boolean wheel_r_direction;
    
    
    
    /**
     * This function is called once each time the robot enters operator control.
     */
   
    
   
    
    public void drive()
    {
        
     {
            direction1 = drive_stick1.getDirectionRadians();
            magnitude1 = drive_stick1.getMagnitude();
            direction2 = drive_stick2.getDirectionRadians();
            magnitude2 = drive_stick2.getMagnitude();
           
            
            wheel_l_speed = (magnitude1 * Math.cos(direction1 + (Math.PI / 4.0)));
            wheel_r_speed = (magnitude2 * Math.sin(direction2 + (Math.PI / 4.0)));
            
            wheel_l.set(wheel_l_speed);
            wheel_r.set(wheel_r_speed);
            
            
            if (wheel_l_speed >= 0)
                wheel_l_direction = true;
            else
                wheel_l_direction = false;
            if (wheel_r_speed >= 0)
                wheel_r_direction = true;
            else
                wheel_r_direction = false;
            
            
     
    }  
    } 
    public void robotInit() {
    	 myRobot = new RobotDrive (0,1);
    	 drive_stick1 = new Joystick(1);
    	 drive_stick2 = new Joystick(2);
     }
     
     public void teleopInit(){
     }
     
     public void teleopPeriodic(){
    	 myRobot.tankDrive(drive_stick1, drive_stick2); 
     }
     
     public void testPeriodic() {
    	 LiveWindow.run();
     }
     
     public void autonomousPeriodic(){
    if  (autoLoopCounter < 50) {
    	myRobot.drive(-0.5, 0.0);
    	autoLoopCounter++;
    } else {
    	myRobot.drive(0.0, 0.0);
    }
     }
} 
