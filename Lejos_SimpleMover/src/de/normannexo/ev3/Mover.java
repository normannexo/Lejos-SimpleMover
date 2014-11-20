package de.normannexo.ev3;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.Port;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.objectdetection.Feature;
import lejos.robotics.objectdetection.FeatureDetector;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.utility.Delay;

public class Mover implements FeatureListener{
	public static int COMPLETE_TURN = 1900;
	
	private RegulatedMotor mLeft;
	private RegulatedMotor mRight;
	
	public Mover(Port pLeft, Port pRight) {
		mLeft = new EV3LargeRegulatedMotor(pLeft);
		mRight = new EV3LargeRegulatedMotor(pRight);
	}
	
	public void rotate(int angle) {
		mLeft.rotate(angle, true);
		mRight.rotate(angle, false);
	}
	
	public void setSpeed(int lSpeed, int rSpeed) {
		mLeft.setSpeed(lSpeed);
		mRight.setSpeed(rSpeed);
	}
	
	public void setSpeed(int speed) {
		mLeft.setSpeed(speed);
		mRight.setSpeed(speed);
	}
	
	public void turnRight() {
		mLeft.forward();
		mRight.backward();
	}
	
	public void go() {
		mLeft.forward();
		mRight.forward();
	}
	
	public void back() {
		mLeft.backward();
		mRight.backward();
	}
	
	public void go(int angle) {
		mLeft.rotate(angle);
		mRight.rotate(angle);
	}
	
	
	public void turnRight(int angle) {
		mLeft.rotate(angle, true);
		mRight.rotate(- angle, false);
	}
	
	public void turnLeft(int angle) {
		mLeft.rotate(-angle, true);
		mRight.rotate(angle,false);
	}
	
	public void turnLeft() {
		mLeft.backward();
		mRight.forward();
	}
	
	
	public void stop(boolean immediate) {
		mLeft.stop(immediate);
		mRight.stop(immediate);
	}
	
	public void close() {
		mLeft.close();
		mRight.close();
	}

	@Override
	public void featureDetected(Feature feature, FeatureDetector detector) {
		System.out.println("" + feature.getRangeReading().getRange());
		this.objectDetectedAction();
		
	}
	
	public void objectDetectedAction() {
		this.stop(true);
		this.rotate(-500);
		this.turnLeft(COMPLETE_TURN / 4);
		this.go();
	}
	
	

}
