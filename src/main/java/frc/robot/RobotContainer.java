// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.KrackenPosition;
import frc.robot.subsystems.NeoSpeed;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.RoboCommands;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and buttons are defined here...
  public static ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public static NeoSpeed neo = new NeoSpeed();
  public static KrackenPosition kracken = new KrackenPosition();
  
  
  XboxController operatorXbox = new XboxController(1);
  
  
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
  new CommandXboxController(OperatorConstants.kDriverControllerPort);
  
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
    Trigger rollNeoButton = new Trigger(() -> operatorXbox.getRightTriggerAxis() > 0.9);//XboxControl..........Right Trigger
    JoystickButton krackenLowGoalButton = new JoystickButton(operatorXbox, 1);//XboxControl........A

    rollNeoButton.onTrue(RoboCommands.rollNeo);
    krackenLowGoalButton.onTrue(RoboCommands.setKrackenLowGoal);

    
  }
}
