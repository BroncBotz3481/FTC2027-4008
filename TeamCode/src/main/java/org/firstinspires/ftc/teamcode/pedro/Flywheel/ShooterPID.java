package org.firstinspires.ftc.teamcode.pedro.Flywheel;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp (name = "Pid shooter")


public class ShooterPID extends OpMode {
    public DcMotorEx NectarShooter;
    double highVel = 1500;
    double lowVel = 900;
    double curtargetVelocity = highVel;


    double F = 0;

    double P=0;

    double[] stepSizes = {10,  1,  0.1,  0.01,  0.001, 0.0001};
    int stepIndex = 1;


    @Override
    public void init(){
        NectarShooter = hardwareMap.get(DcMotorEx.class,"NectarShooter");
        NectarShooter.setMode(DcMotorEx.RunMode.RUN_USING_ENCODER );
        NectarShooter.setDirection(DcMotorEx.Direction.FORWARD);


        PIDFCoefficients pidfCoefficients = new PIDFCoefficients(P,0,0,F);
        NectarShooter.setPIDFCoefficients(DcMotorEx.RunMode.RUN_USING_ENCODER,pidfCoefficients);
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
        NectarShooter.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER,pidfCoefficients);


        NectarShooter.setVelocity(curtargetVelocity);

        double curVelocity = NectarShooter.getVelocity();
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
