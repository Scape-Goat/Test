package frc.robot.Frames;


import java.util.ArrayList;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.SparkMax;




public final class Drive<T>{
    ArrayList<TalonSRX> srxMotors;
    ArrayList<SparkMax> sparkMotors;

    public Drive(ArrayList<T> motors) {
            try {
                srxMotors = (ArrayList<TalonSRX>)motors;
            } catch (Exception srxE) {
                try {
                    sparkMotors = (ArrayList<SparkMax>)motors;
                } catch (Exception sparkE) {
                    System.out.println("Inputted Array is of an invalid type");
                }
            }
        
    }


    public void forward(double speed){
        if(srxMotors != null){
            for (TalonSRX motor: srxMotors) {
                motor.set(ControlMode.PercentOutput, Math.abs(speed));
            }
        }
        else if(sparkMotors != null){
            for (SparkMax motor: sparkMotors) {
                motor.set(Math.abs(speed));
            }
        }
    }

    public void backward(double speed){
        if(srxMotors != null){
            for (TalonSRX motor: srxMotors) {
                motor.set(ControlMode.PercentOutput, -Math.abs(speed));
            }
        }
        else if(sparkMotors != null){
            for (SparkMax motor: sparkMotors) {
                motor.set(-Math.abs(speed));
            }
        }
    }
    public void stop(){
        if(srxMotors != null){
            for (TalonSRX motor: srxMotors) {
                motor.set(ControlMode.PercentOutput, 0);
            }
        }
        else if(sparkMotors != null){
            for (SparkMax motor: sparkMotors) {
                motor.set(0);
            }
        }
    }

    public void driver(double leftStickValue, double rightStickValue){
        if(srxMotors != null){
            for(int i = 0; i<srxMotors.size(); i++){
                if(i<srxMotors.size()/2){
                    if(Math.abs(leftStickValue)>.2)
                        srxMotors.get(i).set(ControlMode.PercentOutput, leftStickValue);
                    else{
                        srxMotors.get(i).set(ControlMode.PercentOutput, 0);
                    }
                }
                else{
                    if(Math.abs(rightStickValue)>.2)
                        srxMotors.get(i).set(ControlMode.PercentOutput, rightStickValue);
                    else{
                        srxMotors.get(i).set(ControlMode.PercentOutput, 0);
                    }
                }
            }
        }
        else if(sparkMotors != null){
            for(int i = 0; i<sparkMotors.size(); i++){
                if(i<sparkMotors.size()/2){
                    if(Math.abs(leftStickValue)>.2)
                        sparkMotors.get(i).set( leftStickValue);
                    else{
                        sparkMotors.get(i).set( 0);
                    }
                }
                else{
                    if(Math.abs(rightStickValue)>.2)
                        sparkMotors.get(i).set(rightStickValue);
                    else{
                        sparkMotors.get(i).set(0);
                    }
                }
            }
        }
    }

}