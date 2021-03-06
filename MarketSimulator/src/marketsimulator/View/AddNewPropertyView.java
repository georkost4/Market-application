/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.View;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import marketsimulator.Controller.PropertyController;
import marketsimulator.Controller.UserController;
import marketsimulator.Controller.ValidationController;
import marketsimulator.Controller.setIconController;
import marketsimulator.Controller.DatabaseController;
import marketsimulator.Model.Property;
import marketsimulator.Model.User;

/**
 * View for adding a new
 * property on sale.
 * @author SoRa
 */
public class AddNewPropertyView extends javax.swing.JFrame {

    /**
     * Creates new form AddNewPropertyView
     */
    public AddNewPropertyView() {
        initComponents();
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

        jLabel4 = new javax.swing.JLabel();
        txtValue = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnSelectImage = new javax.swing.JButton();
        txtImageSelected = new javax.swing.JLabel();
        btnDone = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add new property for sale");
        setResizable(false);

        jLabel4.setText("Value");

        jLabel6.setText("Image:");

        btnSelectImage.setText("Select Image");
        btnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImageActionPerformed(evt);
            }
        });

        txtImageSelected.setText("No image selected");

        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel7.setText("City");

        jLabel8.setText("Address");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(22, 22, 22)
                                .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtImageSelected))
                            .addComponent(btnSelectImage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtImageSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelectImage)))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImageActionPerformed
        // TODO add your handling code here:
        
        // Open window dialog for choosing
        // the image of the property.
        final JFileChooser fc = new JFileChooser();
        FileFilter imageFilter = new FileNameExtensionFilter(
        "Image files", ImageIO.getReaderFileSuffixes());
        fc.addChoosableFileFilter(imageFilter);
        fc.setAcceptAllFileFilterUsed(false);
        
        // If the user chose image execute the followin code
        int returnVal = fc.showDialog(this,"Select");
        System.out.println(String.valueOf(returnVal));
        if(returnVal == CHOSE_OK)
        {
           
                File file = fc.getSelectedFile();
                txtImageSelected.setText(file.getAbsolutePath());
                
                String photo_name = file.getName();
                PropertyController controller = new PropertyController();
                try 
                {
                    // Save the image to the local server directory.
                    File marketDir = new File("C:\\MarketApp");
                    marketDir.mkdir();
                    File ImageFile =  new File("C:\\MarketApp\\"+photo_name);
                     
                    // Write the new scaled down to 176x146 image locally amd then upload it to the web server.
                    BufferedImage img = new BufferedImage(176, 146, BufferedImage.TYPE_INT_RGB);
                    img.createGraphics().drawImage(ImageIO.read(new File(txtImageSelected.getText())).getScaledInstance(176, 146, Image.SCALE_SMOOTH), CHOSE_OK, CHOSE_OK,null);
                    ImageIO.write(img, "jpg",ImageFile);
                    controller.uploadImageToServer(ImageFile);
                    txtImageSelected.setText(ImageFile.getAbsolutePath());
                }
                catch (IOException ex) {ex.printStackTrace();  }
            
        }
    }//GEN-LAST:event_btnSelectImageActionPerformed
    

    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed

        PropertyController controller = new PropertyController();
        UserController user_controller = new UserController();
        ValidationController vd_controller = new ValidationController();
        
        
        // Get the values from the text boxes
        String seller_id = String.valueOf( user_controller.getLoggedUser().getId() );
        String value = txtValue.getText();
        String[] image = txtImageSelected.getText().split("\\\\");
        String name = image[image.length-1];
        String city  = txtCity.getText();
        String address = txtAddress.getText();
        
        Date date = new Date();
        
        Property temp = new Property("0",seller_id,"1",value,city,address,date.toString()
                ,DatabaseController.SERVER_IMAGE_LOCATION + String.valueOf(user_controller.getLoggedUser().getId()) + name);
        
        // Insert the new proeprty to the database.
        if(vd_controller.validateAddNewPropertyInput(this,temp.getValue(),temp.getCity(),temp.getAddress()))
        {
            if(controller.addProperty(temp))
            {
                JOptionPane.showMessageDialog(this, "New Property successfully added");
                this.dispose();
                new propertyView().setVisible(true);
            }
        }
    }//GEN-LAST:event_btnDoneActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new propertyView().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    private static final int CHOSE_OK = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDone;
    private javax.swing.JButton btnSelectImage;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JLabel txtImageSelected;
    private javax.swing.JTextField txtValue;
    // End of variables declaration//GEN-END:variables
}
