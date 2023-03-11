/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgData;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Text {
    
    //Main Screen help message 
    public String Help1()
    {
        String s="";
        s=s+"Click on the Orders button to go to the Orders interface \n\n";
        s=s+"Click on the Customers button to go to the Customers interface \n\n";
        s=s+"Click on the Exit button to close the program";
        return s;
    }
    
    //Displays Information about the Program
    public String About()
    {
        String s="";
        s=s+"This program is designed to help organize the delivery of orders and information of customers for Timpano\n";
        s=s+"Created by Anwell Ho";
        return s;
    }
    
    //OrderUI help message
    public String Help2()
    {
        String s="";
        s=s+"Fill out all of the text fields and then click on the Insert button to insert a new record into the database\n\n";
        s=s+"Click on the Delete button and enter the OrderID to delete an exisiting record\n\n";
        s=s+"Click on the Back button to go back to Main Screen";
        return s;
    }
    
    //CustomerUI help message
    public String Help3()
    {
        String s="";
        s=s+"Fill out the text fields and click on the Insert button to insert a new record into the database\n\n";
        s=s+"Click on a record first, edit the record, then click the Update button to update an exisiting record\n\n";
        s=s+"Click on the Next button to go to the next Customer Interface\n\n";
        s=s+"Click on the Back button to go back to Main Screen";
        return s;
    }
    
    //Customer2UI help message
    public String Help4()
    {
        String s="";
        s=s+"Enter a CustomerID and click on the Search button to display orders of the customer in the table\n\n";
        s=s+"Click on the Total Cost button to calculate the total cost of the orders of a customerd\n\n";
        s=s+"Click on the Total Prep Time button to calculate the total preparation time of the orderse\n\n";
        s=s+"Click on the Back button to go to previous Customer Interface\n\n";
        s=s+"Click on Main Menu to go to the Main Menu";
        return s;
    }
    
    //Order2UI help message
    public String Help5()
    {
        String s="";
        s=s+"Click on a value on the table to see a remaining time of an order \n\n";
        s=s+"Click on the Stop button to stop the timer if an order is completed or switching to another value\n\n";
        s=s+"Click on the Back button to go to previous Order Interface\n\n";
        s=s+"Click on Main Menu to go to the Main Menu";
        return s;
    }
    
    //Checks if a number is entered correctly and returns a boolean true if correct
    public boolean CheckNum(String s)
    {
        boolean Num=true;
        //Check if fields are empty
        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all fields");
            Num=false;
        }
        //Check if value is a number
        else if(!s.matches("[0-9]+"))
        {
            JOptionPane.showMessageDialog(null,"Please enter an ID that contains numbers only");
            Num=false;
        }
        return Num;
    }
    
    //Checks if a string is entered correctly and returns a boolean true if correct
    public boolean CheckString(String s)
    {
        boolean String=true;
        //Check if fields are empty
        if(s.isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Please enter all fields");
             String=false;
        }
        //Check if value is a string
        else if(!s.matches("[a-z A-Z]+"))
        {
            JOptionPane.showMessageDialog(null,"Please enter a valid name");
            String=false;
        }
        return String;
    }
    
    //Checks if a phone number is entered correctly and returns a boolean true if correct
    public boolean CheckPhone(String s)
    {
        boolean Phone=true;
        //Check if fields are empty
        if (s.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter all fields");
            Phone=false;
        }
        //Check if value is an int and has a length of 10
        else if(!s.matches("[0-9]+") || !(s.length() == 10))
        {
            JOptionPane.showMessageDialog(null,"Please enter a valid phone number");
            Phone=false;
        }
        return Phone;
    }
    
}
