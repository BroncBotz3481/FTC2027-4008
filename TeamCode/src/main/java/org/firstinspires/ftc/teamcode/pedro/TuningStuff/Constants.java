package org.firstinspires.ftc.teamcode.pedro.TuningStuff;

import com.pedropathing.algorithm.Foresight;
import com.pedropathing.algorithm.ForesightConfig;
import com.pedropathing.controllers.Controller;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Matrix;
import com.pedropathing.math.Vector2D;
import com.pedropathing.revhub.drivetrains.Mecanum;
import com.pedropathing.revhub.drivetrains.MecanumConfig;
import com.pedropathing.revhub.localizers.Encoder;
import com.pedropathing.revhub.localizers.PinpointConfig;
import com.pedropathing.revhub.localizers.PinpointLocalizer;
import com.pedropathing.revhub.localizers.RevHubIMU;
import com.pedropathing.revhub.localizers.TwoWheelConfig;
import com.pedropathing.revhub.localizers.TwoWheelLocalizer;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Constants {
    public static MecanumConfig drivetrainConfig = new MecanumConfig(c -> {
        c.frontLeftName.set("fld");
        c.frontRightName.set("frd");
        c.backLeftName.set("bld");
        c.backRightName.set("brd");
        c.frontLeftDirection.set(DcMotor.Direction.REVERSE);
        c.frontRightDirection.set(DcMotor.Direction.FORWARD);
        c.backLeftDirection.set(DcMotor.Direction.REVERSE);
        c.backRightDirection.set(DcMotor.Direction.FORWARD);
        c.manualBrakeMode.set(true);
    });


    public static PinpointConfig localizerConfig = new PinpointConfig(
            c -> {
                c.name.set("pinpoint");
                c.xPodOffset.set(2.187);
                c.yPodOffset.set(-4.572);
                c.xPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
                c.yPodDirection.set(GoBildaPinpointDriver.EncoderDirection.FORWARD);
            }
    );

//works
//    public static TwoWheelConfig localizerConfig = new TwoWheelConfig(c -> {
//        c.xPodName.set("bld");
//        c.yPodName.set("fld");
//        c.imuName.set("imu");
//        c.xPodOffset.set(-8.550);
//        c.yPodOffset.set(-3.450);
//      c.forwardTicksToInches.set(0.002965983633879632);
//       c.strafeTicksToInches.set(0.00474166097350855);
//        c.xPodDirection.set(Encoder.FORWARD);
//        c.yPodDirection.set(Encoder.REVERSE);
//        c.imu.set(new RevHubIMU(new RevHubOrientationOnRobot(
//                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
//                RevHubOrientationOnRobot.UsbFacingDirection.UP
//        )));
//    });

    public static ForesightConfig foresightConfig = new ForesightConfig(
            c -> {
                Controller primaryTranslationalForward = Controller.proportional(0.2580);
                Controller secondaryTranslationalForward = Controller.proportional(0.0710);
                Controller primaryTranslationalLateral = Controller.proportional(0.0670);
                Controller secondaryTranslationalLateral = Controller.proportional(0.0230);

                c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
                c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

                c.coast.set(Controller.proportionalFeedforward(0.011350664217091716));
                c.brake.set(Controller.proportionalFeedforward(0.009648064584527959));

                c.headingFeedback.set(Controller.proportional(2.866511963473896));
                c.headingBrakeCoefficients.set(Vector2D.cartesian(0.06930897539832256, 0.0038751215057113604));

                c.linearBrakeCoefficients.set(Matrix.diag(0.08944490728182519, 0.051387149323076343));
                c.quadraticBrakeCoefficients.set(Matrix.diag(0.0012028031124618115, 6.962023396299491E-4));

                c.maxAchievableForwardVelocity.set(83.5481133846109);
                c.maxAchievableStrafeVelocity.set(136.7493332448745);
                c.naturalForwardDeceleration.set(33.03205887234673);
                c.naturalStrafeDeceleration.set(129.5355317684777);
            }
    );





    public static Follower create(HardwareMap h) {
        return new Follower(
                new PinpointLocalizer(h, localizerConfig),
                new Mecanum(h, drivetrainConfig),
                new Foresight(foresightConfig)
        );
    }

}















// Lots fo jitter pid values
/*public static ForesightConfig foresightConfig = new ForesightConfig(
        c -> {
            Controller primaryTranslationalForward = Controller.proportional(0.2786636044990358);
            Controller secondaryTranslationalForward = Controller.proportional(0.10295875583374607);
            Controller primaryTranslationalLateral = Controller.proportional(0.14769491547094044);
            Controller secondaryTranslationalLateral = Controller.proportional(0.054569324785687726);

            c.forwardTranslational.set(Controller.piecewise(secondaryTranslationalForward).put(2.5, primaryTranslationalForward));
            c.strafeTranslational.set(Controller.piecewise(secondaryTranslationalLateral).put(2.5, primaryTranslationalLateral));

            c.coast.set(Controller.proportionalFeedforward(0.011350664217091716));
            c.brake.set(Controller.proportionalFeedforward(0.009648064584527959));

            c.headingFeedback.set(Controller.proportional(5.866511963473896));
            c.headingBrakeCoefficients.set(Vector2D.cartesian(0.06930897539832256, 0.0038751215057113604));

            c.linearBrakeCoefficients.set(Matrix.diag(0.08944490728182519, 0.051387149323076343));
            c.quadraticBrakeCoefficients.set(Matrix.diag(0.0012028031124618115, 6.962023396299491E-4));

            c.maxAchievableForwardVelocity.set(83.5481133846109);
            c.maxAchievableStrafeVelocity.set(136.7493332448745);
            c.naturalForwardDeceleration.set(33.03205887234673);
            c.naturalStrafeDeceleration.set(129.5355317684777);
        }
);*/

