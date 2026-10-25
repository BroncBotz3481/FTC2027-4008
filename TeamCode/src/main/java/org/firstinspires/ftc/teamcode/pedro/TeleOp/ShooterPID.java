package org.firstinspires.ftc.teamcode.pedro.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ShooterPID extends OpMode {
    public DcMotorEx flywheel;
    double highVel = 1500;
    double lowVel = 900;
    double curtargetVelocity = highVel;

    double F = 0;

    double P=0;

    double[] stepSizes = {10.0,  1,  0.1,  0.01,  0.001, 0.0001};
    int stepIndex = 1;


    @Override
    public void init(){
        flywheel = hardwareMap.get(DcMotorEx.class,"flywheel");
        flywheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER );
        flywheel.setDirection(DcMotorEx.Direction.REVERSE);

        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P,0,0,F);
        flywheel.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,pidfCoefficients);
        telemetry.addLine("Init complete");

    }

    @Override
    public void loop(){

        if(gamepad1.yWasPressed()){
            if(curtargetVelocity == highVel){
                curtargetVelocity = lowVel;
            }else{curtargetVelocity = highVel;}

        }

        if(gamepad1.bWasPressed()){

            stepIndex = (stepIndex + 1) % stepSizes.length;
        }

        if(gamepad1.dpadLeftWasPressed()){
            F -= stepSizes[stepIndex];
        }
        if(gamepad1.dpadRightWasPressed()){
            F+= stepSizes[stepIndex];
        }

        if(gamepad1.dpadUpWasPressed()){
            P += stepSizes[stepIndex];
        }
        if(gamepad1.dpadDownWasPressed()){
            P-= stepSizes[stepIndex];
        }



        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P,0,0,F);
        flywheel.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,pidfCoefficients);


        flywheel.setVelocity(curtargetVelocity);

        double curVelocity = flywheel.getVelocity();
        double error = curtargetVelocity - curVelocity;


        telemetry.addData("Target Vel", curtargetVelocity);
        telemetry.addData("Current Vel","%.2f",curVelocity);
        telemetry.addData("Error","%.2f",error  );
        telemetry.addLine("------------------------");
        telemetry.addData("Tuning P ","%.4f(D-Pad U/D)",P);
        telemetry.addData("Tuning F","%.4f(D-Pad L/R)",F);
        telemetry.addData("Step Size","%.4f(B button)",stepSizes[stepIndex]);


    }
}
