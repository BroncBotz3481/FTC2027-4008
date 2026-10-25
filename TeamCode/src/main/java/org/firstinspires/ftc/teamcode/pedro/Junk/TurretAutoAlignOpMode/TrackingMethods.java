package org.firstinspires.ftc.teamcode.pedro.Junk.TurretAutoAlignOpMode;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.pedro.TuningStuff.Constants;
import com.pedropathing.api.PoseFactory;
import com.pedropathing.math.Pose;

@TeleOp(name = "TurretAiming")

public class TrackingMethods extends OpMode {
    private Follower follower;
    private Servo turret;
    private final PoseFactory p = PoseFactory.degrees();
    private final Pose startPose = p.of(56, 8, 90);
    private double TICKS_PER_REV = 1;

    private double HeadingInDegrees = Math.toDegrees(follower.pose().heading());


    public double getThetaAngle(){
        double absForwardPodValue = Math.abs(57 - follower.pose().y());

        double absStrafePodValue = Math.abs(10 - follower.pose().x());
        return Math.toDegrees(Math.atan2(absForwardPodValue, absStrafePodValue));
    }

    public double autoAlign(boolean isBlue) {

        double targetPosition;

        if (!isBlue) {
            targetPosition = 0.5 + (((-90 - getThetaAngle() + HeadingInDegrees / 360.0) * TICKS_PER_REV));
        } else {
            targetPosition = 0.5 + (((90 - getThetaAngle() - HeadingInDegrees / 360.0) * TICKS_PER_REV));
        }

        targetPosition = Math.max(0.0, Math.min(1.0, targetPosition));

        turret.setPosition(targetPosition);

        return targetPosition;


    }

    @Override
    public void init() {
        follower = Constants.create(hardwareMap);
        turret = hardwareMap.get(Servo.class,"turret");
        turret.setPosition(0.5);


    }
    @Override
    public void loop() {
        follower.update();
        Pose robotPose = follower.pose();
        boolean isBlue = true;
        double targetPose = autoAlign(isBlue);
        telemetry.addData("Robot X", robotPose.x());
        telemetry.addData("Robot Y", robotPose.y());
        telemetry.addData("Robot Heading", Math.toDegrees(robotPose.heading()));

    }
}