package org.firstinspires.ftc.teamcode.pedro.myFirstTeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class TeleOpTest extends OpMode {

    private DcMotorEx America = null;   //Goes in hardware map
    @Override public void init(){
        America = hardwareMap.get(DcMotorEx.class, "a"); //Goes in hardware map
        America.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER); //Goes in hardware map
        America.setTargetPosition(0);
}
    @Override public void loop(){
        if (gamepad1.aWasPressed()) {
            America.setPower(0.76);
        } else {
            America.setPower(0);
        }
    }
// Hi




}
