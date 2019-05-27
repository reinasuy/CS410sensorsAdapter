package sensor;

import java.awt.Color;

public class TemperatureSensorAdapter implements SensorAdapter{
	
	private TemperatureSensor adaptee;
	
	public TemperatureSensorAdapter(TemperatureSensor t) {
		this.adaptee = t;
	}
	
	//TemperatureSensor t = new TemperatureSensor();

	@Override
	public String getReport() {
		return adaptee.getTempReport();
	}

	@Override
	public Double getValue() {
		return adaptee.senseTemperature();
	}

	@Override
	public String getType() {
		return adaptee.getSensorType();
	}
	
	@Override
	public Color getColor() {
		Color c = null;
		if(getReport().equals("OK")){
			c = c.green;
		}else if(getReport().equals("CRITICAL")) {
			c = c.yellow;
		}else if(getReport().equals("DANGER")){
			c = c.red;
		}
		
		return c;
	}

	
	@Override
	public int getMax() {
		return 301;
	}
	
	

}
