package org.firstinspires.ftc.teamcode.pedro.Turret;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;




public class Turret  {


    private CRServo turretservo1, turretservo2;
    private DcMotorEx intakeMainLeft;


    private double encoderCPM = 8192;


    private double gearRatio = 1.25;


    private double kD = 0, kI = 0, kP = 0;

    public void init(HardwareMap hwMap) {

        intakeMainLeft = hwMap.get(DcMotorEx.class,"intakeMainLeft");
        intakeMainLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        turretservo1.setDirection(CRServo.Direction.FORWARD);
        turretservo2.setDirection(CRServo.Direction.FORWARD);


    }



    public void setServoPower(double power) {
        turretservo1.setPower(power);
        turretservo2.setPower(power);


    }

    public void stopServo() {
        turretservo1.setPower(0);
        turretservo2.setPower(0);
    }



    public double getTicksPerSec() {
        return intakeMainLeft.getCurrentPosition();
    }

    public double getRPM() {
        return ((getTicksPerSec() / encoderCPM) * 60) / gearRatio;

    }



}

