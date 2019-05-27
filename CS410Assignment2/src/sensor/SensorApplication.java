package sensor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicProgressBarUI;

public class SensorApplication extends JFrame {
	
	
	
	public class BarUI extends BasicProgressBarUI {
        private Rectangle r = new Rectangle();
    }
	
	Color c;
	JTextField textField; //
	JLabel rvLabel;
	String type;
	String report;
	String valueString;
	double value;
	int max;

	
	
	

	public SensorApplication() {
		
		setTitle("Sensor Tracker");
		setLayout(new GridLayout(3, 1));
		
		SensorAdapter[] sensors = {new PressureSensorAdapter(new PressureSensor()),
				new TemperatureSensorAdapter(new TemperatureSensor()), 
				new RadiationSensorAdapter(new RadiationSensor())};
		
		for (SensorAdapter sensors1 : sensors) {
            value= sensors1.getValue();
            valueString = Double.toString(value);
            type = sensors1.getType();
            report = sensors1.getReport();
            c = sensors1.getColor();
            max = sensors1.getMax();
            
            
            //progress bar with min and max values 
            JProgressBar pbar = new JProgressBar(0,max);
            
    		pbar.setUI(new BarUI());
    		pbar.setPreferredSize(new Dimension(180, 50));
    		pbar.setValue((int)value);
    		pbar.setBackground(Color.gray);
    		pbar.setForeground(c);
            pbar.setOpaque(true);
            
            JPanel Pnl = new JPanel();
            rvLabel = new JLabel(report+"-->"+valueString); //
    		Pnl.setBorder(new TitledBorder(type));
    		add(Pnl);
    		Pnl.add(pbar);
    		Pnl.add(rvLabel); 
            
        }
		
		setPreferredSize(new Dimension(600, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		pack();

		
	}

	public static void main(String[] args) {
		

		SensorApplication app = new SensorApplication();
		
	}

}
