package org.firstinspires.ftc.teamcode.pedro.Flywheel;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp
public class Finaltest extends OpMode {
    Flywheel flywheel = new Flywheel();

    public double kS = 0.17;

    public static double kV = 0.000176;
    public double goalRPM = 1200;

    public double kP = 0.001050;


    @Override
    public void init(){
        flywheel.init(hardwareMap);


    }

    @Override
    public void loop(){

        if(gamepad1.a){
            goalRPM = 1200;
        }
        else if(gamepad1.b){

            goalRPM = 750;
        }



        double feedforward = (kV * goalRPM )+ kS;
        double error = goalRPM- flywheel.getRPM();
        double feedback = error * kP;

        flywheel.setMotorPower(feedforward+feedback);

        telemetry.addData("kP","%.6f",kP);
        telemetry.addData("RPM",flywheel.getRPM());
        telemetry.addData("Error",error);
        telemetry.addData("Tick Per Sec",flywheel.getTicksPerSec());
    }



}
