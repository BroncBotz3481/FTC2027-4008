package org.firstinspires.ftc.teamcode.pedro.TeleOp;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class HwMap {

    //TODO: May need to change Servos for turret and hood to be different



    public DcMotorEx PollenShooterLeft, PollenShooterRight = null;
    public DcMotor intakeMain1, intakeMain2 = null;
    public Servo turretservo1,turretservo2,flowerIntake,gatePollen,gateNectar,HoodNectar , HoodPollen = null;
    public CRServo AddCrServosHere = null;



    public DcMotor DriveLeftFront = null;
    public DcMotor DriveRightFront = null;
    public DcMotor DriveLeftBack = null;
    public DcMotor DriveRightBack = null;

    public double gatePollenClosePos = 0.125;
    public double gatePollenOpenPos = 0.3;

//    public double gateNectarClosePos = 0;
//    public double gateNectarOpenPos = 0.02;

    public double flowerIntakeInspectionPos = 0.66;
    public double flowerIntakeIntakingPos = 0.06;
    public double flowerIntakeBasePos = 0.6;

    //Turret
    public double turretServo1DefaultPos = 0.145;
    public double turretServo2DefaultPos = 0.145;


    public double turretServo1FacingControlHub = 0.218;
    public double turretServo2FacingControlHub = 0.218;

    public double turretServo1FacingExpansionHub = 0.108;
    public double turretServo2FacingExpansionHub = 0.108;

    public double turretServo1InspectionPos = 0.116;
    public double turretServo2InspectionPos = 0.116;






    public double turretServo1CalculatedPose= 0;
    public double turretServo2CalculatedPose= 0;

    //Hood
    public double NectarHoodDefaultPose = 0.5;
    public double NectarHoodIncrementPose = 0.460;

    public double PollenHoodDefaultPose = 0.35;
    public double PollenHoodIncrementPose = 0.260;



    public double intakePower = -0.8;
    public double intakePowerZero = 0;

    public double intakeSpitPower = 0.8;


    public double PollenShooterTargetVelocity = 1175;

    public double NectarShooterTargetVelocity = 1250;

    public double PollenHighvel = 1300;

    public double NectarHighvel = 1300;
//DONTCHANGE THIS^
    public double PollenShooterbaseVelocity = 0;

    public double NectarShooterbaseVelocity = 0;
/// ////////////////////////////////TODO:ONLY CHANGE THIS
    public double NectarShooterVelocityClose = 900;

    public double NectarShooterVelocityFar = 1100;

    public double PollenShooterVelocityClose = 900;

    public double PollenShooterVelocityFar = 1100;



    com.qualcomm.robotcore.hardware.HardwareMap hwMap = null;


    public void Map(com.qualcomm.robotcore.hardware.HardwareMap hardwareMap) {


        hwMap = hardwareMap;

        intakeMain1 = hwMap.get(DcMotor.class, "intakeMainLeft");//
        intakeMain2 = hwMap.get(DcMotor.class,"intakeMainRight");//
        PollenShooterLeft = hwMap.get(DcMotorEx.class, "PL");
        PollenShooterRight = hwMap.get(DcMotorEx.class, "PR");

        gatePollen = hwMap.get(Servo.class, "gatePollen");
//       // gateNectar = hwMap.get(Servo.class,"gateNectar");
//        flowerIntake = hwMap.get(Servo.class,"flowerIntake");
//       // HoodNectar = hwMap.get(Servo.class,"HoodNectar");
//        HoodPollen = hwMap.get(Servo.class,"HoodPollen");
//        turretservo1 = hwMap.get(Servo.class,"turretservo1");
//        turretservo2 = hwMap.get(Servo.class,"turretservo2");


        DriveLeftBack = hwMap.get(DcMotor.class,"bld");
        DriveLeftFront = hwMap.get(DcMotor.class,"fld");
        DriveRightBack = hwMap.get(DcMotor.class,"brd");
        DriveRightFront = hwMap.get(DcMotor.class,"frd");

        //   Lights = hwMap.get(RevBlinkinLedDriver.class,"Lights");
        intakeMain1.setDirection(DcMotorSimple.Direction.FORWARD);
        intakeMain1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeMain1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMain1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        intakeMain2.setDirection(DcMotor.Direction.REVERSE);
        intakeMain2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intakeMain2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intakeMain2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        PollenShooterLeft.setDirection(DcMotor.Direction.FORWARD);
        PollenShooterLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        PollenShooterLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        PollenShooterLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       PollenShooterLeft.setVelocityPIDFCoefficients(150,0,0,15.18);


        PollenShooterRight.setDirection(DcMotor.Direction.FORWARD);
        PollenShooterRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        PollenShooterRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        PollenShooterRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       PollenShooterRight.setVelocityPIDFCoefficients(150, 0, 0, 15.18);

        DriveLeftBack.setDirection(DcMotor.Direction.FORWARD);
        DriveLeftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveLeftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DriveLeftBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DriveRightBack.setDirection(DcMotor.Direction.REVERSE);
        DriveRightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveRightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DriveRightBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DriveRightFront.setDirection(DcMotor.Direction.REVERSE);
        DriveRightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveRightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DriveRightFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        DriveLeftFront.setDirection(DcMotor.Direction.FORWARD);
        DriveLeftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveLeftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        DriveLeftFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

       // gatePollen.setDirection(Servo.Direction.REVERSE);


//
//        turretservo1.setDirection(Servo.Direction.REVERSE);
//        turretservo2.setDirection(Servo.Direction.REVERSE);
//        HoodPollen.setDirection(Servo.Direction.REVERSE);
//        HoodNectar.setDirection(Servo.Direction.REVERSE);







    }
}


