package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.mechanisms.AprilTagWebcam;
import org.firstinspires.ftc.teamcode.mechanisms.TurretMechanism;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;


public class TurretAutoAlignOpMode extends OpMode {

    private AprilTagWebcam webcam = new AprilTagWebcam();

    private TurretMechanism turret = new TurretMechanism();

    double[] stepSizes = {.1, 0.01, 0.001, 0.0001, 0.00001};

    int stepIndex = 2;

    @Override
    public void init(){
        webcam.init(hardwareMap, telemetry);
        turret.init(hardwareMap);

        telemetry.addLine("Initiated");


    }

    @Override
    public void start(){
        turret.resetTimer();
    }


    @Override
    public void loop(){
        webcam.update();
        AprilTagDetection id20 = webcam.getTagBySpecificId(20);
        turret.update(id20);

        // 'B' button cycles through the different step sizes for tuning precision.
        if (gamepad1.bWasPressed()) {
            stepIndex = (stepIndex + 1) % stepSizes.length; // Modulo wraps the index back to 0.
        }

        // D-pad left/right adjusts the P gain.
        if (gamepad1.dpadLeftWasPressed()) {
            turret.setkP(turret.getkP() - stepSizes[stepIndex]);
        }
        if (gamepad1.dpadRightWasPressed()) {
            turret.setkP(turret.getkP() + stepSizes[stepIndex]);
        }

        // D-pad up/down adjusts the D gain.
        if (gamepad1.dpadUpWasPressed()) {
            turret.setkD(turret.getkD() + stepSizes[stepIndex]);
        }
        if (gamepad1.dpadDownWasPressed()) {
            turret.setkD(turret.getkD() - stepSizes[stepIndex]);
        }

        if (id20 != null) {
            telemetry.addData("cur ID", webcam);
        } else {
            telemetry.addLine("No tag detected, stopped turning mode");
        }
    }
}
