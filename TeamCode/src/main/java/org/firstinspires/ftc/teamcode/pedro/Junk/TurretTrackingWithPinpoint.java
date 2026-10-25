package org.firstinspires.ftc.teamcode.pedro.Junk;

import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;

public class TurretTrackingWithPinpoint {


    private final double TICKS_PER_REV = 1;

    public Servo turret;
    public GoBildaPinpointDriver pinpoint;

    public void initTurret(HardwareMap hwMap) {
        turret = hwMap.get(Servo.class, "turret");
        turret.setPosition(0.5);
    }

    // Initialize the Pinpoint odometry computer
    public void initPinpoint(HardwareMap hwMap, Pose2D startingPose) {
        pinpoint = hwMap.get(GoBildaPinpointDriver.class, "pinpoint");
        pinpoint.setOffsets(-4.25, -7.5, DistanceUnit.INCH);
        pinpoint.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD);
        pinpoint.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        pinpoint.recalibrateIMU();
        if (startingPose != null) {
            pinpoint.setPosition(startingPose);
        }
    }

    // Reset the robot's position and heading
    public void reset(Pose2D resetPose) {
        pinpoint.recalibrateIMU();
        pinpoint.setPosition(resetPose);
    }

    // Get robot heading in degrees
    public double getRobotHeading() {
        return pinpoint.getHeading(AngleUnit.DEGREES);
    }

    public double getTurretAngle() {
        return ((turret.getPosition() + 0.5) / TICKS_PER_REV) * 360.0;
    }

    public double getTheta() {
        pinpoint.update();
        double absForwardPodValue = Math.abs(57 - pinpoint.getPosition().getX(DistanceUnit.INCH));

        double absStrafePodValue = Math.abs(10 - pinpoint.getPosition().getY(DistanceUnit.INCH));
        return Math.toDegrees(Math.atan2(absForwardPodValue, absStrafePodValue));
    }


    // Stop turret movement by holding its current commanded position
    public void stop() {
        if (turret != null) {
            turret.setPosition(turret.getPosition());
        }
    }

    // Automatically align the turret based on alliance
    public double autoAlign(boolean isBlue) {

        double targetPosition;

        if (!isBlue) {
            targetPosition = 0.5 + (((-90 - getTheta() + getRobotHeading()) / 360.0) * TICKS_PER_REV);
        } else {
            targetPosition = 0.5 + (((90 - getTheta() - getRobotHeading()) / 360.0) * TICKS_PER_REV);
        }

        targetPosition = Math.max(0.0, Math.min(1.0, targetPosition));

        turret.setPosition(targetPosition);
        return targetPosition;


    }

}