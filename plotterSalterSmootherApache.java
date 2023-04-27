package project2;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.apache.commons.*;

public class plotterSalterSmootherApache {
    
    public static void main(String[] args) {
        
        // create some sample data
        List<Double> xValues = new ArrayList<>();
        List<Double> yValues = new ArrayList<>();
        for (double x = -10.0; x <= 10.0; x += 0.1) {
            double y = Math.sin(x) + 0.5 * Math.random() - 0.25;
            xValues.add(x);
            yValues.add(y);
        }
        
        // create the dataset
        XYDataset dataset = createDataset(xValues, yValues);
        
        // create the chart
        JFreeChart chart = createChart(dataset);
        
        // create the chart panel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(500, 300));
        
        // create the frame
        JFrame frame = new JFrame("Plotter Salter Smoother");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
        
    }
    
    // create the dataset
    public static XYDataset createDataset(List<Double> xValues, List<Double> yValues) {
        XYSeries series = new XYSeries("Data");
        for (int i = 0; i < xValues.size(); i++) {
            double x = xValues.get(i);
            double y = yValues.get(i);
            series.add(x, y);
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }
    
    // create the chart
    public static JFreeChart createChart(XYDataset dataset) {
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Plotter Salter Smoother", // chart title
            "X", // x-axis label
            "Y", // y-axis label
            dataset // data
        );
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShapesFilled(0, true);
        plot.setRenderer(renderer);
        NumberAxis xAxis = (NumberAxis) plot.getDomainAxis();
        xAxis.setAutoRangeIncludesZero(false);
        return chart;
    }
}