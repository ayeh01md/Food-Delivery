/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class OrdersManager {
    //Creates a new arraylist
    ArrayList<Orders> ordersList = new ArrayList<Orders>();

    public OrdersManager() {
        //Establishing connection to database and retrieving values based on SQL
        try {
            String url = "jdbc:derby://localhost:1527/RestaurantDB;user=nbuser;password=nbuser";
            Connection con = DriverManager.getConnection(url);
            String query1 = "select customerid,orderid,ordertb.foodid,foodprice,preptime from ordertb, foodtb where ordertb.FOODID=foodtb.FOODID order by customerid, orderid";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query1);
            Orders order;

            //Entering fields into the ArrayList
            while (rs.next()) {
                order = new Orders(rs.getInt("CustomerID"), rs.getInt("OrderID"), rs.getInt("FoodID"), rs.getDouble("FoodPrice"), rs.getInt("PrepTime"));
                ordersList.add(order);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Unsuccessful attempt at obtaining values from database ");
        }
    }

    //Accessor method for ArrayList
    public ArrayList<Orders> getAllFields() {
        return ordersList;
    }

}
