package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.Constants;

public class RoboCommands {
// The robots commands are defined here and then sent to robot container to bind buttons

     public static final Command setKrackenLowGoal = new InstantCommand(
        () -> RobotContainer.m_KrackenPositionSubsystem.setAbsolutePosition(Constants.KrackenConstants.kLowPosition), RobotContainer.m_KrackenPositionSubsystem);


}
