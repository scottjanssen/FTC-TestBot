package org.firstinspires.ftc.teamcode;




import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;



/**
 *created by Scott on 1/6/19
 */

@TeleOp(name = "Main Teleop", group = "Iterative Opmode")

//@Disabled
public class FirstTeleop extends OpMode {
    //Declare opmode members
    Hardware_11 robot = new Hardware_11();
    ElapsedTime runtime = new ElapsedTime();
    @Override
    public void init() {
        /*
         * Code to run ONCE when the driver hits INIT
         * Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
    }
    @Override
    public void init_loop() {
        /*
         * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
         */
    }
    @Override
    public void start() {
        /*
         * Code to run ONCE when the driver hits PLAY
         */
        runtime.reset();
    }
    @Override
    public void loop(){
        double leftPower;
        double rightPower;
        // Set up tank mode
        leftPower = -gamepad1.left_stick_y;
        rightPower = -gamepad1.right_stick_y;
        //Set robot power
        robot.leftMotor.setPower(leftPower);
        robot.rightMotor.setPower(rightPower);
        if (gamepad1.x){
            robot.leftServo.setPosition(100);
        }
        else {
            robot.leftServo.setPosition(0);
        }
        if (gamepad1.b){
            robot.rightServo.setPosition(100);
        }
        else {
            robot.rightServo.setPosition(0);
        }
        //Telemetry
        telemetry.addData("left",  "%.2f", leftPower);
        telemetry.addData("right", "%.2f", rightPower);
        telemetry.addData("Status", "Run Time: " + runtime.toString());
    }
    @Override
    public void stop(){
        /*
         * Code to run ONCE after the driver hits STOP
         */
    }
}
