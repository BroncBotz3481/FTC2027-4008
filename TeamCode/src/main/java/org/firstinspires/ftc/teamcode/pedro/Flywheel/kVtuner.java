package org.firstinspires.ftc.teamcode.pedro.Flywheel;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class kVtuner extends OpMode {
    Flywheel flywheel = new Flywheel();

    public double kS = 0.18;

    public static double kV = 0.01;
    public double goalRPM = 1200;

    double[] increments = {0.000001,0.00001,0.0001,0.001,0.01,0.1,1,10};

    int incrementsIdx = 4;

    @Override
    public void init(){
        flywheel.init(hardwareMap);


    }

    @Override
    public void loop(){
        if(gamepad1.dpadRightWasPressed() && incrementsIdx <4){
            incrementsIdx++;
        }
        if(gamepad1.dpadLeftWasPressed() && incrementsIdx >0 ){
            incrementsIdx--;
        }

        if(gamepad1.a){
            goalRPM = 1200;
        }
        else if(gamepad1.b){

            goalRPM = 750;
        }

        double currentStep = increments[incrementsIdx];

        if(gamepad1.dpadUpWasPressed()){ kV += currentStep;}
        if(gamepad1.dpadDownWasPressed()){ kV -= currentStep;}



        double power = (kV * goalRPM )+ kS;

        flywheel.setMotorPower(power);

        //0.000158

        //0.000176

        telemetry.addData("Step","%.6f",currentStep);
        telemetry.addData("kV","%.6f",kV);
        telemetry.addData("RPM",flywheel.getRPM());
        telemetry.addData("Tick Per Sec",flywheel.getTicksPerSec());
    }



}
