package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.CANDriveSubsystem;
import frc.robot.subsystems.CANFuelSubsystem;

public class ExampleAuto extends SequentialCommandGroup {
  public ExampleAuto(CANDriveSubsystem driveSubsystem, CANFuelSubsystem ballSubsystem) {
    addCommands(
    new AutoDrive(driveSubsystem,0.5,  0.0).withTimeout(.25),
    new Launch(ballSubsystem).withTimeout(10));
  }
}
