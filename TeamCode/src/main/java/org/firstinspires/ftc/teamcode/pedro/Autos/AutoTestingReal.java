
package org.firstinspires.ftc.teamcode.pedro.Autos;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedro.TeleOp.HwMap;

@Autonomous(name = "Time Auto REAL", group = "Autonomous")


public class AutoTestingReal extends LinearOpMode {






    HwMap hwMap = new HwMap();
    @Override
    public void runOpMode() {
        hwMap.Map(hardwareMap);
        telemetry.update();

        waitForStart();


        if (isStopRequested()) return;
        hwMap.flowerIntake.setPosition(hwMap.flowerIntakeInspectionPos);

        hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBasePos);
        hwMap.HoodPollen.setPosition(hwMap.PollenHoodDefaultPose);
        hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
      //  hwMap.gateNectar.setPosition(hwMap.gateNectarClosePos);
      //  hwMap.HoodNectar.setPosition(hwMap.NectarHoodIncrementPose);

/// TODO: REV UP SHOOTERS
        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);
        hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
       // hwMap.NectarShooter.setVelocity(hwMap.NectarShooterTargetVelocity);
        sleep (5000);
//TODO:INTAKE RUN + REV SHOOT
        hwMap.intakeMain1.setPower(hwMap.intakePower);
        hwMap.intakeMain2.setPower(hwMap.intakePower);

        hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
        hwMap.intakeMain1.setPower(hwMap.intakePower);
        hwMap.intakeMain2.setPower(hwMap.intakePower);
        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);

        sleep(2000);
        hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
        hwMap.intakeMain1.setPower(hwMap.intakePower);
        hwMap.intakeMain2.setPower(hwMap.intakePower);
        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);

        sleep(1000);
        hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
        hwMap.intakeMain1.setPower(hwMap.intakePower);
        hwMap.intakeMain2.setPower(hwMap.intakePower);
        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);

        sleep(2000);
        hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
        hwMap.intakeMain1.setPower(hwMap.intakePower);
        hwMap.intakeMain2.setPower(hwMap.intakePower);
        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);

        sleep(1000);
        hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
        hwMap.intakeMain1.setPower(hwMap.intakePower);
        hwMap.intakeMain2.setPower(hwMap.intakePower);
        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);

        sleep(2000);
        hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
        hwMap.intakeMain1.setPower(hwMap.intakePower);
        hwMap.intakeMain2.setPower(hwMap.intakePower);
        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);

        sleep(1000);

        hwMap.intakeMain1.setPower(hwMap.intakePower);
        hwMap.intakeMain2.setPower(hwMap.intakePower);
        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);

        sleep(2000);

        hwMap.PollenShooterLeft.setVelocity(hwMap.PollenShooterTargetVelocity);
      //  hwMap.NectarShooter.setVelocity(hwMap.NectarShooterTargetVelocity);


//TODO: FINISHED SHOOTING
        hwMap.intakeMain1.setPower(0);
        hwMap.intakeMain2.setPower(0);
        hwMap.PollenShooterLeft.setPower(0);
        hwMap.PollenShooterLeft.setPower(0);


        setDrivePower(-0.5, -0.5, -0.5, -0.5);
        sleep(1800);

        stopDrive();
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
