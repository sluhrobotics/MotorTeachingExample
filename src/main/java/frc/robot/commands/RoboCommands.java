package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class RoboCommands {
// The robots commands are defined here and then sent to robot container to bind buttons
double something = Constants.KrackenConstants.kLowPosition;

        public static final Command setKrackenLowGoal = new InstantCommand(() -> Robot.kracken.setAbsolutePosition(Constants.KrackenConstants.kLowPosition));

        public static final Command rollNeo = new InstantCommand(() -> RobotContainer.kracken.setAbsolutePosition(Constants.KrackenConstants.kLowPosition));
}
