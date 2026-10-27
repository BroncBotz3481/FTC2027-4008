package org.firstinspires.ftc.teamcode.pedro.TeleOp;

import android.hardware.Sensor;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

public class HardwareMap2027Team4008 {

    //TODO: May need to change Servos for turret and hood to be different



    public DcMotorEx PollenShooter,NectarShooter = null;
    public DcMotor intakeMain1, intakeMain2 = null;
    public Servo turretservo1,turretservo2,flowerIntake,gatePollen,gateNectar,HoodNectar , HoodPollen = null;
    public CRServo AddCrServosHere = null;

    public Sensor batteryvoltageSensor = null;
    public DcMotor DriveLeftFront = null;
    public DcMotor DriveRightFront = null;
    public DcMotor DriveLeftBack = null;
    public DcMotor DriveRightBack = null;


    //Constants


    //gate
    private double gatePollenClosePos = 0;
    private double gatePollenOpenPos = 0;

    private double gateNectarClosePos = 0;
    private double gateNectarOpenPos = 0;

    //FlowerIntake
    private double flowerIntakeBlockingPos = 0;
    private double flowerIntakeIntakingPos = 0;
    private double flowerIntakeBasePos = 0;

    //Turret
    private double turretservo1DefaultPos = 0.5;
    private double turretservo2DefaultPos = 0.5;
    private double turretServo1CalculatedPose= 0;
    private double turretServo2CalculatedPose= 0;

    //Hood
    private double NectarHoodDefaultPose = 0.5;
    private double NectarHoodCalculatedPose = 0;

    private double PollenHoodDefaultPose = 0.5;
    private double PollenHoodCalculatedPose = 0;


    com.qualcomm.robotcore.hardware.HardwareMap hwMap = null;


    public void Map(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {
        hwMap = hardwareMap;

        intakeMain1 = hwMap.get(DcMotor.class, "intakeMain1");
        intakeMain2 = hwMap.get(DcMotor.class,"intakeMain2");
        PollenShooter = hwMap.get(DcMotorEx.class, "outtake2");
        NectarShooter = hwMap.get(DcMotorEx.class, "NectarShooter");
        //Done
        gatePollen = hwMap.get(Servo.class, "gatePollen");
        gateNectar = hwMap.get(Servo.class,"gateNectar");
        flowerIntake = hwMap.get(Servo.class,"flowerIntake");
        HoodNectar = hwMap.get(Servo.class,"HoodNectar");
        HoodPollen = hwMap.get(Servo.class,"HoodPollen");
        turretservo1 = hwMap.get(Servo.class,"turretservo1");
        turretservo2 = hwMap.get(Servo.class,"turretservo2");
        batteryvoltageSensor = hwMap.get(Sensor.class, "batteryvoltageSensor");



        //   Lights = hwMap.get(RevBlinkinLedDriver.class,"Lights");
        intakeMain1.setDirection(DcMotor.Direction.FORWARD);
        intakeMain1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeMain1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMain1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intakeMain2.setDirection(DcMotor.Direction.FORWARD);
        intakeMain2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeMain2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMain2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        PollenShooter.setDirection(DcMotor.Direction.FORWARD);
        PollenShooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        PollenShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        PollenShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        PollenShooter.setVelocityPIDFCoefficients(0,0,0,0);


        NectarShooter.setDirection(DcMotor.Direction.REVERSE);
        NectarShooter.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        NectarShooter.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        NectarShooter.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        NectarShooter.setVelocityPIDFCoefficients(8, 0, 0.01, 8.8);

        DriveLeftBack.setDirection(DcMotor.Direction.FORWARD);
        DriveLeftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DriveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DriveRightBack.setDirection(DcMotor.Direction.FORWARD);
        DriveRightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DriveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DriveRightFront.setDirection(DcMotor.Direction.FORWARD);
        DriveRightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DriveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DriveLeftFront.setDirection(DcMotor.Direction.FORWARD);
        DriveLeftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DriveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);




//        SlideMotor1.setPositionPIDFCoefficients();


    }
}


