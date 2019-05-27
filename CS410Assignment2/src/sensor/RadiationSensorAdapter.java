package sensor;

import java.awt.Color;

public class RadiationSensorAdapter implements SensorAdapter{
	
	private RadiationSensor adaptee;
	
	public RadiationSensorAdapter(RadiationSensor r) {
		this.adaptee = r;
	}
	
	//RadiationSensor r = new RadiationSensor();

	@Override
	public String getReport() {
		return adaptee.getStatusInfo();
	}

	@Override
	public Double getValue() {
		return adaptee.getRadiationValue();
	}

	@Override
	public String getType() {
		return adaptee.getName();
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
		return 5;
	}
	
	

}
