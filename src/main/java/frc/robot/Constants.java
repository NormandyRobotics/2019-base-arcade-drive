// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

	//Motor PWMs
	public static final int LEFT_FRONT_MOTOR = 0;
	public static final int LEFT_REAR_MOTOR = 2;
	public static final int RIGHT_FRONT_MOTOR = 1;
	public static final int RIGHT_REAR_MOTOR = 3;



	public static final double DRIVETRAIN_SPEED = 0.548; //sqrt(0.3)
	public static final double DRIVETRAIN_BOOST = 1;

	//Joystick buttons
	public static final int D_JOY1 = 11;
	public static final int D_JOY2 = 12;
	public static final int D_L2 = 7;
	public static final int D_R2 = 8;
	public static final int D_R1 = 6;
	public static final int D_L1 = 5;

	//joystick ports
	public static final int DRIVER_JOYSTICK = 0;
	public static final int DRIVER_JOYSTICK_LEFT_X_AXIS = 2;  //changed.  Are these now correct?
	public static final int DRIVER_JOYSTICK_LEFT_Y_AXIS = 3;
	public static final int DRIVER_JOYSTICK_RIGHT_X_AXIS = 0;
	public static final int DRIVER_JOYSTICK_RIGHT_Y_AXIS = 1;

	public static final int OPERATOR_JOYSTICK = 1;
	public static final int OPERATOR_JOYSTICK_LEFT_X_AXIS = 0;
	public static final int OPERATOR_JOYSTICK_LEFT_Y_AXIS = 1;
	public static final int OPERATOR_JOYSTICK_RIGHT_X_AXIS = 2;
	public static final int OPERATOR_JOYSTICK_RIGHT_Y_AXIS = 3;

		//CAN IDs
		public static final int PDP = 0;
		public static final int STRAFE_MOTOR = 3;


}
