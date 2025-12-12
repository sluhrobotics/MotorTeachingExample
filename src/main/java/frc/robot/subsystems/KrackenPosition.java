package frc.robot.subsystems;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class KrackenPosition {
    private final TalonFX m_posMotorFx = new TalonFX(0);

    private final PositionVoltage m_posVoltage = new PositionVoltage(0);

    private double motorRotations = 0;

    public KrackenPosition() {
        m_posMotorFx.getConfigurator().apply(new TalonFXConfiguration());

        /* Create and apply configuation for angle motor 
        ****** Still need to set PID values ******
        */
        TalonFXConfiguration m_posMotorConfig = new TalonFXConfiguration();
        m_posMotorConfig.Slot0.kP = 0; // An erro of 1 rotation results in a 0 V output
        m_posMotorConfig.Slot0.kI = 0; // No output for integrate error
        m_posMotorConfig.Slot0.kD = 0; // A velocity of 1 rotation results in a 0 V output
        // Peak output of 8 V
        m_posMotorConfig.Voltage.withPeakForwardVoltage(Volts.of(8))
        .withPeakReverseVoltage(Volts.of(-8));
        m_posMotorFx.setNeutralMode(NeutralModeValue.Brake);

        /* Retry config apply up to 5 times, report if failure */
        StatusCode status = StatusCode.StatusCodeNotInitialized;
        for (int i = 0; i < 5; ++i) {
        status = m_posMotorFx.getConfigurator().apply(m_posMotorConfig);
        if (status.isOK()) break;
        }
        if (!status.isOK()) {
            System.out.println("Could not apply configs to DeepClimb motor ONE, error code: " + status.toString());
        }

        /* Make sure we start at 0 */
        m_posMotorFx.setPosition(0);
    }   

    public void setPositionInterval(double positionInterval) {

        motorRotations += positionInterval;
        // ADD SOFT STOP FOR SAFETY

        m_posMotorFx.setControl(m_posVoltage.withPosition(motorRotations));
    }

    public void setAbsolutePosition(double absoluteRotations) {
        
        // ADD SOFT STOP FOR SAFETY
        m_posMotorFx.setControl(m_posVoltage.withPosition(absoluteRotations));
    }
}
