package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;
import static frc.robot.Constants.FuelConstants.*;

public class Intake extends Command {
  CANFuelSubsystem fuelSubsystem;

  public Intake(CANFuelSubsystem fuelSystem) {
    addRequirements(fuelSystem);
    this.fuelSubsystem = fuelSystem;
  }

  @Override
  public void initialize() {
    fuelSubsystem
        .setIntakeLauncherRoller(SmartDashboard.getNumber("Intaking intake roller value", INTAKING_INTAKE_VOLTAGE));
    fuelSubsystem.setFeederRoller(SmartDashboard.getNumber("Intaking feeder roller value", INTAKING_FEEDER_VOLTAGE));
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    fuelSubsystem.setIntakeLauncherRoller(0);
    fuelSubsystem.setFeederRoller(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
