package org.firstinspires.ftc.teamcode.pedro.Autos;

import static com.pedropathing.api.Paths.*;
import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.commands.Commands.*;
import static com.pedropathing.ivy.groups.Groups.parallel;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.pedro.TeleOp.HwMap;
import org.firstinspires.ftc.teamcode.pedro.TuningStuff.Constants;

@Autonomous(name = "AutoPath", group = "Autonomous")
public class AutoSoloBlue extends LinearOpMode {


    private AutoCommands AutoCommands;
    private Follower follower;
    HwMap hwMap = new HwMap();

    private final PoseFactory poseFactory = PoseFactory.degrees();

    private final Pose start = poseFactory.of(82.5211, 132.3711, 90);
    private final Pose point1 = poseFactory.of(127, 133, 360);
    private final Pose point2Start = poseFactory.of(127, 133, 360);
    private final Pose point2 = poseFactory.of(102, 28, 270);
    private final Pose point3 = poseFactory.of(94, 12, 270);

    // Autonomous routine
    public Command autoRoutine() {
        return sequential(
                AutoCommands.Pollen_Shooting_Routine(),
                parallel(
                        AutoCommands.Simple_Intaking_Routine(),
                        follow(follower, path1())
                ),
                follow(follower, path2()),
                AutoCommands.Pollen_Shooting_Routine(),
                follow(follower, path3()),
                AutoCommands.Flower_Intaking_Routine(),
                AutoCommands.Chill,
                AutoCommands.Pollen_Shooting_Routine()
        );
    }

    @Override
    public void runOpMode() {
        hwMap.Map(hardwareMap);
        Scheduler.reset();
        follower = Constants.create(hardwareMap);
        follower.setPose(start);
        follower.update();

        waitForStart();
        schedule(autoRoutine());

        while (opModeIsActive()) {
            follower.update();
            Scheduler.execute();

            telemetry.addData("x", follower.pose().x());
            telemetry.addData("y", follower.pose().y());
            telemetry.addData("heading", follower.pose().heading());

            if (follower.currentPath() != null) {
                telemetry.addData("Current path distance remaining", follower.distanceToEndpoint());
                telemetry.addData("Path number", follower.pathIndex());
            }

            telemetry.update();
        }
    }

    public Path path1() {
        return Paths.line(start, point1).constant(point1);
    }

    public Path path2() {
        return Paths.line(point2Start, point2).linear(point2Start, point2);
    }

    public Path path3() {
        return Paths.line(point2, point3).constant(point3);
    }
}
