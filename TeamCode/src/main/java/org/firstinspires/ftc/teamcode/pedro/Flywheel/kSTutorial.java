package org.firstinspires.ftc.teamcode.pedro.Flywheel;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class kSTutorial extends OpMode {
    Flywheel flywheel = new Flywheel();

    public double kS = 0;

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

        double currentStep = increments[incrementsIdx];

        if(gamepad1.dpadUpWasPressed()){ kS += currentStep;}
        if(gamepad1.dpadDownWasPressed()){ kS -= currentStep;}

        flywheel.setMotorPower(kS);

        telemetry.addData("Step","%.6f",currentStep);
        telemetry.addData("kS","%.6f",kS);
        telemetry.addData("RPM",flywheel.getRPM());
        telemetry.addData("Tick Per Sec",flywheel.getTicksPerSec());
    }



}
