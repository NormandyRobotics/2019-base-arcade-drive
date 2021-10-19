// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
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


  }

  public void driveWithJoysticks(Joystick driverJoystick, double speed)
  {
    speed = Constants.DRIVETRAIN_SPEED;
    driveMotors.arcadeDrive(driverJoystick.getY()*speed, driverJoystick.getX());
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

  public void stop(){
    leftMotors.stopMotor();
    rightMotors.stopMotor();
  }
}
