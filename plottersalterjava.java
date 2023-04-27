package project2;
import java.awt.Color;
import java.util.Arrays;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class plottersalterjava {

	public static void main(String[] args) {
		 double[] data = {1.0, 3.0, 5.0, 7.0, 9.0};

	        plot(data);
	        salt(data, 2);

	       
	        
	        plot(data);
	        smooth(data, 4);
	        plot(data);
	    }
	    
	    public static void plot(double[] data) {
	        XYSeries series = new XYSeries("Data");
	        for (int i = 0; i < data.length; i++) {
	            series.add(i, data[i]);
	        }
	        XYSeriesCollection dataset = new XYSeriesCollection(series);

	        JFreeChart chart = ChartFactory.createXYLineChart(
	                "Data Plot", 
	                "X", "Y", 
	                dataset 
	        );

	        chart.setBackgroundPaint(Color.gray);
	        XYPlot plot = chart.getXYPlot();
	        plot.setBackgroundPaint(Color.white);
	        plot.setDomainGridlinePaint(Color.black);
	        plot.setRangeGridlinePaint(Color.black);
	        
	        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	        renderer.setSeriesLinesVisible(0, true);
	        renderer.setSeriesShapesVisible(0, false);
	        plot.setRenderer(renderer);

	        JFrame frame = new JFrame("Plot");
	        ChartPanel chartPanel = new ChartPanel(chart);
	        frame.setContentPane(chartPanel);
	        frame.pack();
	        frame.setVisible(true);
	    }
	    
	    public static void salt(double[] data, double amount) {
	        for (int i = 0; i < data.length; i++) {
	            data[i] += amount;
	        }
	    }
	    
	    public static void smooth(double[] data, int windowSize) {
	        double[] smoothData = new double[data.length];
	        for (int i = 0; i < data.length; i++) {
	            double sum = 0;
	            int count = 0;
	            for (int j = Math.max(0, i - windowSize); j < Math.min(data.length, i + windowSize + 1); j++) {
	                sum += data[j];
	                count++;
	            }
	            smoothData[i] = sum / count;
	        }
	        for (int i = 0; i < data.length; i++) {
	            data[i] = smoothData[i];
	        }
	    }
	}

