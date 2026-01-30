package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import static frc.robot.Constants.OperatorConstants.*;
import frc.robot.commands.Drive;
import frc.robot.commands.Eject;
import frc.robot.commands.ExampleAuto;
import frc.robot.commands.Intake;
import frc.robot.commands.LaunchSequence;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class RobotContainer {
  private final CANDriveSubsystem driveSubsystem = new CANDriveSubsystem();
  private final CANFuelSubsystem fuelSubsystem = new CANFuelSubsystem();

  private final CommandXboxController driverController = new CommandXboxController(DRIVER_CONTROLLER_PORT);
  private final SendableChooser<Command> autoChooser = new SendableChooser<>();

  public RobotContainer() {
    configureBindings();
    autoChooser.setDefaultOption("Autonomous", new ExampleAuto(driveSubsystem, fuelSubsystem));
  }

  private void configureBindings() {
    driveSubsystem.setDefaultCommand(new Drive(driveSubsystem, driverController));
    fuelSubsystem.setDefaultCommand(fuelSubsystem.run(() -> fuelSubsystem.stop()));
    driverController.leftBumper().whileTrue(new Intake(fuelSubsystem));
    driverController.rightBumper().whileTrue(new LaunchSequence(fuelSubsystem));
    driverController.a().whileTrue(new Eject(fuelSubsystem));
  }

  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}