/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;
import marketsimulator.Controller.InterestController;
import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public class MyListingsTableModel extends AbstractTableModel {
    JButton button;
    ArrayList<Property> property;
    InterestController controller;
    
    public MyListingsTableModel(ArrayList<Property> property) {this.property = property;  controller = new InterestController(); }

    @Override
    public String getColumnName(int column) 
    {
        String name = null;
        switch(column)
        {
            case 0:
                name = "Id";
                break;
            case 1:
                name = "City";
                break;
            case 2:
                name = "Address";
                break;
            case 3:
                name = "Value";
                break;
            case 4:
                name = "Seller";
                break;
            case 5:
                name = "Data Posted";
                break;
            case 6:
                name = "Image";
                break;  
            case 7:
                name = "State";
                break;
            case 8:
                name = "property_id";
                break;  
        }
        return name;
    }    
    
    
    
    @Override
    public int getRowCount() 
    {
        return property.size();
        
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
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
            case 8:
                tmp = property.get(rowIndex).getProperty_id();
                break;    
        }
        return tmp;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex == 7) return true;
        return false;
    }
    
}
    
