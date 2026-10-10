package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.mechanisms.AprilTagWebcam;
import org.firstinspires.ftc.teamcode.mechanisms.TurretMechanism;
import org.firstinspires.ftc.vision.apriltag.AprilTagClusterDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

@TeleOp(name = "Turret Auto Align")
public class TurretAutoAlignOpMode extends OpMode {

    private AprilTagWebcam webcam = new AprilTagWebcam();
    private TurretMechanism turret = new TurretMechanism();

    float[] stepSizes = {0.1f, 0.01f, 0.001f, 0.0001f, 0.00001f, 0.000001f, 0.0000001f, 0.00000001f};

    int stepIndex = 2;

    @Override
    public void init() {

        webcam.init(hardwareMap, telemetry);
        turret.init(hardwareMap);
        //hi

        telemetry.addLine("Initialized");
        telemetry.update();
    }

    @Override
    public void start() {
        turret.resetTimer();
    }

    @Override
    public void loop() {

        webcam.update();

        // Look specifically for the RED SCORING cluster
        AprilTagClusterDetection redScoring = webcam.getRedScoring();

        // The turret uses the cluster's bearing
        turret.update(redScoring);

        // 'B' button cycles through tuning step sizes
        if (gamepad1.bWasPressed()) {
            stepIndex = (stepIndex + 1) % stepSizes.length;
        }

        // D-pad left/right adjusts P
        if (gamepad1.dpadLeftWasPressed()) {
            turret.setkP(
                    turret.getkP() - stepSizes[stepIndex]
            );
        }

        if (gamepad1.dpadRightWasPressed()) {
            turret.setkP(
                    turret.getkP() + stepSizes[stepIndex]
            );
        }

        // D-pad up/down adjusts D
        if (gamepad1.dpadUpWasPressed()) {
            turret.setkD(
                    turret.getkD() + stepSizes[stepIndex]
            );
        }

        if (gamepad1.dpadDownWasPressed()) {
            turret.setkD(
                    turret.getkD() - stepSizes[stepIndex]
            );
        }

        // Telemetry
        telemetry.addData(
                "Total Detections",
                webcam.getDetectedTags().size()
        );

        if (redScoring != null) {

            telemetry.addLine("RED SCORING DETECTED");

            telemetry.addData(
                    "Bearing",
                    redScoring.ftcPose.bearing
            );

            telemetry.addData(
                    "Range",
                    redScoring.ftcPose.range
            );

            telemetry.addData(
                    "Yaw",
                    redScoring.ftcPose.yaw
            );

        } else {
            telemetry.addLine("RED SCORING NOT DETECTED");
        }

        telemetry.addData("kP", turret.getkP());
        telemetry.addData("kD", turret.getkD());
        telemetry.addData("Step Size", stepSizes[stepIndex]);
        telemetry.addData("Length", stepSizes.length);

        telemetry.update();
    }

    @Override
    public void stop() {
        webcam.stop();
    }
}