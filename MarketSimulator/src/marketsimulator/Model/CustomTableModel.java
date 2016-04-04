/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Model;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SoRa
 */
public class CustomTableModel extends AbstractTableModel {
    JButton button;
    ArrayList<Property> property;
    
    public CustomTableModel(ArrayList<Property> property) {this.property = property;   }

    @Override
    public String getColumnName(int column) 
    {
        String name = null;
        switch(column)
        {
            case 0:
                name = "Name";
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
                name = "Seller";
                break;
            case 6:
                name = "Data Posted";
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
                tmp = property.get(rowIndex).getName();
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
                tmp = property.get(rowIndex).getSeller_id();
                break;
            case 5:
                tmp = property.get(rowIndex).getDatePosted();
                break;
            case 6:
                tmp = property.get(rowIndex).getImage_location();
                break;
            case 7:
                button = new JButton(); 
                button.setText("Sd");
                button.setEnabled(true);
                button.requestFocus();
        }
        return tmp;
    }
}
    
