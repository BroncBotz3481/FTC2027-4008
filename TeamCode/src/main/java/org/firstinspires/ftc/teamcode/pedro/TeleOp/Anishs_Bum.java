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

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/*
 * This file contains an example of a Linear "OpMode".
 * An OpMode is a 'program' that runs in either the autonomous or the teleop period of an FTC match.
 * The names of OpModes appear on the menu of the FTC Driver Station.
 * When a selection is made from the menu, the corresponding OpMode is executed.
 *
 * This particular OpMode illustrates driving a 4-motor Omni-Directional (or Holonomic) robot.
 * This code will work with either a Mecanum-Drive or an X-Drive train.
 * Both of these drives are illustrated at https://gm0.org/en/latest/docs/robot-design/drivetrains/holonomic.html
 * Note that a Mecanum drive must display an X roller-pattern when viewed from above.
 *
 * Also note that it is critical to set the correct rotation direction for each motor.  See details below.
 *
 * Holonomic drives provide the ability for the robot to move in three axes (directions) simultaneously.
 * Each motion axis is controlled by one Joystick axis.
 *
 * 1) Axial:    Driving forward and backward               Left-joystick Forward/Backward
 * 2) Lateral:  Strafing right and left                     Left-joystick Right and Left
 * 3) Yaw:      Rotating Clockwise and counter clockwise    Right-joystick Right and Left
 *
 * This code is written assuming that the right-side motors need to be reversed for the robot to drive forward.
 * When you first test your robot, if it moves backward when you push the left stick forward, then you must flip
 * the direction of all 4 motors (see code below).
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this OpMode to the Driver Station OpMode list
 */

@TeleOp(name="Anish's Bum", group="Linear OpMode")

public class Anishs_Bum extends OpMode {


    HardwareMap2027Team4008 hwMap = new HardwareMap2027Team4008();


    @Override
    public void init() {
        telemetry.addLine("From his earliest days, Anish" +
                " possessed a highly sensitive temperament. Where other toddlers might boldly crash into new environments, Anish observed first." +
                " Psychologists note that some children are born with a more finely tuned nervous system, " +
                "making them highly perceptive to loud noises, tense emotions, and physical discomfort." +
                " For Anish, a aggressive shove on the soccer field or a harsh word from a peer isn't just a minor annoyance—it registers as a profound shock to his system." +
                " He is not tough simply because his biology predisposes him to seek harmony and safety over conflict and dominance."
        );
    }

    @Override
    public void loop() {

        if(gamepad1.a) {
            hwMap.intakeMain1.setPower(0.7);
        }
        else if(gamepad1.dpad_up) {
            hwMap.DriveLeftBack.setPower(0.7);
            hwMap.DriveRightBack.setPower(0.7);
            hwMap.DriveLeftFront.setPower(0.7);
            hwMap.DriveRightFront.setPower(0.7);
        } else if(gamepad1.dpad_down) {
            hwMap.DriveLeftBack.setPower(0.7);
            hwMap.DriveRightBack.setPower(0.7);
            hwMap.DriveLeftFront.setPower(0.7);
            hwMap.DriveRightFront.setPower(0.7);
        } else if(gamepad1.dpad_left) {
            hwMap.DriveLeftBack.setPower(0.7);
            hwMap.DriveRightBack.setPower(-0.7);
            hwMap.DriveLeftFront.setPower(0.7);
            hwMap.DriveRightFront.setPower(-0.7);
        } else if(gamepad1.dpad_right) {
            hwMap.DriveLeftBack.setPower(-0.7);
            hwMap.DriveRightBack.setPower(0.7);
            hwMap.DriveLeftFront.setPower(-0.7);
            hwMap.DriveRightFront.setPower(0.7);
        } else if (gamepad1.left_trigger_pressed){
            //need to add code
        }
    }
}

