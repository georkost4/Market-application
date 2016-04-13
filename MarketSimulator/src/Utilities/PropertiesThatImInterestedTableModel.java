/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import marketsimulator.Controller.InterestController;
import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public class PropertiesThatImInterestedTableModel extends AbstractTableModel 
{
    private ArrayList<Property> property;
    private InterestController controller;
    public PropertiesThatImInterestedTableModel(ArrayList<Property> property) 
    {
        this.property = property;
        controller = new InterestController();
    }

    @Override
    public String getColumnName(int column) {
       String name = null;
        switch(column)
        {
            case 0:
                name = "City";
                break;
            case 1:
                name = "Address";
                break;
            case 2:
                name = "Value";
                break;
            case 3:
                name = "Seller";
                break;
            case 4:
                name = "Data Posted";
                break;
            case 5:
                name = "Image";
                break;  
            case 6:
                name = "State";
                break;
        }
        return name;
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Object tmp = null;
        switch(columnIndex)
        {
            case 0:
                tmp = property.get(rowIndex).getCity();
                break;
            case 1:
                tmp = property.get(rowIndex).getAddress();
                break;
            case 2:
                tmp = property.get(rowIndex).getValue()+"$";
                break;
            case 3:
                tmp = controller.getSellerName(property.get(rowIndex).getSeller_id());
                break;
            case 4:
                tmp = property.get(rowIndex).getDatePosted();
                break;
            case 5:
                tmp = property.get(rowIndex).getImage_location();
                break;
            case 6:
                InterestController controller = new InterestController();
                int state = controller.getPropertyState(property.get(rowIndex).getProperty_id());
                ImageIcon icon = null;
                switch(state)
                { 
                    case -1:
                         try {tmp =  ImageIO.read(getClass().getClassLoader().getResource("Images/not_known.png")); } 
                         catch (IOException ex) {ex.printStackTrace();  }
                         icon = new ImageIcon((Image) tmp);
                         break;
                    case 1:
                         try {tmp =  ImageIO.read(getClass().getClassLoader().getResource("Images/accept-icon.png")); } 
                         catch (IOException ex) {ex.printStackTrace();  }
                         icon = new ImageIcon((Image) tmp);
                         break;
                    case 0:
                         try {tmp =  ImageIO.read(getClass().getClassLoader().getResource("Images/cancel.png")); } 
                         catch (IOException ex) {ex.printStackTrace();  }
                         icon = new ImageIcon((Image) tmp);
                         break;    
                }
               
                tmp = icon;
                break;  
        }
        return tmp;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 6)
        {return ImageIcon.class;}
        return Object.class;
    }

    @Override
    public int getRowCount() {
        return property.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    
    
    
    
    
    
}
