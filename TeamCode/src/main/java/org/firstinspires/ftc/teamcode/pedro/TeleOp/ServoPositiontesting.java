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

@TeleOp(name="ServoPostest", group="Linear OpMode")


public class ServoPositiontesting extends OpMode {


    HwMap hwMap = new HwMap();



    @Override
    public void init() {

    }

    @Override
    public void loop() {

        hwMap.Map(hardwareMap);

//        if(gamepad1.a) {
//            hwMap.flowerIntake.setPosition(0.65);
//        }
//        if(gamepad1.b){
//            hwMap.gatePollen.setPosition(0.15);
//
//        }
//        if(gamepad1.x){
//            hwMap.gatePollen.setPosition(0);
//        }

        if (gamepad1.a){
            hwMap.gatePollen.setPosition(0.1);
        }
        if(gamepad1.b){
            hwMap.gatePollen.setPosition(0.3);
        }

//        if (gamepad1.a){
//            hwMap.turretservo1.setPosition(0);
//            hwMap.turretservo2.setPosition(0);
//        }
//        if(gamepad1.b){
//            hwMap.turretservo1.setPosition(0.07);
//            hwMap.turretservo2.setPosition(0.07);
//        }
//        if(gamepad1.x){
//            hwMap.turretservo1.setPosition(0.08);
//            hwMap.turretservo2.setPosition(0.08);
//        }
//        if(gamepad1.y){
//            hwMap.turretservo1.setPosition(0.09);
//            hwMap.turretservo2.setPosition(0.09);
//
//
//        }
//        if(gamepad1.dpad_right){
//            hwMap.turretservo1.setPosition(0.1);
//            hwMap.turretservo2.setPosition(0.1);
//
//        }
//        if(gamepad1.dpad_up){
//            hwMap.turretservo1.setPosition(0.11);
//            hwMap.turretservo2.setPosition(0.11);
//        }
//        if(gamepad1.dpad_left){
//            hwMap.turretservo1.setPosition(0.12);
//            hwMap.turretservo2.setPosition(0.12);
//        }
//
//        if(gamepad1.dpad_down){
//            hwMap.turretservo1.setPosition(0.13);
//            hwMap.turretservo2.setPosition(0.13);
//        }
//
//
//        if (gamepad2.a){
//            hwMap.turretservo1.setPosition(0);
//            hwMap.turretservo2.setPosition(0);
//        }
//        if(gamepad2.b){
//            hwMap.turretservo1.setPosition(0.143);
//            hwMap.turretservo2.setPosition(0.143);
//        }
//        if(gamepad2.x){
//            hwMap.turretservo1.setPosition(0.15);
//            hwMap.turretservo2.setPosition(0.15);
//        }
//        if(gamepad2.y){
//            hwMap.turretservo1.setPosition(0.16);
//            hwMap.turretservo2.setPosition(0.16);
//
//
//        }
//        if(gamepad2.dpad_right){
//            hwMap.turretservo1.setPosition(0.04);
//            hwMap.turretservo2.setPosition(0.04);
//
//        }
//        if(gamepad2.dpad_left){
//            hwMap.turretservo1.setPosition(0.05);
//            hwMap.turretservo2.setPosition(0.05);
//        }
//        if(gamepad2.dpad_left){
//            hwMap.turretservo1.setPosition(0.06);
//            hwMap.turretservo2.setPosition(0.06);
//        }




        if(gamepad2.dpad_up){
            hwMap.gateNectar.setPosition(0);
        }
        if(gamepad2.dpad_down){
            hwMap.gateNectar.setPosition(0.01);
        }
        if(gamepad2.dpad_left){
            hwMap.gateNectar.setPosition(0.02);
        }
        if(gamepad2.dpad_right){
            hwMap.gateNectar.setPosition(0.03);
        }

//        if(gamepad1.a){
//            hwMap.flowerIntake.setPosition(0);
//        }
//        if(gamepad1.b){
//            hwMap.flowerIntake.setPosition(0.1);
//        }
//        if(gamepad1.x){
//            hwMap.flowerIntake.setPosition(0.20);
//        }
//        if(gamepad1.y){
//            hwMap.flowerIntake.setPosition(0.30);
//        }
//        if(gamepad1.dpad_right){
//            hwMap.flowerIntake.setPosition(0.55);
//        }
//        if(gamepad1.dpad_left){
//            hwMap.flowerIntake.setPosition(0.61);
//        }






//        if(gamepad1.dpad_up){
//            //.67 is the default pose
//            hwMap.HoodPollen.setPosition(0.67);
//        }

//        if(gamepad1.dpad_down){
//            hwMap.HoodNectar.setPosition(0.4);
//
//        }
//        if(gamepad1.dpad_right){
//            hwMap.HoodNectar.setPosition(0.7);
//        }
//        if(gamepad1.dpad_left){
//            //0.5 is thecorrect
//            hwMap.HoodNectar.setPosition(0.5);
//        }
//        if(gamepad1.dpad_right){
//            hwMap.turretservo1.setPosition(0.218);
//            hwMap.turretservo2.setPosition(0.218);
//        }
//
//        if(gamepad1.dpad_left){
//            hwMap.turretservo1.setPosition(0.108);
//            hwMap.turretservo2.setPosition(0.108);
//        }
//
//        if(gamepad1.dpad_down){
//            hwMap.turretservo1.setPosition(0.163);
//            hwMap.turretservo2.setPosition(0.163);
//        }

//        if(gamepad1.dpad_right){
//            hwMap.turretservo1.setPosition(-0.05);
//            hwMap.turretservo2.setPosition(-0.05);
//        }




    }


}


