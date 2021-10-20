// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;

public class DriveWithJoysticks extends CommandBase {
  public final Drivetrain driveTrain;

  /** Creates a new DriveWithJoysticks. */
  public DriveWithJoysticks(Drivetrain dt) {
    driveTrain = dt;
    addRequirements(driveTrain);
   
  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    driveTrain.setMaxOutput(Constants.DRIVETRAIN_SPEED);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //double speed = Constants.DRIVETRAIN_SPEED;
    /*
  	if(RobotContainer.driverJoystick.getRawButton(Constants.D_JOY1) && RobotContainer.driverJoystick.getRawButton(Constants.D_JOY2))

     {
       speed = Constants.DRIVETRAIN_BOOST;
        
     }
     else
     {
      speed = Constants.DRIVETRAIN_SPEED;

      }
     */
    driveTrain.driveWithJoysticks(RobotContainer.driverJoystick);
      
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
