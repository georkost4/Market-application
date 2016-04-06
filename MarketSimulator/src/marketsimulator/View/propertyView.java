/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.View;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import marketsimulator.Controller.PropertyController;
import Utilities.PropertyOnSale_JListRenderer;
import marketsimulator.Controller.UserController;
import marketsimulator.Controller.setIconController;
import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public class propertyView extends javax.swing.JFrame {

    /**
     * Creates new form propertyView
     */
    public propertyView() {
        initComponents();
        init();
        new setIconController().setIcon(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        propertyList = new javax.swing.JList();
        btnAddNewProperty = new javax.swing.JButton();
        btnHistory = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Properties  on sale");
        setResizable(false);

        propertyList.setFont(new java.awt.Font("Georgia", 0, 16)); // NOI18N
        propertyList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                propertyListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(propertyList);

        btnAddNewProperty.setText("Add New Property");
        btnAddNewProperty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewPropertyActionPerformed(evt);
            }
        });

        btnHistory.setText("My History");
        btnHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryActionPerformed(evt);
            }
        });

        jLabel1.setText("Logged in as");

        labelUser.setForeground(new java.awt.Color(153, 153, 255));
        labelUser.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddNewProperty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                            .addComponent(labelUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(btnAddNewProperty)
                .addGap(57, 57, 57)
                .addComponent(btnHistory)
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelUser)
                .addContainerGap(190, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddNewPropertyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNewPropertyActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new AddNewPropertyView().setVisible(true);
    }//GEN-LAST:event_btnAddNewPropertyActionPerformed

    private void propertyListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_propertyListMouseClicked
        // TODO add your handling code here:
         Property prop = (Property) propertyList.getSelectedValue() ;
         new propertyDetailsView(prop).setVisible(true);
         this.setVisible(false);
    }//GEN-LAST:event_propertyListMouseClicked

    private void btnHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryActionPerformed
        this.setVisible(false);
        new myHistoryView().setVisible(true);
    }//GEN-LAST:event_btnHistoryActionPerformed

    /**
     * @param args the command line arguments
     */
   public void init()
   {
       UserController user_controller = new UserController();
       labelUser.setText(user_controller.getLoggedUser().getFirstname() + " \n " + user_controller.getLoggedUser().getLastname());
       PropertyController controller = new PropertyController();
       DefaultListModel model = new DefaultListModel();
       ArrayList<Property> properties = new ArrayList<Property>();
       properties = controller.getProperties();
       for(Property prop : properties)
       {
           model.addElement(prop);
   
       }
       propertyList.setCellRenderer(new PropertyOnSale_JListRenderer());
       propertyList.setModel(model);
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewProperty;
    private javax.swing.JButton btnHistory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelUser;
    private javax.swing.JList propertyList;
    // End of variables declaration//GEN-END:variables
}
