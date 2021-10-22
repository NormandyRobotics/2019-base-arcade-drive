// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  PWMVictorSPX leftFrontMotor;
  PWMVictorSPX leftRearMotor;
  PWMVictorSPX rightFrontMotor;
  PWMVictorSPX rightRearMotor;

  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;

  DifferentialDrive driveMotors;

  VictorSPX strafeMotor; //test code for potential H-drive strafe motor
  
  
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftFrontMotor = new PWMVictorSPX(Constants.LEFT_FRONT_MOTOR);
    leftFrontMotor.setInverted(true);
    leftRearMotor = new PWMVictorSPX(Constants.LEFT_REAR_MOTOR);
    leftRearMotor.setInverted(true);
    rightFrontMotor = new PWMVictorSPX(Constants.RIGHT_FRONT_MOTOR);
    rightFrontMotor.setInverted(false);
    rightRearMotor = new PWMVictorSPX(Constants.RIGHT_REAR_MOTOR);
    rightRearMotor.setInverted(false);

    leftMotors = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
    rightMotors = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);

    driveMotors = new DifferentialDrive(leftMotors, rightMotors);

    strafeMotor = new VictorSPX(Constants.STRAFE_MOTOR);


  }

  public void driveWithJoysticks(XboxController driverJoystick, double speed)
  {
    if(driverJoystick.getRawButton(Constants.D_JOY1)) {
      speed = Constants.DRIVETRAIN_BOOST;
    } 
    else
    {
      speed = Constants.DRIVETRAIN_SPEED;
    }

    driveMotors.setDeadband(0.09);
    driveMotors.arcadeDrive(driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_Y_AXIS)*speed,driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_LEFT_X_AXIS));

    strafeMotor.set(ControlMode.PercentOutput, driverJoystick.getRawAxis(Constants.DRIVER_JOYSTICK_RIGHT_X_AXIS));

  }
  

  public void spinInPlaceLeft(){
    driveMotors.tankDrive(-1,1);
    
  }

  public void spinInPlaceRight(){
    driveMotors.tankDrive(1,-1);

  }

  public void rotateLeft(){
    driveMotors.tankDrive(0, 1);

  }

  public void rotateRight(){
    driveMotors.tankDrive(1,0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setMaxOutput(double maxOutput){
    driveMotors.setMaxOutput(maxOutput);
  }

  public void stop(){
    leftMotors.stopMotor();
    rightMotors.stopMotor();
  }
}
