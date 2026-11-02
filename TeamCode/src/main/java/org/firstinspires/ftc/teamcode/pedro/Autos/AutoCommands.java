package org.firstinspires.ftc.teamcode.pedro.Autos;

import static com.pedropathing.ivy.commands.Commands.instant;
import static com.pedropathing.ivy.commands.Commands.waitMs;
import static com.pedropathing.ivy.commands.Commands.waitUntil;

import com.pedropathing.follower.Follower;
import com.pedropathing.ivy.Command;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.pedro.TeleOp.HwMap;

public class AutoCommands {

    private HwMap hwMap;
    private Follower follower;

    private ElapsedTime shooterTimer = new ElapsedTime();
    private ElapsedTime intakeTimer = new ElapsedTime();
    private ElapsedTime IntakingPhaseTimer = new ElapsedTime();


    public double curPollenShooterVelocity =hwMap.PollenShooter.getVelocity();

    // Constructor to receive your hardware map and follower instance
    public AutoCommands(HwMap hwMap, Follower follower) {
        this.hwMap = hwMap;
        this.follower = follower;
    }

    public Command Pollen_Shooting_Routine() {
        return Command.build()
                .setStart(() -> {
                    shooterTimer.reset();
                    hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
                })
                .setExecute(() -> {
                    hwMap.PollenShooter.setVelocity(hwMap.PollenShooterTargetVelocity);
                    hwMap.intakeMain1.setPower(hwMap.intakePower);
                    hwMap.intakeMain2.setPower(hwMap.intakePower);
                })
                .setDone(() -> shooterTimer.milliseconds() >= 5000)
                .setEnd(endCondition -> {
                    hwMap.PollenShooter.setVelocity(0);
                })
                .requiring(hwMap.PollenShooter,
                        hwMap.intakeMain1,
                        hwMap.intakeMain2,
                        hwMap.gatePollen);
    }

    public Command Flower_Intaking_Routine() {
        return Command.build()
                .setStart(() -> {
                    intakeTimer.reset();
                    hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
                    hwMap.flowerIntake.setPosition(hwMap.flowerIntakeIntakingPos);
                })
                .setExecute(() -> {
                    hwMap.intakeMain1.setPower(hwMap.intakePower);
                    hwMap.intakeMain2.setPower(hwMap.intakePower);
                })
                .setDone(() -> intakeTimer.milliseconds() >= 5000)
                .setEnd(endCondition -> {
                    hwMap.intakeMain1.setPower(0);
                    hwMap.intakeMain2.setPower(0);
                });
    }


    public Command Simple_Intaking_Routine() {

        return Command.build()
                .setStart(() -> {
                    IntakingPhaseTimer.reset();
                    hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
                    hwMap.gateNectar.setPosition(hwMap.gateNectarClosePos);
                })
                .setExecute(() -> {
                    hwMap.intakeMain1.setPower(hwMap.intakePower);
                    hwMap.intakeMain2.setPower(hwMap.intakePower);
                })
                .setDone(() -> IntakingPhaseTimer.milliseconds() >= 5000)
                .setEnd(endCondition -> {
                    hwMap.intakeMain1.setPower(0);
                    hwMap.intakeMain2.setPower(0);
                });

    }


    //Backup Simple Commands for on the fly autos can be used in TeleOp as well
    Command flowerIntakeSetPosition = instant(() -> hwMap.flowerIntake.setPosition(hwMap.flowerIntakeIntakingPos));

    //the intakes should be parallel
    Command IntakeMain1Run = instant(()-> hwMap.intakeMain1.setPower(hwMap.intakePower));
    Command IntakeMain2Run = instant(()-> hwMap.intakeMain2.setPower(hwMap.intakePower));


    Command IntakeMain1Spit = instant(()-> hwMap.intakeMain1.setPower(hwMap.intakeSpitPower));
    Command IntakeMain2Spit= instant(()-> hwMap.intakeMain2.setPower(hwMap.intakeSpitPower));

    Command ShooterPollenRun =  instant(()-> hwMap.PollenShooter.setVelocity(hwMap.PollenShooterTargetVelocity));
    Command ShooterNectarRun =  instant(()-> hwMap.NectarShooter.setVelocity(hwMap.NectarShooterTargetVelocity));

    //gate-may run in parallel or separately idk yet
    Command PollenGateOpen =  instant(()-> hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos));
    Command NectarGateOpen =  instant(()-> hwMap.gateNectar.setPosition(hwMap.gateNectarOpenPos));

    Command PollenGateClose =  instant(()-> hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos));
    Command NectarGateClose =  instant(()-> hwMap.gateNectar.setPosition(hwMap.gateNectarClosePos));


    //Turret Stuff need to change for sure later
    //Run in parallel
    Command TurretServo1Reset  =  instant(()-> hwMap.turretservo1.setPosition(hwMap.turretServo1DefaultPos));
    Command TurretServo2Reset  =  instant(()-> hwMap.turretservo2.setPosition(hwMap.turretServo2DefaultPos));


    Command HoodPollenReset = instant(()-> hwMap.HoodPollen.setPosition(hwMap.PollenHoodDefaultPose));
    Command HoodNectarReset = instant(() -> hwMap.HoodNectar.setPosition(hwMap.NectarHoodDefaultPose));

    Command Chill = waitMs(500);


    Command WaitForMiAmor = waitUntil(()-> hwMap.PollenShooter.getVelocity() > 1400);


//    public Command DeBounceTest_wPedro() {
//        return Command.build()
//                .setStart(() -> {
//                });
//
//    }

}

