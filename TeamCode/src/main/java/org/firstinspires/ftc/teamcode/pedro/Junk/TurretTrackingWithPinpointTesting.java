package org.firstinspires.ftc.teamcode.pedro.Junk;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

@TeleOp(name = "Turret Tracking", group = "TeleOp")
public class TurretTrackingWithPinpointTesting extends LinearOpMode {
    public GoBildaPinpointDriver pinpoint;

    public void initPinpoint(HardwareMap hwMap, Pose2D startingPose) {
        pinpoint = hwMap.get(GoBildaPinpointDriver.class, "pinpoint");

        pinpoint.setOffsets(
                -4.25,
                -7.5,
                DistanceUnit.INCH
        );

        pinpoint.setEncoderResolution(
                GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD
        );

        pinpoint.setEncoderDirections(
                GoBildaPinpointDriver.EncoderDirection.FORWARD,
                GoBildaPinpointDriver.EncoderDirection.FORWARD
        );

        pinpoint.recalibrateIMU();


        if (startingPose != null) {
            pinpoint.setPosition(startingPose);
        }
    }



    @Override
    public void runOpMode() {


        // Create the turret tracking controller
        TurretTrackingWithPinpoint tracker =
                new TurretTrackingWithPinpoint();

        // Set alliance:
        // true = Blue
        // false = Red
        boolean isBlue = true;

        // Initialize the hardware
        tracker.initTurret(hardwareMap);
        tracker.initPinpoint(hardwareMap, null);

        telemetry.addLine("Turret Tracking Initialized");
        telemetry.addData("Alliance", isBlue ? "Blue" : "Red");
        telemetry.addLine("Waiting for start...");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) {
            return;
        }

        // Continuously update turret position
        while (opModeIsActive()) {


            double targetPosition = tracker.autoAlign(isBlue);

            // Update Pinpoint and read heading for telemetry
            double robotHeading = tracker.getRobotHeading();

        }
        tracker.stop();
    }
}
