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
import marketsimulator.Controller.PropertyController;
import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public class MyListingsTableModel extends AbstractTableModel {
    JButton button;
    static ArrayList<Property> property;
    InterestController controller;
    PropertyController prop_controller;
    
    /**
     * Constructor for a custom table model.
     * @param property ArrayList of the properties to show on the table model.
     */
    public MyListingsTableModel(ArrayList<Property> property) 
    {
        this.property = property;  
        controller = new InterestController(); 
        prop_controller = new PropertyController();
    }
    
    
    // Table column names
    @Override
    public String getColumnName(int column) 
    {
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
                name = "Users";
                break;
          
        }
        return name;
    }    
    
    /**
     *
     * @param row Some row at the table.
     * @return Returns the property_id of a single row on the table.
     */
    public static  String getId(int row)
    {
        return property.get(row).getProperty_id();
    }
    @Override
    public int getRowCount() 
    {
        return property.size();
        
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
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
        }
        return tmp;
    }
    
    
    // If you want the cell to be editable e.g add a button
    // you want to return  true.
   @Override
   public boolean isCellEditable(int rowIndex, int columnIndex) {
     if(columnIndex == 6 && prop_controller.getOnSaleState(property.get(rowIndex).getProperty_id()) == 1) return true;
     if(columnIndex == 5) return true;
       return false;
  }
    
    
    
}
    
