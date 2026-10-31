/* Copyright (c) 2021 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode.pedro.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleOp-test", group="OpMode")

public class TeleOpTest extends LinearOpMode {

    HwMap hwMap = new HwMap();

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() {
        hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
        hwMap.gateNectar.setPosition(hwMap.gateNectarOpenPos);
        hwMap.turretservo1.setPosition(hwMap.turretServo1DefaultPos);
        hwMap.turretservo2.setPosition(hwMap.turretServo2DefaultPos);
        hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBasePos);
        hwMap.HoodNectar.setPosition(hwMap.NectarHoodDefaultPose);
        hwMap.HoodPollen.setPosition(hwMap.PollenHoodDefaultPose);

        waitForStart();


        runtime.reset();
        while (opModeIsActive()) {


            //--------Intake------------


            if(gamepad2.right_trigger > 0.2){
                hwMap.intakeMain1.setPower(hwMap.intakePower);
                hwMap.intakeMain2.setPower(hwMap.intakePower);

            }
            else{
                hwMap.intakeMain1.setPower(hwMap.intakePowerZero);
                hwMap.intakeMain2.setPower(hwMap.intakePowerZero);
            }

            if(gamepad2.left_trigger > 0.2){
                hwMap.intakeMain1.setPower(hwMap.intakeSpitPower);
                hwMap.intakeMain2.setPower(hwMap.intakeSpitPower);
            }
            else{
                hwMap.intakeMain1.setPower(hwMap.intakePowerZero);
                hwMap.intakeMain2.setPower(hwMap.intakePowerZero);
            }



            //-------FlowerIntake------------

            if(gamepad2.right_bumper){
                hwMap.flowerIntake.setPosition(hwMap.flowerIntakeIntakingPos);
            }
            else{
                hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBasePos);
            }

            if(gamepad2.left_bumper){
                hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBlockingPos);
            }
            else{
                hwMap.flowerIntake.setPosition(hwMap.flowerIntakeBasePos);
            }


            //----------TurretServo----------

            if(gamepad2.dpad_down){
                hwMap.turretservo1.setPosition(hwMap.turretServo1DefaultPos);
                hwMap.turretservo2.setPosition(hwMap.turretServo2DefaultPos);
            }

            //--------ShooterPollen-------
            if(gamepad2.dpad_up){
                hwMap.PollenShooter.setVelocity(hwMap.PollenShooterTargetVelocity);
            }
            else{
                hwMap.PollenShooter.setVelocity(hwMap.PollenShooterbaseVelocity);
            }

            //---------NectarShooter------

            if(gamepad2.dpad_right){
                hwMap.NectarShooter.setVelocity(hwMap.NectarShooterTargetVelocity);
            }
            else{
                hwMap.NectarShooter.setVelocity(hwMap.NectarShooterbaseVelocity);
            }

            //-------------Gate----------

            if(gamepad2.x){
                hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
                hwMap.gateNectar.setPosition(hwMap.gateNectarOpenPos);
            }
            if(gamepad2.y){
                hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
                hwMap.gateNectar.setPosition(hwMap.gateNectarClosePos);
            }

            //-------------Hood-------------
            if(gamepad2.b){
                hwMap.HoodPollen.setPosition(hwMap.PollenHoodDefaultPose);
                hwMap.HoodNectar.setPosition(hwMap.NectarHoodDefaultPose);
            }

        }

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
