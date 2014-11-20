package de.normannexo.ev3;

import java.util.ArrayList;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.SensorModes;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class IRSensor {
	private SampleProvider sampler;
	private SensorModes sensormodes;

	
	
	public IRSensor(String strPort, String strMode) {
		Port port = LocalEV3.get().getPort(strPort);
		sensormodes = new EV3IRSensor(port);
		sampler = sensormodes.getMode(strMode);
		
	}
	
	public int getSampleSize() {
		return sampler.sampleSize();
	
	}
	
	public float fetchLastSample() {
		float fSamples[] = new float[sampler.sampleSize()];
		sampler.fetchSample(fSamples, 0);
		float fSample = fSamples[0];
		return fSample;
	}
	
	public ArrayList<String> getAvailableModes() {
		return sensormodes.getAvailableModes();
	}

}
