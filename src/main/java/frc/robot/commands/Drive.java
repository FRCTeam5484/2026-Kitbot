package frc.robot.commands;

import static frc.robot.Constants.OperatorConstants.*;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.CANDriveSubsystem;

public class Drive extends Command {
  CANDriveSubsystem driveSubsystem;
  CommandXboxController controller;

  public Drive(CANDriveSubsystem driveSystem, CommandXboxController driverController) {
    addRequirements(driveSystem);
    driveSubsystem = driveSystem;
    controller = driverController;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    driveSubsystem.driveArcade(-controller.getLeftY() * DRIVE_SCALING, -controller.getRightX() * ROTATION_SCALING);
  }

  @Override
  public void end(boolean interrupted) {
    driveSubsystem.driveArcade(0, 0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
