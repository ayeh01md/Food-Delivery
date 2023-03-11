
package pkgData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class TimerManager {
    //Creates a new arraylist
    ArrayList<OrderTime> TimeList = new ArrayList<OrderTime>();
    
    public TimerManager(){
        //Establishing connection to database and retrieving values based on SQL
        try {
            String url = "jdbc:derby://localhost:1527/RestaurantDB;user=nbuser;password=nbuser";
            Connection con = DriverManager.getConnection(url);
            String query1 = "select orderid,foodname,Preptime, ordertime from ordertb, foodtb where ordertb.FOODID=foodtb.FOODID";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            
            //Entering fields into the ArrayList
            OrderTime time;
            while (rs.next()) {
                time = new OrderTime(rs.getInt("OrderID"), rs.getString("Foodname"),rs.getInt("Preptime"), rs.getTime("OrderTime"));
                TimeList.add(time);
            }
        }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unsuccessful attempt at obtaining values from database ");
        }
    }
    //Accessor method for ArrayList
    public ArrayList<OrderTime> getAllFields() {
        return TimeList;
    }
    
    
    //Returns int value of the time in seconds
    //Accepts String form of a Date type
    public int CalculateTime(String m)
    {
        //Calculates the time in seconds of a time in the day
        int value=0;
        String [] part = m.split(":");
        int Hour=Integer.parseInt(part[0]);
        int Minute=Integer.parseInt(part[1]);
        int Second=Integer.parseInt(part[2]);
        
        //Adds the hours, minutes and seconds together in seconds
        value= value+(Hour*3600) + (Minute*60) + Second;
        return value;
    }  
}
    