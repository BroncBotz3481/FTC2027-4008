package org.firstinspires.ftc.teamcode.pedro.Autos;

import org.firstinspires.ftc.teamcode.pedro.Autos.OpModeStorage;


import com.pedropathing.api.Paths;

import com.pedropathing.api.PoseFactory;
import com.pedropathing.follower.Follower;
import com.pedropathing.math.Pose;
import com.pedropathing.paths.Path;
import com.pedropathing.ivy.Command;
import com.pedropathing.ivy.Scheduler;
import static com.pedropathing.ivy.Scheduler.schedule;
import static com.pedropathing.ivy.groups.Groups.parallel;
import static com.pedropathing.ivy.groups.Groups.sequential;
import static com.pedropathing.ivy.pedro.PedroCommands.follow;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedro.TeleOp.HwMap;
import org.firstinspires.ftc.teamcode.pedro.TeleOp.RobotStates;
import org.firstinspires.ftc.teamcode.pedro.TuningStuff.Constants;

@Autonomous(name = "AutoSoloRed", group = "Autonomous")
public class AutoSoloRed extends LinearOpMode {
    private AutoCommands AutoCommands;
    private Follower follower;

    private final PoseFactory poseFactory = PoseFactory.degrees();

    HwMap hwMap = new HwMap();

    public int mimiumthresholdShooterTimeMilliseconds = 5000;

    RobotStates robotStates = RobotStates.IDLE;


    private ElapsedTime Intaketimer = new ElapsedTime();
    private ElapsedTime Shootertimer = new ElapsedTime();

    private ElapsedTime PreloadPhaseTimer = new ElapsedTime();

    private ElapsedTime FlowerIntakePhaseTimer = new ElapsedTime();

    private double curPollenShooterVelocity = hwMap.PollenShooter.getVelocity();

    private boolean ReachedVelocity;








    private final Pose start = poseFactory.of(56, 8, 180);
    private final Pose path1 = poseFactory.of(10, 8, 180);
    private final Pose point2Start = poseFactory.of(10, 8, 180);
    private final Pose point2 = poseFactory.of(29, 118, 90);
    private final Pose point3 = poseFactory.of(46, 133, 90);





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

        // Initialize hardware map (make sure hwMap.init() or similar is called if needed)
        // hwMap.init(hardwareMap);

        follower = Constants.create(hardwareMap);
        follower.setPose(start);
        follower.update();

        // Instantiate your command class, passing hwMap and follower
        AutoCommands = new AutoCommands(hwMap, follower);

        waitForStart();
        schedule(autoRoutine());

        try {
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
        finally {
            OpModeStorage.autonomousEndPose = follower.pose();
        }
    }

    public Path path1() {
        return Paths.line(start, path1).linear(start, path1);
    }

    public Path path2() {
        return Paths.line(point2Start, point2).linear(point2Start, point2);
    }

    public Path path3() {
        return Paths.line(point2, point3).constant(point3);
    }




    //
    //    public void update(){
    //        switch(robotStates) {
    //            case IDLE:{
    //
    //
    //            }
    //            case IntakeStart:
    //                if(gamepad1.a)
    //                    hwMap.intakeMain1.setPower(0.7);
    //                hwMap.intakeMain2.setPower(0.7);
    //                break;
    //            case IntakeDone:
    //                if(Intaketimer.milliseconds()>1000){
    //                    hwMap.intakeMain1.setPower(0);
    //                    robotStates = RobotStates.IDLE;
    //                }
    //
    //
    //        }
    //    }
    //Command ShootCommand = Command.build()
    //        .setStart(() -> hwMap.PollenShooter.setVelocity(hwMap.PollenShooterTargetVelocity))
    //        .setExecute(() -> hwMap.PollenShooter.setPower(hwMap.PollenShooter.getCurrentPosition()))
    //        .setDone(() -> Math.abs(curPollenShooterVelocity - hwMap.PollenShooter.getCurrentPosition()) < 10)
    //        .setEnd(endCondition -> hwMap.PollenShooter.setVelocity(hwMap.PollenShooterbaseVelocity));
    //
    //
    //    public void setRobotState(RobotStates states){
    //        robotStates = states;
}
