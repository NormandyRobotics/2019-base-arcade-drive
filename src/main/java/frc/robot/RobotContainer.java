// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.DriveWithJoysticks;
import frc.robot.commands.RotateLeft;
import frc.robot.commands.RotateRight;
import frc.robot.commands.SpeedBoost;
import frc.robot.commands.SpinInPlaceLeft;
import frc.robot.commands.SpinInPlaceRight;
import frc.robot.subsystems.Drivetrain;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Declare Drivetrain
  private final Drivetrain driveTrain;
  private final DriveWithJoysticks driveWithJoysticks;


  //initialize joysticks
  public static XboxController driverJoystick;
  public static XboxController operatorJoystick;

  //Sendable chooser declare
  SendableChooser<Command> chooser = new SendableChooser<>();


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // initialize drive values
    driveTrain = new Drivetrain();
    driveWithJoysticks = new DriveWithJoysticks(driveTrain);
    driveWithJoysticks.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithJoysticks);  //set default command

    // initialize joystick values
    driverJoystick = new XboxController(Constants.DRIVER_JOYSTICK);
    operatorJoystick = new XboxController(Constants.OPERATOR_JOYSTICK);


    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    //create some buttons
    //final JoystickButton d_dpadUp = new JoystickButton(driverJoystick, Constants.D_DPAD_UP);
    //final JoystickButton d_dpadRight = new JoystickButton(driverJoystick, Constants.D_DPAD_RIGHT);
    //final JoystickButton d_dpadDown = new JoystickButton(driverJoystick, Constants.D_DPAD_DOWN);
    //final JoystickButton d_dpadLeft = new JoystickButton(driverJoystick, Constants.D_DPAD_LEFT);
    final JoystickButton d_l2 = new JoystickButton(driverJoystick, Constants.D_L2);
    final JoystickButton d_r2 = new JoystickButton(driverJoystick, Constants.D_R2);
    final JoystickButton d_l1 = new JoystickButton(driverJoystick, Constants.D_L1);
    final JoystickButton d_r1 = new JoystickButton(driverJoystick, Constants.D_R1);
    final JoystickButton d_joy1 = new JoystickButton(driverJoystick, Constants.D_JOY1);
    //final JoystickButton d_joy2 = new JoystickButton(driverJoystick, Constants.D_JOY2);
    //final JoystickButton d_midLeft = new JoystickButton(driverJoystick, Constants.D_MIDLEFT);
    //final JoystickButton d_midRight = new JoystickButton(driverJoystick, Constants.D_MIDRIGHT);


    //final JoystickButton o_dpadUp = new JoystickButton(operatorJoystick, Constants.O_DPAD_UP);
    //final JoystickButton o_dpadRight = new JoystickButton(operatorJoystick, Constants.O_DPAD_RIGHT);
    //final JoystickButton o_dpadDown = new JoystickButton(operatorJoystick, Constants.O_DPAD_DOWN);
    //final JoystickButton o_dpadLeft = new JoystickButton(operatorJoystick, Constants.O_DPAD_LEFT);
    //final JoystickButton o_l2 = new JoystickButton(operatorJoystick, Constants.O_L2);
    //final JoystickButton o_r2 = new JoystickButton(operatorJoystick, Constants.O_R2);
    //final JoystickButton o_l1 = new JoystickButton(operatorJoystick, Constants.O_L1);
    //final JoystickButton o_r1 = new JoystickButton(operatorJoystick, Constants.O_R1);
    //final JoystickButton o_joy1 = new JoystickButton(operatorJoystick, Constants.O_JOY1);
    //final JoystickButton o_joy2 = new JoystickButton(operatorJoystick, Constants.O_JOY2);
    //final JoystickButton o_midLeft = new JoystickButton(driverJoystick, Constants.O_MIDLEFT);
    //final JoystickButton o_midRight = new JoystickButton(driverJoystick, Constants.O_MIDRIGHT);

    //Speed boost when left joystick button held
    d_joy1.whenPressed(new SpeedBoost(driveTrain));

    //Spin in place to the left when top left trigger pressed
    d_l1.whenHeld(new SpinInPlaceLeft(driveTrain));

    //Spin in place to the right when top right trigger pressed
    d_r1.whenHeld(new SpinInPlaceRight(driveTrain));

    //Rotate left when bottom left trigger pressed
    d_l2.whenHeld(new RotateLeft(driveTrain));

    //Rotate right when bottom right trigger pressed
    d_r2.whenHeld(new RotateRight(driveTrain));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */


  public Command getAutonomousCommand() {
    return chooser.getSelected();
  }

}
