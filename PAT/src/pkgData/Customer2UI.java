/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgData;

//Imports
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author User
 */
public class Customer2UI extends javax.swing.JFrame {

    /**
     * Creates new form FoodUI
     */
    public Customer2UI() {
        initComponents();
        show_order();
    }
    
    //Instantiating Object
    Text obj=new Text();
    OrdersManager ord = new OrdersManager();
    
    //Display values obtained into table
    public void show_order() {
        //Obtains values and creates an array to store them
        ArrayList<Orders> list = ord.getAllFields();
        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        Object[] row = new Object[5];
        
        //Sorts each value into its respectable field and displays
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getCustomerID();
            row[1] = list.get(i).getOrderID();
            row[2] = list.get(i).getFoodID();
            row[3] = list.get(i).getFoodPrice();
            row[4] = list.get(i).getPrepTime();
            model.addRow(row);
        }
    }
    
    public void EstimatedTime()
    {
        // Calculates total time preparation
        int time = 0;
        for (int i = 0; i < tblOrders.getRowCount(); i++) {
            time = time + Integer.parseInt(tblOrders.getValueAt(i, 4).toString());
        }
        // Displays in Text field
        txfEstTime.setText(Integer.toString(time));
    }
    
    public void CustomerSearch()
    {
        // Searches and displays orders of a customer
        DefaultTableModel table = (DefaultTableModel) tblOrders.getModel();
        TableRowSorter<DefaultTableModel> ord = new TableRowSorter<DefaultTableModel>(table);
        tblOrders.setRowSorter(ord);
        
        //Checks and searches for the value entered in text field in CustomerID column
        String ID=txfID.getText();
        if(obj.CheckNum(ID)==true){
        ord.setRowFilter(RowFilter.regexFilter("^" + txfID.getText() + "$", 0));
        }
    }
    
    public void TotalCost()
    {
        // Calculates the total cost of a customer
        Double sum = 0.0;
        for (int i = 0; i < tblOrders.getRowCount(); i++) {
            sum = sum + Double.parseDouble(tblOrders.getValueAt(i, 3).toString());
        }
        txfTtlCost.setText(Double.toString(sum));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RestaurantDBPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("RestaurantDBPU").createEntityManager();
        foodtbQuery = java.beans.Beans.isDesignTime() ? null : RestaurantDBPUEntityManager.createQuery("SELECT f FROM Foodtb f");
        foodtbList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : foodtbQuery.getResultList();
        ordertbQuery = java.beans.Beans.isDesignTime() ? null : RestaurantDBPUEntityManager.createQuery("SELECT o FROM Ordertb o");
        ordertbList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ordertbQuery.getResultList();
        foodtbQuery1 = java.beans.Beans.isDesignTime() ? null : RestaurantDBPUEntityManager.createQuery("SELECT f FROM Foodtb f");
        foodtbList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : foodtbQuery1.getResultList();
        btnHelp = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnMainMenu = new javax.swing.JButton();
        lblID = new javax.swing.JLabel();
        txfID = new javax.swing.JTextField();
        lblTtlCost = new javax.swing.JLabel();
        txfTtlCost = new javax.swing.JTextField();
        btnTtlCost = new javax.swing.JButton();
        txfEstTime = new javax.swing.JTextField();
        lblEstTime = new javax.swing.JLabel();
        btnEstTime = new javax.swing.JButton();
        lblmin = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblOrders = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        lblPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(895, 575));
        getContentPane().setLayout(null);

        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        getContentPane().add(btnHelp);
        btnHelp.setBounds(14, 13, 59, 27);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(30, 460, 100, 40);

        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMainMenu);
        btnMainMenu.setBounds(750, 460, 100, 40);

        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("Customer ID");
        getContentPane().add(lblID);
        lblID.setBounds(580, 90, 80, 40);
        getContentPane().add(txfID);
        txfID.setBounds(680, 100, 100, 30);

        lblTtlCost.setForeground(new java.awt.Color(255, 255, 255));
        lblTtlCost.setText("Total Cost");
        getContentPane().add(lblTtlCost);
        lblTtlCost.setBounds(580, 200, 60, 30);

        txfTtlCost.setEditable(false);
        getContentPane().add(txfTtlCost);
        txfTtlCost.setBounds(680, 200, 160, 30);

        btnTtlCost.setText("Total Cost");
        btnTtlCost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTtlCostActionPerformed(evt);
            }
        });
        getContentPane().add(btnTtlCost);
        btnTtlCost.setBounds(730, 310, 130, 27);

        txfEstTime.setEditable(false);
        getContentPane().add(txfEstTime);
        txfEstTime.setBounds(680, 150, 100, 30);

        lblEstTime.setForeground(new java.awt.Color(255, 255, 255));
        lblEstTime.setText("Estimated Time");
        getContentPane().add(lblEstTime);
        lblEstTime.setBounds(570, 140, 100, 40);

        btnEstTime.setText("Estimated Time");
        btnEstTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstTimeActionPerformed(evt);
            }
        });
        getContentPane().add(btnEstTime);
        btnEstTime.setBounds(570, 310, 130, 27);

        lblmin.setForeground(new java.awt.Color(255, 255, 255));
        lblmin.setText("min.");
        getContentPane().add(lblmin);
        lblmin.setBounds(790, 150, 50, 30);

        tblOrders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CustomerID", "OrderID", "FoodID", "FoodPrice", "PrepTime"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblOrders);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 50, 550, 402);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearch);
        btnSearch.setBounds(790, 100, 71, 27);

        lblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgData/Restaurant.PNG"))); // NOI18N
        lblPic.setText("jLabel2");
        getContentPane().add(lblPic);
        lblPic.setBounds(0, 0, 880, 530);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        //Goes back to last customer interface
        CustomerUI customer = new CustomerUI();
        customer.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnBackActionPerformed

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        //Goes to main menu
        MainScreen main = new MainScreen();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMainMenuActionPerformed

    private void btnTtlCostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTtlCostActionPerformed
        // Calls method to calculate total cost of a specific customer
        TotalCost();
    }//GEN-LAST:event_btnTtlCostActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // Calls method to search orders of a specific customer
        CustomerSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnEstTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstTimeActionPerformed
        // Calls method for EstimatedTime
        EstimatedTime();
    }//GEN-LAST:event_btnEstTimeActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // Displays function of buttons
        JOptionPane.showMessageDialog(null, obj.Help4());
    }//GEN-LAST:event_btnHelpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Customer2UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer2UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer2UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer2UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer2UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager RestaurantDBPUEntityManager;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnEstTime;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnTtlCost;
    private java.util.List<pkgData.Foodtb> foodtbList;
    private java.util.List<pkgData.Foodtb> foodtbList1;
    private javax.persistence.Query foodtbQuery;
    private javax.persistence.Query foodtbQuery1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEstTime;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblPic;
    private javax.swing.JLabel lblTtlCost;
    private javax.swing.JLabel lblmin;
    private java.util.List<pkgData.Ordertb> ordertbList;
    private javax.persistence.Query ordertbQuery;
    private javax.swing.JTable tblOrders;
    private javax.swing.JTextField txfEstTime;
    private javax.swing.JTextField txfID;
    private javax.swing.JTextField txfTtlCost;
    // End of variables declaration//GEN-END:variables
}