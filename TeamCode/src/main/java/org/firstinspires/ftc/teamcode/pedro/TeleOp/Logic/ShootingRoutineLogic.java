package org.firstinspires.ftc.teamcode.pedro.TeleOp.Logic;

import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.pedro.TeleOp.HwMap;
import org.firstinspires.ftc.teamcode.pedro.TeleOp.RobotStates;

public class ShootingRoutineLogic {


    private RobotStates robotStates;

    HwMap hwMap = new HwMap();

    public double placeholder = 0;

    public double curVelocityPollenShooter = hwMap.PollenShooter.getVelocity();

    public double PollenShooterTargetVelocity = 1700;

    public ElapsedTime stateTimer = new ElapsedTime();

    public ElapsedTime PollenShooterTimer = new ElapsedTime();






    private void init(HwMap hwMap){

        robotStates = RobotStates.IDLE;
          hwMap.gatePollen.setPosition(hwMap.gatePollenClosePos);
          hwMap.gateNectar.setPosition(hwMap.gateNectarClosePos);

    }



    public void update(){
        switch(robotStates) {
            case IDLE:
                if(placeholder == 0){

                    hwMap.gatePollen.setPosition(hwMap.gatePollenOpenPos);
                    hwMap.gateNectar.setPosition(hwMap.gateNectarOpenPos);
                    hwMap.PollenShooter.setVelocity(hwMap.PollenShooterTargetVelocity);
                    robotStates = RobotStates.PollenTurretShooterActive;
                    PollenShooterTimer.reset();

                }
                break;
            case PollenTurretShooterActive:
                hwMap.PollenShooter.setVelocity(hwMap.PollenShooterTargetVelocity);
                if(curVelocityPollenShooter<hwMap.PollenShooterTargetVelocity || PollenShooterTimer.milliseconds()>500){





                }


        }



    }

}
