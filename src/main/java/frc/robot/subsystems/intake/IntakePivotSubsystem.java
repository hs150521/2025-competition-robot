package frc.robot.subsystems.intake;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.function.Supplier;
import org.littletonrobotics.junction.Logger;

public class IntakePivotSubsystem extends SubsystemBase {
    private IntakePivotIO io;
    private IntakePivotIOInputsAutoLogged inputs = new IntakePivotIOInputsAutoLogged();

    public IntakePivotSubsystem(IntakePivotIO io) {
        this.io = io;
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.processInputs("Intake/Pivot", inputs);
    }

    public Command setTargetAngle(Rotation2d target) {
        return setTargetAngle(() -> target);
    }

    public Command setTargetAngle(Supplier<Rotation2d> target) {
        return this.runOnce(() -> Logger.recordOutput("Intake/PivotSetpoint", target.get()))
                .andThen(this.run(() -> io.setMotorPosition(target.get())));
    }
}