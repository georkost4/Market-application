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
import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public class PropertiesThatImInterestedTableModel extends MyListingsTableModel {

    public PropertiesThatImInterestedTableModel(ArrayList<Property> property) {
        super(property);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         Object tmp = null;
        switch(columnIndex)
        {
            case 0:
                tmp = property.get(rowIndex).getProperty_id();
                break;
            case 1:
                tmp = property.get(rowIndex).getCity();
                break;
            case 2:
                tmp = property.get(rowIndex).getAddress();
                break;
            case 3:
                tmp = property.get(rowIndex).getValue();
                break;
            case 4:
                tmp = controller.getSellerName(property.get(rowIndex).getSeller_id());
                break;
            case 5:
                tmp = property.get(rowIndex).getDatePosted();
                break;
            case 6:
                tmp = property.get(rowIndex).getImage_location();
                break;
            case 7:
                try {tmp =  ImageIO.read(getClass().getClassLoader().getResource("Images/not_known.png")); } 
                catch (IOException ex) {ex.printStackTrace();  }
                ImageIcon icon = new ImageIcon((Image) tmp);
                tmp = icon;
                break;
            case 8:
                tmp = property.get(rowIndex).getProperty_id();
                break;    
        }
        return tmp;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 7)
        {return ImageIcon.class;}
        return Object.class;
    }
    
    
    
    
    
    
    
}
