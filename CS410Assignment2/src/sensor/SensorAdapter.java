package sensor;

import java.awt.Color;

public interface SensorAdapter {
	
	public String getReport();
	public Double getValue();
	public String getType();
	public Color getColor();
	public int getMax();
	
	
}
