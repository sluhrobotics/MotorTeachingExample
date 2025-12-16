package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

public class NeoSpeed {
    
    private final SparkMax m_rollingMotor = new SparkMax(1, MotorType.kBrushless);

    public NeoSpeed() {
        
    m_rollingMotor.setCANTimeout(300);

    SparkMaxConfig rollerConfig = new SparkMaxConfig();
    rollerConfig.voltageCompensation(10);
    rollerConfig.smartCurrentLimit(60);
    m_rollingMotor.configure(rollerConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void runRoller(double speed) {
        m_rollingMotor.set(speed);
    }
}

