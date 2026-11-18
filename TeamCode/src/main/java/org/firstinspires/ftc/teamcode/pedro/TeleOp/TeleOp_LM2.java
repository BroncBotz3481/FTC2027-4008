package org.firstinspires.ftc.teamcode.pedro.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(group = "TeleOp")


public class TeleOp_LM2 extends OpMode {

    HwMap hwMap = new HwMap();

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor NectarShooter = null;

    @Override
    public void init() {
        hwMap.Map(hardwareMap);


//        hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
//        hwMap.gateNectar.setPosition(hwMap.gateNectarOpenPos);
//        hwMap.turretservo1.setPosition(hwMap.turretServo1InspectionPos);
//        hwMap.turretservo2.setPosition(hwMap.turretServo2InspectionPos);
//        hwMap.flowerIntake.setPosition(hwMap.flowerIntakeInspectionPos);
////        hwMap.HoodNectar.setPosition(hwMap.NectarHoodDefaultPose);
////        hwMap.HoodPollen.setPosition(hwMap.PollenHoodDefaultPose);
//        NectarShooter = hardwareMap.get(DcMotorEx.class, "NectarShooter");
//        hwMap.HoodPollen.setPosition(hwMap.PollenHoodIncrementPose);
//        hwMap.HoodNectar.setPosition(hwMap.NectarHoodIncrementPose);

    }


    @Override
    public void loop() {
        //--------Intake------------


        if (gamepad1.right_trigger > 0.2) {
            hwMap.intakeMain1.setPower(hwMap.intakePower);
            hwMap.intakeMain2.setPower(hwMap.intakePower);

        }
        else if (gamepad1.left_trigger > 0.2) {
            hwMap.intakeMain1.setPower(hwMap.intakeSpitPower);
            hwMap.intakeMain2.setPower(hwMap.intakeSpitPower);
        }

        else {
            hwMap.intakeMain1.setPower(hwMap.intakePowerZero);
            hwMap.intakeMain2.setPower(hwMap.intakePowerZero);
        }

        if (gamepad1.right_bumper) {
            hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
        }
        if(gamepad1.left_bumper){
            hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
        }


        //-------FlowerIntake------------

//        if (gamepad2.right_bumper) {
//            hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBasePos);
//        } else {
//            hwMap.flowerIntake.setPosition(hwMap.flowerIntakeIntakingPos);
//        }





        //----------TurretServo----------

//        if (gamepad1.left_bumper) {
//            hwMap.turretservo1.setPosition(hwMap.turretServo1DefaultPos);
//            hwMap.turretservo2.setPosition(hwMap.turretServo2DefaultPos);
//
//        }
//        if(gamepad1.right_bumper){
//            hwMap.turretservo1.setPosition(hwMap.turretServo1InspectionPos);
//            hwMap.turretservo2.setPosition(hwMap.turretServo2InspectionPos);
//        }
        //-------------Gate----------

//        if (gamepad2.left_bumper) {
//            hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
//        }
//        else if (gamepad2.right_bumper) {
//            hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
//        }





        //----------Shooter----------
        if (gamepad1.b){
            hwMap.PollenShooterRight.setVelocity(hwMap.PollenShooterTargetVelocity);
        }
        else{
            hwMap.PollenShooterRight.setVelocity(0);
        }

        double curVelocityPollen = hwMap.PollenShooterLeft.getVelocity();

        telemetry.addData("Current Vel", "%.2f", curVelocityPollen);


        double max;

        double axial   = -gamepad1.left_stick_y;
        double lateral =  gamepad1.left_stick_x;
        double yaw     =  gamepad1.right_stick_x;

        double frontLeftPower  = axial + lateral + yaw;
        double frontRightPower = axial - lateral - yaw;
        double backLeftPower   = axial - lateral + yaw;
        double backRightPower  = axial + lateral - yaw;

        max = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        max = Math.max(max, Math.abs(backLeftPower));
        max = Math.max(max, Math.abs(backRightPower));

        if (max > 1.0) {
            frontLeftPower  /= max;
            frontRightPower /= max;
            backLeftPower   /= max;
            backRightPower  /= max;
        }

        hwMap.DriveLeftFront.setPower(frontLeftPower);
        hwMap.DriveRightFront.setPower(frontRightPower);
        hwMap.DriveLeftBack.setPower(backLeftPower);
        hwMap.DriveRightBack.setPower(backRightPower);



    }


}