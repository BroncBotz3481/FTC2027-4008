package org.firstinspires.ftc.teamcode.pedro.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "Intake Voltage Comp", group = "Linear OpMode")

public class VoltageCompensation extends LinearOpMode {

    private DcMotor intakeMain1,intakeMain2;
    private VoltageSensor voltageSensor;

    private final double NOMINAL_VOLTAGE = 13.0;

    @Override
    public void runOpMode() {
        intakeMain1 = hardwareMap.get(DcMotor.class, "intakeMainRight");
        intakeMain2 = hardwareMap.get(DcMotor.class,"intakeMainLeft");
        voltageSensor = hardwareMap.voltageSensor.iterator().next();


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double currentVoltage = voltageSensor.getVoltage();
            double targetPower = 0.0;

            if (gamepad1.a) {
                targetPower = 0.8;
            } else {
                targetPower = 0.0;
            }

            if (currentVoltage > 0) {
                double compensatedPower = targetPower * (NOMINAL_VOLTAGE / currentVoltage);
                compensatedPower = Range.clip(compensatedPower, -1.0, 1.0);
                intakeMain1.setPower(compensatedPower);
                intakeMain2.setPower(compensatedPower);
            } else {
                intakeMain1.setPower(targetPower);
                intakeMain2.setPower(targetPower);
            }
            telemetry.addData("Battery Voltage", "%.2f V", currentVoltage);
            telemetry.addData("Requested Power", "%.2f", targetPower);
            telemetry.addData("Compensated Power", "%.2f", intakeMain1.getPower());
            telemetry.update();
        }
    }
}
