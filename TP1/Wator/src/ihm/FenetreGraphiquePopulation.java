/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import modele.Poisson;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author Remynoschka
 */
public class FenetreGraphiquePopulation extends ApplicationFrame implements Observer {
    /** The time series data. */
    private TimeSeries poissons = new TimeSeries("Poissons", Millisecond.class);
    private TimeSeries requins=  new TimeSeries("Requins", Millisecond.class);
    /**
     * Constructs a new dynamic chart application.
     *
     * @param title the frame title.
     */
    public FenetreGraphiquePopulation(final String title) {
        super(title);
        final TimeSeriesCollection dataset = new TimeSeriesCollection(this.poissons);
        dataset.addSeries(this.requins);
        final JFreeChart chart = createChart(dataset);
        chart.setBackgroundPaint(Color.LIGHT_GRAY);
        final JPanel content = new JPanel(new BorderLayout());
        final ChartPanel chartPanel = new ChartPanel(chart);
        content.add(chartPanel);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
        setContentPane(content);
        this.setSize(800, 600);
        this.setVisible(true);
    }
    private JFreeChart createChart(final XYDataset dataset) {
        final JFreeChart result = ChartFactory.createTimeSeriesChart(
                this.getTitle(),
                "Temps",
                "Population",
                dataset,
                true,
                true,
                false
                );
        final XYPlot plot = result.getXYPlot();
        plot.setBackgroundPaint(new Color(0xffffe0));
        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.lightGray);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.lightGray);
        ValueAxis xaxis = plot.getDomainAxis();
        xaxis.setAutoRange(true);
        xaxis.setFixedAutoRange(60000.0); // 60 seconds
        xaxis.setVerticalTickLabels(true);
        ValueAxis yaxis = plot.getRangeAxis();
        yaxis.setRange(0.0, 1000.0);
        return result;
    }

    /**
     * Add data to the chart
     * @param fish
     * @param shark 
     */
    public void addData(int fish, int shark) {
        Millisecond s = new Millisecond();
        this.poissons.add(s, fish);
        this.requins.add(s, shark);
    }

    @Override
    public void update(Observable o, Object arg) {
        addData(Poisson.population, modele.Requin.population);
    }
} 