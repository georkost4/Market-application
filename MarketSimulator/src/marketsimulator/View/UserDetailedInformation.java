/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.View;

import javax.swing.JOptionPane;
import marketsimulator.Controller.InterestController;
import marketsimulator.Controller.PropertyController;
import marketsimulator.Controller.UserController;
import marketsimulator.Controller.setIconController;
import marketsimulator.Model.Property;
import marketsimulator.Model.User;

/**
 *
 * @author SoRa
 */
public class UserDetailedInformation extends javax.swing.JFrame {

    /**
     * Creates new form UserDetailedInformation
     */
    private User user;
    private String property_id;
    public UserDetailedInformation(User user,String property_id) {
        initComponents();
        new setIconController().setIcon(this);
        this.user = user;
        this.property_id = property_id;
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAcceptInterest = new javax.swing.JButton();
        btnDeclineInterest = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInfo = new javax.swing.JTextArea();
        labelFirstName = new javax.swing.JLabel();
        labelLastName = new javax.swing.JLabel();
        labelCity = new javax.swing.JLabel();
        labelNumber = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("First Name:");

        jLabel2.setText("Last Name:");

        jLabel3.setText("City:");

        jLabel4.setText("Phone number:");

        jLabel5.setText("Other Information:");

        btnAcceptInterest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/accept-icon.png"))); // NOI18N
        btnAcceptInterest.setText("Sell the property to this user.");
        btnAcceptInterest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptInterestActionPerformed(evt);
            }
        });

        btnDeclineInterest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cancel.png"))); // NOI18N
        btnDeclineInterest.setText("Decline this user.");
        btnDeclineInterest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeclineInterestActionPerformed(evt);
            }
        });

        jScrollPane1.setEnabled(false);

        txtInfo.setColumns(20);
        txtInfo.setFont(new java.awt.Font("Ebrima", 0, 15)); // NOI18N
        txtInfo.setLineWrap(true);
        txtInfo.setRows(5);
        txtInfo.setEnabled(false);
        jScrollPane1.setViewportView(txtInfo);

        labelFirstName.setText("jLabel6");

        labelLastName.setText("jLabel7");

        labelCity.setText("jLabel8");

        labelNumber.setText("jLabel9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAcceptInterest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btnDeclineInterest)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelLastName))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelFirstName)))
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCity))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(labelNumber)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(labelCity))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(labelNumber)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelFirstName))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(labelLastName))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcceptInterest)
                    .addComponent(btnDeclineInterest))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcceptInterestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptInterestActionPerformed
        InterestController interest_controller = new InterestController();
        PropertyController property_controller = new PropertyController();
        
        if(property_controller.removePropertyFromSale(property_id))
        {
            if(interest_controller.acceptInterest(property_id,String.valueOf(user.getId())))
            {
                interest_controller.DeclineAllOtherUsers(property_id, String.valueOf(user.getId()));
                JOptionPane.showMessageDialog(this, "You successfully selled this property");
            }
        }
    }//GEN-LAST:event_btnAcceptInterestActionPerformed

    private void btnDeclineInterestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeclineInterestActionPerformed
       InterestController controller = new InterestController();
       if(controller.declineInterest(property_id, String.valueOf(user.getId()))) JOptionPane.showMessageDialog(this, "GG");
    }//GEN-LAST:event_btnDeclineInterestActionPerformed

   private void init() 
   {
       labelFirstName.setText(user.getFirstname());
       labelLastName.setText(user.getLastname());
       labelCity.setText(user.getCity());
       labelNumber.setText(user.getNumber());
       
       String personal_info = new UserController().getUserPersonalInfo(String.valueOf(user.getId()));
       
       txtInfo.setText(personal_info);
        
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptInterest;
    private javax.swing.JButton btnDeclineInterest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCity;
    private javax.swing.JLabel labelFirstName;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelNumber;
    private javax.swing.JTextArea txtInfo;
    // End of variables declaration//GEN-END:variables

   
}
