package de.normannexo.ev3;

import lejos.hardware.Button;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RangeFinderAdaptor;
import lejos.robotics.objectdetection.FeatureListener;
import lejos.robotics.objectdetection.RangeFeatureDetector;
import lejos.utility.Delay;

public class SimpleMover {

 	public static void main(String[] args) {
 		Mover mover = new Mover(MotorPort.B, MotorPort.C);
 		EV3IRSensor infraredSensor = new EV3IRSensor(SensorPort.S4);
 		
 		RangeFinderAdaptor rangeFinderAdaptor = new RangeFinderAdaptor(infraredSensor.getDistanceMode());
        RangeFeatureDetector rangeFeatureDetector = new RangeFeatureDetector(rangeFinderAdaptor, 20, 250);
        rangeFeatureDetector.addListener(mover);
//      Delay.msDelay(5000);
        System.out.println("IR sensor loaded");
 		
 		
 		mover.setSpeed(300);
 		mover.go();
// 		Delay.msDelay(3000);
// 		mover.stop(true);
// 		mover.close();
// 		IRSensor ir = new IRSensor("S4", "Distance");
// 		for (String s : ir.getAvailableModes()) {
// 			System.out.println(s);
// 		}
// 		
// 		for (int i = 1; i <= 50; i++) {
// 			System.out.println("Sample " + i + ": " + ir.fetchLastSample());
// 			Delay.msDelay(200);
// 		}
// 		
// 		System.out.println("" + ir.getSampleSize());
 		Button.waitForAnyPress();
 		mover.stop(true);
 		infraredSensor.close();
 		mover.close();
 	}
 	
 	

}
