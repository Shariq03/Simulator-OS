import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
 
public class Piechart_AWT extends ApplicationFrame 
{
   public Piechart_AWT( String title,double A[] ) 
   {
      super( title ); 
      setContentPane(createDemoPanel(A ));
   }
   private static PieDataset createDataset(double A[] ) 
   {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "FIFO" , A[0] );  
      dataset.setValue( "LRU" , A[1] );   
      dataset.setValue( "SC" , A[2] );    
      dataset.setValue( "OPTIMAL" , A[3] );  
      return dataset;         
   }
   private static JFreeChart createChart( PieDataset dataset )
   {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Pie-Chart",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);

      return chart;
   }
   public static JPanel createDemoPanel( double A[])
   {
      JFreeChart chart = createChart(createDataset( A ) );  
      return new ChartPanel( chart ); 
   }
   public static void main(double A[] )
   {
      Piechart_AWT demo = new Piechart_AWT( "PageFault Algorithm",A );  
      demo.setSize( 560 , 367 );    
      RefineryUtilities.centerFrameOnScreen( demo );    
      demo.setVisible( true ); 
   }
}