package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;
import static frc.robot.Constants.FuelConstants.*;

public class SpinUp extends Command {
  CANFuelSubsystem fuelSubsystem;

  public SpinUp(CANFuelSubsystem fuelSystem) {
    addRequirements(fuelSystem);
    this.fuelSubsystem = fuelSystem;
  }

  @Override
  public void initialize() {
    fuelSubsystem
        .setIntakeLauncherRoller(
            SmartDashboard.getNumber("Launching launcher roller value", LAUNCHING_LAUNCHER_VOLTAGE));
    fuelSubsystem.setFeederRoller(SmartDashboard.getNumber("Launching spin-up feeder value", SPIN_UP_FEEDER_VOLTAGE));
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
