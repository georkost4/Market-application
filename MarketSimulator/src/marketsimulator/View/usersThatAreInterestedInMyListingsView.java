/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.View;

import Utilities.usersInterested_JlistCellRenderer;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import marketsimulator.Controller.InterestController;
import marketsimulator.Controller.setIconController;
import marketsimulator.Model.User;

/**
 * View for checking the user's that
 * are interested in your property.
 * @author SoRa
 */
public class usersThatAreInterestedInMyListingsView extends javax.swing.JFrame {

    
    private ArrayList<User> users;
    private String prop_id;
    
    
    public usersThatAreInterestedInMyListingsView(String prop_id) {
        initComponents();
        this.prop_id = prop_id;
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
        usersTharAreInterestedJList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Interested users");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        usersTharAreInterestedJList.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        usersTharAreInterestedJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        usersTharAreInterestedJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersTharAreInterestedJListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(usersTharAreInterestedJList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void init() {
        users = new ArrayList<User>();
        //Get the users.
        users = (new InterestController().getUsersThatAreInterestedInMyListings(prop_id));
        
        // Debug info here.
        System.out.println(users);
        
        //Default list model representing the users.
        DefaultListModel model = new DefaultListModel();
        
        for(User user : users)
        {
            model.addElement(user);
        }
        usersTharAreInterestedJList.setModel(model);
        usersTharAreInterestedJList.setCellRenderer(new usersInterested_JlistCellRenderer());
    }
    
    
    private void usersTharAreInterestedJListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTharAreInterestedJListMouseClicked
       User user = (User) usersTharAreInterestedJList.getSelectedValue();
       // Open new window for deciding whether to sell or not the property to this user.
       new UserDetailedInformation(user,prop_id,this).setVisible(true);
    }//GEN-LAST:event_usersTharAreInterestedJListMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // If no user is interested in this property show
        // appropriate message.
        if(users.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"No users are interested in this property");
            this.dispose();
        }
        // Re draw the listview
        init();
    }//GEN-LAST:event_formWindowActivated

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList usersTharAreInterestedJList;
    // End of variables declaration//GEN-END:variables

    
}
