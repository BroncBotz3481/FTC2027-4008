package org.firstinspires.ftc.teamcode.pedro.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp (name="Servo Test", group="TeleOp")

public class Five_TurnServoTestBoreEncoder extends OpMode {

    // Declare OpMode members for each of the 4 motors.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotorSimple Turret= null;
    private double CyclesPerRev = 2048;
    private double curEncodervalue= 0;





    @Override
    public void init() {


        Turret = hardwareMap.get(DcMotorSimple.class, "turret");
        Turret.setDirection(DcMotorSimple.Direction.REVERSE);


        runtime.reset();





        }


        @Override
        public void loop(){

        if(gamepad1.a){
            Turret.setPower(0.7);
        }

        else{
            Turret.setPower(0);
        }
        if(gamepad1.b){
            Turret.setPower(0.5);
        }
        else{
            Turret.setPower(0);
        }

        }





        }
