package org.firstinspires.ftc.teamcode.pedro.Junk.TurretAutoAlignOpMode;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
@TeleOp(name = "HeadingTestPinpoint", group = "Test")
public class PinpointHeading_Test extends OpMode {



    private GoBildaPinpointDriver pinpoint;
    public Servo turret;

    @Override
    public void init() {
        turret = hardwareMap.get(Servo.class, "turret");
        turret.setPosition(0.5);

        pinpoint = hardwareMap.get(GoBildaPinpointDriver.class, "pinpoint");

        pinpoint.setOffsets(
                -4.25,
                -7.5,
                DistanceUnit.INCH
        );

        pinpoint.setEncoderResolution(0.0029459901800327, DistanceUnit.INCH);
        pinpoint.setEncoderResolution(
                GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD
        );
        pinpoint.setEncoderDirections(
                GoBildaPinpointDriver.EncoderDirection.FORWARD,
                GoBildaPinpointDriver.EncoderDirection.FORWARD
        );

        pinpoint.recalibrateIMU();

        // Force an update to get the initial position from the hardware
        pinpoint.update();

        // Send the initial heading to telemetry
        telemetry.addData("Initial Heading", pinpoint.getHeading(AngleUnit.DEGREES));
        telemetry.update();
    }

    @Override
    public void loop() {
        // Make sure to call update() in loop if you want continuous tracking later
        pinpoint.update();
        pinpoint.resetPosAndIMU();

            telemetry.addData("Heading", pinpoint.getHeading(AngleUnit.DEGREES));
            telemetry.addData("X_Y pos :" , pinpoint.getPosition());


    }
}