package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 *created by Scott on 1/6/19
 */

public class Hardware_11 {
    public DcMotor rightMotor = null;
    public DcMotor leftMotor = null;
    public Servo armServo = null;
    public Servo leftServo = null;
    public Servo rightServo = null;
    HardwareMap hwMap = null;
    private ElapsedTime period  = new ElapsedTime();

    // Constructor
    public Hardware_11(){

    }
    public void init(HardwareMap ahwMap){
        //Save reference to Hardware Map
        hwMap = ahwMap;

        //Define and Initialize Motors
        leftMotor = hwMap.dcMotor.get("left_drive");
        rightMotor = hwMap.dcMotor.get("right_drive");
        leftMotor.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        rightMotor.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        //Set all motors to zero power
        leftMotor.setPower(0);
        rightMotor.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //Servos
        leftServo  = hwMap.get(Servo.class, "left");
        rightServo = hwMap.get(Servo.class, "right");
        armServo = hwMap.get(Servo.class, "arm");
        armServo.setPosition(0);
        leftServo.setPosition(.5);
        rightServo.setPosition(.5);



    }
    /***

     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular

     * periodic tick.  This is used to compensate for varying processing times for each cycle.

     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.

     * @param periodMs  Length of wait cycle in mSec.

     */

    public void waitForTick(long periodMs) {


        long remaining = periodMs - (long) period.milliseconds();


        // sleep for the remaining portion of the regular cycle period.

        if (remaining > 0) {

            try {

                Thread.sleep(remaining);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

            }

        }


        // Reset the cycle clock for the next pass.

        period.reset();
    }



}



