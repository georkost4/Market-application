/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.View;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import marketsimulator.Controller.InterestController;
import marketsimulator.Controller.PropertyController;
import marketsimulator.Controller.UserController;
import marketsimulator.Controller.setIconController;
import marketsimulator.Model.Property;

/**
 * View containing information
 * about a specific property(house) on sale.
 * @author SoRa
 */
public class propertyDetailsView extends javax.swing.JFrame {

    Property property;
    /**
     * Creates new form propertyDetailsView
     */
    public propertyDetailsView(Property property) {
        initComponents();
        this.property = property;
        new setIconController().setIcon(this);
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        city = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        city1 = new javax.swing.JLabel();
        value1 = new javax.swing.JLabel();
        btnInterest = new javax.swing.JButton();
        value = new javax.swing.JLabel();
        value3 = new javax.swing.JLabel();
        errorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Details of the property");

        city.setText("jLabel1");

        icon.setText("jLabel1");

        address.setText("jLabel1");

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        city1.setText("City:");

        value1.setText("Address:");

        btnInterest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/accept-icon.png"))); // NOI18N
        btnInterest.setText("Im interested in this property");
        btnInterest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInterestActionPerformed(evt);
            }
        });

        value.setText("jLabel1");

        value3.setText("Value");

        errorLabel.setFont(new java.awt.Font("Gadugi", 1, 18)); // NOI18N
        errorLabel.setForeground(new java.awt.Color(255, 102, 102));
        errorLabel.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(city1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(btnInterest, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(value1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(value3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(66, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(city1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(value1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(value3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(value, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInterest)
                    .addComponent(btnBack))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.setVisible(false);
        new propertyView().setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnInterestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInterestActionPerformed
        InterestController controller = new InterestController();
        UserController user_controller = new UserController();
        PropertyController property_controller = new PropertyController();
        if(property_controller.getOnSaleState(property.getProperty_id()) == 1) // if the property is still on sale proceed
        {
            // Make the appropriate changes in the database
            // declare interest about this property from the 
            // logged in user.
            if(controller.makeInterest(property.getProperty_id(),String.valueOf(user_controller.getLoggedUser().getId())))
            {
                JOptionPane.showMessageDialog(this, "You just declared your interest");
                btnInterest.setVisible(false);
                errorLabel.setEnabled(true);
                errorLabel.setText("Already interested in this property.");
            }
            else JOptionPane.showMessageDialog(this, "Error");
        }
        else JOptionPane.showMessageDialog(this, "Error this property is already sold or removed","Error",JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_btnInterestActionPerformed

   private void init() 
    {
        // Setting up the text boxes and the image
        // of the property.
        icon.setIcon( new ImageIcon(property.getImage_location()));
        city.setText( property.getCity());
        address.setText( property.getAddress());
        value.setText(property.getValue()+"$");
        
        // Check if already interested before giving other option . 
        InterestController interest_controller = new InterestController();
        boolean flag = interest_controller.checkIfAlreadyInterested(property.getProperty_id());
        if(flag)
        {
            btnInterest.setVisible(false);
            errorLabel.setEnabled(true);
            errorLabel.setText("Already interested in this property.");
        }
        
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnInterest;
    private javax.swing.JLabel city;
    private javax.swing.JLabel city1;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel icon;
    private javax.swing.JLabel value;
    private javax.swing.JLabel value1;
    private javax.swing.JLabel value3;
    // End of variables declaration//GEN-END:variables

    
}
