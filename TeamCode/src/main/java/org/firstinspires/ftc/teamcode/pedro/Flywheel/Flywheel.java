package org.firstinspires.ftc.teamcode.pedro.Flywheel;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;




public class Flywheel  {


    private DcMotorEx PollenShooter, NectarShooter;


    private double encoderCPM = 28;


    private double gearRatio = 1;


    private double kV = 0.000176, kS = 0.17, kP = 0.001050;

    public void init(HardwareMap hwMap) {
        //  PollenShooter = hwMap.get(DcMotorEx.class,"PollenShooter");
        NectarShooter = hwMap.get(DcMotorEx.class, "NectarShooter");

        //  PollenShooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        NectarShooter.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // PollenShooter.setDirection(DcMotor.Direction.FORWARD);
        NectarShooter.setDirection(DcMotor.Direction.FORWARD);


    }



    public void setMotorPower(double power) {
        // PollenShooter.setPower(power);
        NectarShooter.setPower(power);

    }

    public void stopMotors() {
        NectarShooter.setPower(0);
    }

    public void setmotorRpm(double targetRpm) {
        double error = targetRpm - getRPM();
        double ff = (kV * targetRpm) + kS;
        double fb = error * kP;
        double power = ff + fb;
        setMotorPower(power);


    }



    public double getTicksPerSec() {
        return NectarShooter.getVelocity();
    }

    public double getRPM() {
        return ((getTicksPerSec() / encoderCPM) * 60) / gearRatio;

    }



}

