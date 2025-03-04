package org.firstinspires.ftc.teamcode.robot_opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.DriveConstants;
import org.firstinspires.ftc.teamcode.drive.RobotHardwareMap;

@TeleOp
public class Drive extends OpMode
{
    private int targetPosition = 0;
    private int HIGH_POSITION = 4000;
    private int MEDIUM_POSITION = 2000;
    private int INTAKE_POSITION = 0;

    double CLAW_OPEN = 0;
    double CLAW_CLOSED = 0.4;
    public enum LiftState //what if you don't want to LOOK FOR GAME ELEMENTS, but, for example, want to make the distance servo DANCE? expand it
    {
        LOOK_FOR_GAME_ELEMENTS
    }
    public void init()
    {
        // Declare our motors
        // Make sure your ID's match your configuration

        //RobotHardwareMap hM = new RobotHardwareMap();

        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests

        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft");
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight");
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight");

        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        DcMotor lift = hardwareMap.dcMotor.get("liftMotor");

        lift.setTargetPosition(INTAKE_POSITION);
        lift.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift.setPower(1);
        //double a = 0;
        Servo claw = hardwareMap.get(Servo.class, "clawMotor");
        //claw.setDirection(Servo.Direction.REVERSE);
    }
    public void loop() {
        /*
        if (gamepad1.a) {
            targetPosition = HIGH_POSITION;
        // Declare our motors
        // Make sure your ID's match your configuration

        //RobotHardwareMap hM = new RobotHardwareMap();

        // Reverse the right side motors
        // Reverse left motors if you are using NeveRests



        //double a = 0;

        Servo claw = hardwareMap.get(Servo.class, "clawMotor");
        //claw.setDirection(Servo.Direction.REVERSE);

        waitForStart();

        if (isStopRequested()) return;

        boolean changed_trigger = false; //Outside of loop()

        while (opModeIsActive())
        {
            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
            double rx = gamepad1.right_stick_x;

            double max_speed = gamepad1.right_bumper?0.5:1;
            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio, but only when
            // at least one is out of the range [-1, 1]
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

            double frontLeftPower = (y + x + rx) / denominator * max_speed;
            double backLeftPower = (y - x + rx) / denominator * max_speed;
            double frontRightPower = (y - x - rx) / denominator * max_speed;
            double backRightPower = (y + x - rx) / denominator * max_speed;

            if(gamepad1.dpad_up) targetPosition++;
            if(gamepad1.dpad_down && targetPosition>0) targetPosition--;

            if(gamepad1.a) //bottom
            {
                claw.setPosition(CLAW_OPEN);
                targetPosition = INTAKE_POSITION;
            }

            if(gamepad1.y) // up
            {
                claw.setPosition(CLAW_CLOSED); //close claw
                targetPosition = HIGH_POSITION;
            }

            if(gamepad1.x) // med
            {
                claw.setPosition(CLAW_CLOSED); //close claw
                targetPosition=MEDIUM_POSITION;
            }


            /*if(gamepad1.dpad_right) {a+=0.10; sleep(100);};
            if(gamepad1.dpad_left) {a-=0.10; sleep(100);};
            claw.setPosition(a);

            //telemetry.addData("set:", a);
            // toggle for the trigger
            if((gamepad1.right_trigger >= 0.7) && !changed_trigger)
            {
                if(claw.getPosition() <= CLAW_CLOSED+0.1) claw.setPosition(CLAW_OPEN);
                else claw.setPosition(CLAW_CLOSED);
                changed_trigger = true;
            } else if(!(gamepad1.right_trigger >= 0.7)) changed_trigger = false;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);

            lift.setTargetPosition(targetPosition);

            telemetry.addData("lift_target:", targetPosition);
            telemetry.addData("lift_current:", lift.getCurrentPosition());
            telemetry.addData("claw_current:", claw.getPosition());
            telemetry.update();

            motorBackLeft.setMode(DcMotor.RunMode.);
            //motorBackLeft.get

            //hM.leftFront.setPower(frontLeftPower);
            //hM.leftRear.setPower(backLeftPower);
            //hM.rightFront.setPower(frontRightPower);
            //hM.rightRear.setPower(backRightPower);

        }
        */
    }
}