package org.firstinspires.ftc.teamcode.pedro.TeleOp;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.ManualDrive;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedro.TuningStuff.Constants;

@TeleOp(group = "TeleOp :)")
@Disabled
public class TeleOp_V1 extends OpMode {

    HwMap hwMap = new HwMap();

    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init(){
        hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
        hwMap.gateNectar.setPosition(hwMap.gateNectarOpenPos);
        hwMap.turretservo1.setPosition(hwMap.turretServo1DefaultPos);
        hwMap.turretservo2.setPosition(hwMap.turretServo2DefaultPos);
        hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBasePos);
        hwMap.HoodNectar.setPosition(hwMap.NectarHoodDefaultPose);
        hwMap.HoodPollen.setPosition(hwMap.PollenHoodDefaultPose);

    }


    @Override
    public void loop(){


        //--------Intake------------


        if (gamepad2.right_trigger > 0.2) {
            hwMap.intakeMain1.setPower(hwMap.intakePower);
            hwMap.intakeMain2.setPower(hwMap.intakePower);

        } else {
            hwMap.intakeMain1.setPower(hwMap.intakePowerZero);
            hwMap.intakeMain2.setPower(hwMap.intakePowerZero);
        }

        if (gamepad2.left_trigger > 0.2) {
            hwMap.intakeMain1.setPower(hwMap.intakeSpitPower);
            hwMap.intakeMain2.setPower(hwMap.intakeSpitPower);
        } else {
            hwMap.intakeMain1.setPower(hwMap.intakePowerZero);
            hwMap.intakeMain2.setPower(hwMap.intakePowerZero);
        }


        //-------FlowerIntake------------

        if (gamepad2.right_bumper) {
            hwMap.flowerIntake.setPosition(hwMap.flowerIntakeIntakingPos);
        } else {
            hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBasePos);
        }

        if (gamepad2.left_bumper) {
            hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBlockingPos);
        } else {
            hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBasePos);
        }


        //----------TurretServo----------

        if (gamepad2.dpad_down) {
            hwMap.turretservo1.setPosition(hwMap.turretServo1DefaultPos);
            hwMap.turretservo2.setPosition(hwMap.turretServo2DefaultPos);
        }

        //--------ShooterPollen-------
        if (gamepad2.dpad_up) {
            hwMap.PollenShooter.setVelocity(hwMap.PollenShooterTargetVelocity);
        } else {
            hwMap.PollenShooter.setVelocity(hwMap.PollenShooterbaseVelocity);
        }

        //---------NectarShooter------

        if (gamepad2.dpad_right) {
            hwMap.NectarShooter.setVelocity(hwMap.NectarShooterTargetVelocity);
        } else {
            hwMap.NectarShooter.setVelocity(hwMap.NectarShooterbaseVelocity);
        }

        //-------------Gate----------

        if (gamepad2.x) {
            hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
            hwMap.gateNectar.setPosition(hwMap.gateNectarOpenPos);
        }
        if (gamepad2.y) {
            hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
            hwMap.gateNectar.setPosition(hwMap.gateNectarClosePos);
        }

        //-------------Hood-------------
        if (gamepad2.b) {
            hwMap.HoodPollen.setPosition(hwMap.PollenHoodDefaultPose);
            hwMap.HoodNectar.setPosition(hwMap.NectarHoodDefaultPose);
        }

    }










}