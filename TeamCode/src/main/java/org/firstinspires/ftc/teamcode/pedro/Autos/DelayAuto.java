
package org.firstinspires.ftc.teamcode.pedro.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedro.TeleOp.HwMap;

@Autonomous(name = "Delayed Auto", group = "Autonomous")

public class DelayAuto extends LinearOpMode {

    HwMap hwMap = new HwMap();

    // Adjustable timings
    private static final long DELAY_TIME = 10000;
    private static final long SHOOT_TIME = 10000;
    private static final long STRAFE_TIME = 4000;
    private static final long PARK_TIME = 6000;

    @Override
    public void runOpMode() {

        hwMap.Map(hardwareMap);

        telemetry.addLine("Delayed Time Auto Ready");
        telemetry.update();

        waitForStart();

        if (isStopRequested()) return;

        // STEP 1: Wait before shooting
        sleep(DELAY_TIME);

        // STEP 2: Run intake and shooters
        hwMap.intakeMain1.setPower(0.8);
        hwMap.intakeMain2.setPower(0.8);

        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);
        hwMap.PollenShooterRight.setVelocity(hwMap.NectarShooterTargetVelocity);

        sleep(SHOOT_TIME);

        // Stop intake and shooters
        hwMap.intakeMain1.setPower(0);
        hwMap.intakeMain2.setPower(0);

        hwMap.PollenShooterLeft.setPower(0);
        hwMap.PollenShooterRight.setPower(0);

        // STEP 3: Strafe RIGHT for 3 seconds
        setDrivePower(0.5, -0.5, -0.5, 0.5);
        sleep(STRAFE_TIME);

        stopDrive();

        // STEP 4: Drive straight to parking
        setDrivePower(0.5, 0.5, 0.5, 0.5);
        sleep(PARK_TIME);

        stopDrive();

        telemetry.addLine("Autonomous Complete");
        telemetry.update();
    }

    private void setDrivePower(double fl, double fr,
                               double bl, double br) {
        hwMap.DriveLeftFront.setPower(fl);
        hwMap.DriveRightFront.setPower(fr);
        hwMap.DriveLeftBack.setPower(bl);
        hwMap.DriveRightBack.setPower(br);
    }

    private void stopDrive() {
        setDrivePower(0, 0, 0, 0);
    }
}
