package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Dcode (Blocks to Java)")
public class Dcode extends LinearOpMode {

    private DcMotor shrm;
    private Servo rs;
    private Servo shls;
    private Servo shrs;
    private Servo ls;
    private DcMotor shlm;
    private DcMotor intake;

    /**
     * This sample contains the bare minimum Blocks for any regular OpMode. The 3 blue
     * Comment Blocks show where to place Initialization code (runs once, after touching the
     * DS INIT button, and before touching the DS Start arrow), Run code (runs once, after
     * touching Start), and Loop code (runs repeatedly while the OpMode is active, namely not
     * Stopped).
     */
    @Override
    public void runOpMode() {
        double shspeed;

        shrm = hardwareMap.get(DcMotor.class, "shrm");
        rs = hardwareMap.get(Servo.class, "rs");
        shls = hardwareMap.get(Servo.class, "shls");
        shrs = hardwareMap.get(Servo.class, "shrs");
        ls = hardwareMap.get(Servo.class, "ls");
        shlm = hardwareMap.get(DcMotor.class, "shlm");
        intake = hardwareMap.get(DcMotor.class, "intake");

        // Put initialization blocks here.
        shrm.setDirection(DcMotor.Direction.REVERSE);
        rs.setDirection(Servo.Direction.REVERSE);
        shls.setPosition(0.1);
        shrs.setPosition(0.1);
        ls.setPosition(0);
        rs.setPosition(0);
        waitForStart();
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                if (gamepad1.y) {
                    shspeed = 0.8;
                    shls.setPosition(0.055);
                    shrs.setPosition(0.055);
                }
                if (gamepad1.b) {
                    shspeed = 0.8;
                    shls.setPosition(0.1);
                    shrs.setPosition(0.1);
                }
                if (gamepad1.a) {
                    shspeed = 1;
                    shls.setPosition(0.1);
                    shrs.setPosition(0.1);
                }
                if (gamepad1.y || gamepad1.b || gamepad1.a) {
                    shlm.setPower(shspeed);
                    shrm.setPower(shspeed);
                } else {
                    shlm.setPower(0);
                    shrm.setPower(0);
                    shls.setPosition(0.1);
                    shrs.setPosition(0.1);
                }
                if (gamepad1.left_bumper) {
                    rs.setPosition(0.3);
                } else {
                    rs.setPosition(0);
                }
                if (gamepad1.right_bumper) {
                    ls.setPosition(0.3);
                } else {
                    ls.setPosition(0);
                }
                if (gamepad1.dpad_up) {
                    intake.setPower(1);
                } else {
                    intake.setPower(0);
                }
                if (gamepad1.dpad_down) {
                    intake.setPower(-1);
                } else {
                    intake.setPower(0);
                }
                telemetry.update();
            }
        }
    }
}
