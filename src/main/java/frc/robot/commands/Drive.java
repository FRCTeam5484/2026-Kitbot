package frc.robot.commands;

import static frc.robot.Constants.OperatorConstants.*;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CANDriveSubsystem;

public class Drive extends Command {
  CANDriveSubsystem driveSubsystem;
  DoubleSupplier m_speed;
  DoubleSupplier m_turn;

  public Drive(CANDriveSubsystem driveSystem, DoubleSupplier speed, DoubleSupplier turn) {
    
    driveSubsystem = driveSystem;
    m_speed = speed;
    m_turn = turn;
    addRequirements(driveSystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    driveSubsystem.driveArcade(m_speed.getAsDouble() * DRIVE_SCALING, m_turn.getAsDouble() * ROTATION_SCALING);
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
