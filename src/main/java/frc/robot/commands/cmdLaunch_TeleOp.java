package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.hal.can.CANExceptionFactory;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANFuelSubsystem;

public class cmdLaunch_TeleOp extends Command {
  CANFuelSubsystem m_fuel;
  DoubleSupplier m_feeder;
  DoubleSupplier m_shooter;
  public cmdLaunch_TeleOp(CANFuelSubsystem fuel, DoubleSupplier feeder, DoubleSupplier shooter) {
    m_feeder = feeder;
    m_shooter = shooter;
    m_fuel = fuel;
    addRequirements(m_fuel);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    m_fuel.setIntakeLauncherRoller(m_shooter.getAsDouble() * 12);
    m_fuel.setFeederRoller(m_feeder.getAsDouble() * 12);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_fuel.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
