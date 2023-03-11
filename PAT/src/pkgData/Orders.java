/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgData;

/**
 *
 * @author User
 */
public class Orders {
    private int CustomerID;
    private int OrderID;
    private int FoodID;
    private Double FoodPrice;
    private int PrepTime;
    
    public Orders(int CustomerID, int OrderID, int FoodID, Double FoodPrice, int PrepTime)
    {
        this.CustomerID=CustomerID;
        this.OrderID=OrderID;
        this.FoodID=FoodID;
        this.FoodPrice=FoodPrice;
        this.PrepTime=PrepTime;
    }
    
    public int getCustomerID()
    {
        return CustomerID;
    }
    
    public int getOrderID()
    {
        return OrderID;
    }
    
    public int getFoodID()
    {
        return FoodID;
    }
    public Double getFoodPrice()
    {
        return FoodPrice;
    }
    
    public int getPrepTime()
    {
        return PrepTime;
    }
}
