package org.firstinspires.ftc.teamcode.pedro.Turret;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

public class PID extends LinearOpMode {

    DcMotorEx intakeLeft;

    double intergralSum = 0;
    double kP = 0;
    double kI = 0;
    double kD = 0;
    double lastError;


    ElapsedTime timer = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException{
        intakeLeft = hardwareMap.get(DcMotorEx.class,"intakeLeft");
        intakeLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        waitForStart();
        while(opModeIsActive()){
            double power = PIDControl(2000, intakeLeft.getCurrentPosition());

            intakeLeft.setPower(power);


        }
    }



    public double PIDControl(double reference, double state){
        double error = reference - state;
        intergralSum += error * timer.seconds();

        double derivative = (error - lastError)/timer.seconds();
        lastError = error;
        timer.reset();

        double output = (error * kP)+(derivative*kD)+(intergralSum * kI);
         return output;
    }
}
