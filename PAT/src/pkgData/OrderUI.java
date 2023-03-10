/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ListIterator;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class OrderUI extends javax.swing.JFrame {

    Ordertb orders;
    ListIterator<Ordertb> iterator;

    /**
     * Creates new form OrderUI
     */
    public OrderUI() {
        initComponents();
        setLocationRelativeTo(rootPane);
        iterator = ordertbList.listIterator(0);
    }

    //Instantiating object
    Text obj = new Text();

    public Ordertb getOrders() {
        return orders;
    }

    public void setOrders(Ordertb orders) {
        Ordertb oldOrders = this.orders;
        this.orders = orders;
        firePropertyChange("orders", oldOrders, orders);
    }

    //Clears the text in text fields
    public void clearFields() {
        txfOrderID.setText("");
        txfCustomerID.setText("");
        txfFoodID.setText("");
    }

    //deletes order
    public void DeleteOrd() {
        try {
            //Finds the Order via OrderID
            int idStr = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Order ID"));
            Ordertb ord = RestaurantDBPUEntityManager.find(Ordertb.class, idStr);

            //Connects to database
            RestaurantDBPUEntityManager.getTransaction().begin();
            RestaurantDBPUEntityManager.remove(ord);
            RestaurantDBPUEntityManager.getTransaction().commit();
            RestaurantDBPUEntityManager.clear();

            //Deletes Order from table
            ordertbList.clear();
            ordertbList.addAll(ordertbQuery.getResultList());
            iterator = ordertbList.listIterator(0);
            setOrders(iterator.next());

            //Displays message confirming delete
            JOptionPane.showMessageDialog(null, "Delete Completed");
        } catch (Exception e) {
            System.out.println("Delte incomplete, please enter an exisiting Order ID");
        }
    }

    //Inserts Order via text fields
    public void InsertOrd() {
        //Customertb object
        Ordertb ord = new Ordertb();

        //Gets text from text fields
        ord.setOrderid(Integer.parseInt(txfOrderID.getText()));
        ord.setCustomerid(Integer.parseInt(txfCustomerID.getText()));
        ord.setFoodid(Integer.parseInt(txfFoodID.getText()));

        //Insert Time
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
        Calendar calendar = dateFormat.getCalendar().getInstance();
        ord.setOrdertime(calendar.getTime());

        //Connects to database
        RestaurantDBPUEntityManager.getTransaction().begin();
        RestaurantDBPUEntityManager.persist(ord);
        RestaurantDBPUEntityManager.getTransaction().commit();

        //Inserts text into table
        ordertbList.clear();
        ordertbList.addAll(ordertbQuery.getResultList());
        iterator = ordertbList.listIterator(0);

        //Clears the text fields
        clearFields();
    }

    //Checks for errors in values
    public void Check() {
        //Use of variables
        String OrderID = txfOrderID.getText();
        String CustomerID = txfCustomerID.getText();
        String FoodID = txfFoodID.getText();

        //Checks if all of the ID entered is numbers
        if (obj.CheckNum(OrderID) == true && obj.CheckNum(CustomerID) == true && obj.CheckNum(FoodID) == true) {
            //Searches if an order has the same ID
            int order = Integer.parseInt(txfOrderID.getText());
            for (int i = 0; i < ordertbList.size(); i++) {
                setOrders(iterator.next());
                if (orders.getOrderid() == order) {
                    JOptionPane.showMessageDialog(null, "OrderID is already used\n" + "Please use another OrderID");
                }
            }
            //Inserts Order after all conditions have been met
            InsertOrd();
            JOptionPane.showMessageDialog(null, "Insert Complete");
        } 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        RestaurantDBPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("RestaurantDBPU").createEntityManager();
        ordertbQuery = java.beans.Beans.isDesignTime() ? null : RestaurantDBPUEntityManager.createQuery("SELECT o FROM Ordertb o");
        ordertbList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ordertbQuery.getResultList();
        foodtbQuery = java.beans.Beans.isDesignTime() ? null : RestaurantDBPUEntityManager.createQuery("SELECT f FROM Foodtb f");
        foodtbList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : foodtbQuery.getResultList();
        ordertbQuery1 = java.beans.Beans.isDesignTime() ? null : RestaurantDBPUEntityManager.createQuery("SELECT o FROM Ordertb o");
        ordertbList1 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ordertbQuery1.getResultList();
        ordertbQuery2 = java.beans.Beans.isDesignTime() ? null : RestaurantDBPUEntityManager.createQuery("SELECT o FROM Ordertb o");
        ordertbList2 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ordertbQuery2.getResultList();
        ordertbQuery3 = java.beans.Beans.isDesignTime() ? null : RestaurantDBPUEntityManager.createQuery("SELECT o FROM Ordertb o");
        ordertbList3 = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : ordertbQuery3.getResultList();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        lblCustomerID = new javax.swing.JLabel();
        txfCustomerID = new javax.swing.JTextField();
        txfFoodID = new javax.swing.JTextField();
        lblFoodID = new javax.swing.JLabel();
        lblOrderID = new javax.swing.JLabel();
        txfOrderID = new javax.swing.JTextField();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFood = new javax.swing.JTable();
        lblPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(895, 575));
        getContentPane().setLayout(null);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, ordertbList3, tblOrder);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${customerid}"));
        columnBinding.setColumnName("Customerid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${foodid}"));
        columnBinding.setColumnName("Foodid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOrder);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(500, 60, 340, 140);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext);
        btnNext.setBounds(750, 460, 100, 40);

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(30, 460, 100, 40);

        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        getContentPane().add(btnHelp);
        btnHelp.setBounds(14, 13, 59, 27);

        btnInsert.setText("Insert Order");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        getContentPane().add(btnInsert);
        btnInsert.setBounds(580, 230, 120, 50);

        lblCustomerID.setForeground(new java.awt.Color(255, 255, 255));
        lblCustomerID.setText("Customer ID");
        getContentPane().add(lblCustomerID);
        lblCustomerID.setBounds(190, 280, 80, 30);

        txfCustomerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCustomerIDActionPerformed(evt);
            }
        });
        getContentPane().add(txfCustomerID);
        txfCustomerID.setBounds(290, 280, 210, 30);

        txfFoodID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfFoodIDActionPerformed(evt);
            }
        });
        getContentPane().add(txfFoodID);
        txfFoodID.setBounds(290, 350, 210, 30);

        lblFoodID.setForeground(new java.awt.Color(255, 255, 255));
        lblFoodID.setText("FoodID");
        getContentPane().add(lblFoodID);
        lblFoodID.setBounds(190, 350, 70, 30);

        lblOrderID.setForeground(new java.awt.Color(255, 255, 255));
        lblOrderID.setText("Order ID");
        getContentPane().add(lblOrderID);
        lblOrderID.setBounds(190, 220, 80, 30);

        txfOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfOrderIDActionPerformed(evt);
            }
        });
        getContentPane().add(txfOrderID);
        txfOrderID.setBounds(290, 220, 210, 30);

        btnDelete.setText("Delete Order");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        getContentPane().add(btnDelete);
        btnDelete.setBounds(580, 330, 120, 50);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, foodtbList, tblFood);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${foodid}"));
        columnBinding.setColumnName("Foodid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${foodname}"));
        columnBinding.setColumnName("Foodname");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${foodprice}"));
        columnBinding.setColumnName("Foodprice");
        columnBinding.setColumnClass(Double.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${foodquantity}"));
        columnBinding.setColumnName("Foodquantity");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(tblFood);
        if (tblFood.getColumnModel().getColumnCount() > 0) {
            tblFood.getColumnModel().getColumn(0).setMaxWidth(60);
            tblFood.getColumnModel().getColumn(2).setMaxWidth(80);
            tblFood.getColumnModel().getColumn(3).setMinWidth(100);
            tblFood.getColumnModel().getColumn(3).setMaxWidth(110);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 60, 430, 140);

        lblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgData/Restaurant.PNG"))); // NOI18N
        lblPic.setText("jLabel2");
        getContentPane().add(lblPic);
        lblPic.setBounds(0, 0, 880, 530);

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Goes to main screen
        MainScreen main = new MainScreen();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txfFoodIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfFoodIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfFoodIDActionPerformed

    private void txfCustomerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCustomerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCustomerIDActionPerformed

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // Find if OrderID is available
        Check();
    }//GEN-LAST:event_btnInsertActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked

    }//GEN-LAST:event_tblOrderMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // Deletes Order
        DeleteOrd();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txfOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfOrderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfOrderIDActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // Displays help message
        JOptionPane.showMessageDialog(null, obj.Help2());

    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        Order2UI order = new Order2UI();
        order.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNextActionPerformed

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
            java.util.logging.Logger.getLogger(OrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager RestaurantDBPUEntityManager;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNext;
    private java.util.List<pkgData.Foodtb> foodtbList;
    private javax.persistence.Query foodtbQuery;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblFoodID;
    private javax.swing.JLabel lblOrderID;
    private javax.swing.JLabel lblPic;
    private java.util.List<pkgData.Ordertb> ordertbList;
    private java.util.List<pkgData.Ordertb> ordertbList1;
    private java.util.List<pkgData.Ordertb> ordertbList2;
    private java.util.List<pkgData.Ordertb> ordertbList3;
    private javax.persistence.Query ordertbQuery;
    private javax.persistence.Query ordertbQuery1;
    private javax.persistence.Query ordertbQuery2;
    private javax.persistence.Query ordertbQuery3;
    private javax.swing.JTable tblFood;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txfCustomerID;
    private javax.swing.JTextField txfFoodID;
    private javax.swing.JTextField txfOrderID;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
