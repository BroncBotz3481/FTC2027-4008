package org.firstinspires.ftc.teamcode.pedro.Turret;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name="Tsundere_Test", group="OpMode")

public class BoreBoyTest extends OpMode {


    public DcMotorEx tsundere;
    public CRServo bankai;
//public double currentPose;

    public double Target = 1500;

    public double calculatedAngle = 0;

    @Override
    public void init(){
        tsundere = hardwareMap.get(DcMotorEx.class,"dummy");
        bankai = hardwareMap.get(CRServo.class,"bankai");
        tsundere.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        tsundere.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        tsundere.setDirection(CRServo.Direction.REVERSE);
    }


    @Override
    public void loop(){

        double currentPose = tsundere.getCurrentPosition();

        if(gamepad1.a && currentPose < 1500) {
            bankai.setPower(0.5);

        }
        else {
            bankai.setPower(0);
        }
        telemetry.addData("Current Position ","%.2f V",currentPose);


    }
}
