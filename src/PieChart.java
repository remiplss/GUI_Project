
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;




public class PieChart extends JFrame {

    private static final long serialVersionUID = 1L;
    Connection con1;
    PreparedStatement insert;

    public PieChart(String applicationTitle, String chartTitle) {
        super(applicationTitle);
        // This will create the dataset
        PieDataset dataset = createDataset();
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);

    }

    /**
     * Creates a sample dataset
     */
    private  PieDataset createDataset() {
        
         DefaultPieDataset result = new DefaultPieDataset();
         ArrayList<String> jobList = new ArrayList<>();
         try{   
        //Import Job values from SQL//
            
            DataSource dataSource = new DataSource();
            con1 = dataSource.createConnection();
         
            
            String query = "SELECT * FROM job"; //query
            Statement st= con1.createStatement();//get the values from job
            
            ResultSet rs = st.executeQuery(query); //get the result
            // iterate through the java resultset
            do{
                rs.next();//next row
             //   txtJob.addItem(rs.getString(1));//add the job to the comboBox
             jobList.add(rs.getString(1)); //Put all the job in an ArrayList
                
             }while(!rs.isLast());//While we are not at the end of the table
            
            for(int i = 1;i<=jobList.size();i++) //for all the job that exist
            {
                System.out.println("int  = "/*+rs2.getInt(i)*/);
           String query2 = "SELECT COUNT(*) FROM jobseekerlist WHERE Job= '"+jobList.get(i-1) + "'"; //we count the number of applicants per Job
            Statement st2 = con1.createStatement();// = con1.prepareStatement(query2);
            //st2.setString(1,jobList.get(i));//We put the curent job in the query
            
             ResultSet rs2 = st2.executeQuery(query2); //get the result
             
             do{
                rs2.next();//next row
         
            result.setValue(jobList.get(i-1), rs2.getInt(1));// we put it in the pie chart
                
             }while(!rs2.isLast());//While we are not at the end of the table
            
            }
        }
        //Exceptions//
        catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println(result);
        return result;

    }

    /**
     * Creates a chart
     */
    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(
            title,                  // chart title
            dataset,                // data
            true,                   // include legend
            true,
            false
        );

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(290);
        plot.setForegroundAlpha(0.5f);
        return chart;

    }
}