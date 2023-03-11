/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgData;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author User
 */
public class OrderTime {
    
    private int OrderID;
    private String Foodname;
    private Time time;
    private int Preptime;
    
    public OrderTime(int OrderID, String Foodname, int Ptime, Time time)
    {
        this.OrderID=OrderID;
        this.Foodname=Foodname;
        this.Preptime=Ptime;
        this.time=time;
    }
    
    
    public int getOrderID()
    {
        return OrderID;
    }
    
    public String getFoodname()
    {
        return Foodname;
    }
    
    public int getPrepTime()
    {
        return Preptime;
    }
    
    public Time getTime()
    {
        return time;
    }
}
