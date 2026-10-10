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


@TeleOp(name="Basic: Omni Linear OpMode", group="Linear OpMode")

public class Shooter_testv1base extends LinearOpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor S1,S2 = null;

    @Override
    public void runOpMode() {

        S1 = hardwareMap.get(DcMotor.class, "S1");
        S2= hardwareMap.get(DcMotor.class,"S2");
        S1.setDirection(DcMotor.Direction.REVERSE);
        S2.setDirection(DcMotor.Direction.REVERSE);


        // Wait for the game to start (driver presses START)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            if (gamepad1.b) {
                S1.setPower(1);
                S2.setPower(1);
            }
            else {
                S1.setPower(0);
                S2.setPower(0);
            }

            if (gamepad1.a) {
                S1.setPower(0.9);
                S2.setPower(0.9);
            }
            else {
                S1.setPower(0);
                S2.setPower(0);
            }

            if (gamepad1.x) {
                S1.setPower(0.8);
                S2.setPower(0.8);
            }
            else {
                S1.setPower(0);
                S2.setPower(0);
            }

            if (gamepad1.y) {
                S1.setPower(0.7);
                S2.setPower(0.7);
            }
            else {
                S1.setPower(0);
                S2.setPower(0);
            }

            if (gamepad1.dpad_up) {
                S1.setPower(0.6);
                S2.setPower(0.6);
            }
            else {
                S1.setPower(0);
                S2.setPower(0);
            }

            if (gamepad1.dpad_left) {
                S1.setPower(0.5);
                S2.setPower(0.5);
            }
            else {
                S1.setPower(0);
                S2.setPower(0);
            }




            if(gamepad2.a){
                S1.setPower(1);
                S2.setPower(0.9);
            }
            else if(gamepad2.b){
                S1.setPower(1);
                S2.setPower(0.8);

            }else if(gamepad2.x){
                S1.setPower(1);
                S2.setPower(0.7);

            }else if(gamepad2.y){
                S1.setPower(1);
                S2.setPower(0.6);
            }









        }
    }
}
