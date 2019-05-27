package sensor;

import java.awt.Color;

public class PressureSensorAdapter implements SensorAdapter{
	
	private PressureSensor adaptee;

	public PressureSensorAdapter(PressureSensor p) {
		this.adaptee = p;
	}
	
	//PressureSensor p = new PressureSensor();

	@Override
	public String getReport() {
		return adaptee.getReport();
	}
	
	//search for value only once 
	@Override
	public Double getValue() {
		return adaptee.readValue();
	}

	@Override
	public String getType() {
		return adaptee.getSensorName();
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
		return 7;
	}
	
	

}
