package org.firstinspires.ftc.teamcode.robot_opmode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class Auto_terminal_blue extends LinearOpMode {
    @Override
    public void runOpMode() {

        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");

        DcMotor lift = hardwareMap.dcMotor.get("liftMotor");

        Servo claw = hardwareMap.get(Servo.class, "clawMotor");

        int CLAW_OPEN = 0;
        int CLAW_CLOSED = 1;

        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);

        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift.setPower(1);

        waitForStart();
        if (opModeIsActive()) // for a2
        {
            //move left
            motorFrontLeft.setPower(-1);
            motorBackLeft.setPower(1);
            motorBackRight.setPower(-1);
            motorFrontRight.setPower(1);
            sleep(4000);

            motorFrontLeft.setPower(0);
            motorBackLeft.setPower(0);
            motorBackRight.setPower(0);
            motorFrontRight.setPower(0);
        }
    }
}
