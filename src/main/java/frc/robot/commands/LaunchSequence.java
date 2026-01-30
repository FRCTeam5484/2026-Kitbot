package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants.FuelConstants;
import frc.robot.subsystems.CANFuelSubsystem;

public class LaunchSequence extends SequentialCommandGroup {
  public LaunchSequence(CANFuelSubsystem fuelSubsystem) {
    addCommands(
        new SpinUp(fuelSubsystem).withTimeout(FuelConstants.SPIN_UP_SECONDS),
        new Launch(fuelSubsystem));
  }
}
