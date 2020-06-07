/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

/**
 * Classe qui définit un camembert 
 * du nombre de places utilisés dans les salle de cours.
 * 
 * @author Tony
 * 
 * Ressource utilisée : https://www.tutorialspoint.com/jfreechart/jfreechart_pie_chart.htm
 */

public class Statistique extends ApplicationFrame {
    
    public Statistique(String title) {
       super(title); 
       setContentPane(createDemoPanel());
    }
    
    private static PieDataset createDataset() {
       DefaultPieDataset dataset = new DefaultPieDataset();
       dataset.setValue("Places utilisées", new Double(5));  
       dataset.setValue("Places libres", new Double(95));
       return dataset;         
    }

    private static JFreeChart createChart(PieDataset dataset) {
       JFreeChart chart = ChartFactory.createPieChart(      
          "% places utilisés des salles de cours",   // chart title 
          dataset,          // data    
          true,             // include legend   
          true, 
          false);

       return chart;
    }

    public static JPanel createDemoPanel() {
       JFreeChart chart = createChart(createDataset());  
       return new ChartPanel(chart); 
    }
}
