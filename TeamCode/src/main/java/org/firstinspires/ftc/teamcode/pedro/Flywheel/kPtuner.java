package org.firstinspires.ftc.teamcode.pedro.Flywheel;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class kPtuner extends OpMode {
    Flywheel flywheel = new Flywheel();

    public double kS = 0.17;

    public static double kV = 0.000176;
    public double goalRPM = 1200;

    public double kP = 0.001050;

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

        if(gamepad1.dpadUpWasPressed()){ kP += currentStep;}
        if(gamepad1.dpadDownWasPressed()){ kP -= currentStep;}



        double feedforward = (kV * goalRPM )+ kS;
        double error = goalRPM- flywheel.getRPM();
        double feedback = error * kP;

        flywheel.setMotorPower(feedforward+feedback);

        telemetry.addData("Step","%.6f",currentStep);
        telemetry.addData("kP","%.6f",kP);
        telemetry.addData("RPM",flywheel.getRPM());
        telemetry.addData("Error",error);
        telemetry.addData("Tick Per Sec",flywheel.getTicksPerSec());
    }



}
