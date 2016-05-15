/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;
import marketsimulator.Controller.PropertyController;

/**
 *
 * @author SoRa
 */
public class btnSeeUsersRenderer extends JButton implements TableCellRenderer {

    /**
     * Custom button renderer constructor.
     */
    public btnSeeUsersRenderer() {
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
  {
        if (isSelected) 
        {
          setForeground(table.getSelectionForeground());
          setBackground(table.getSelectionBackground());
        } 
        else 
        {
          setForeground(table.getForeground());
          setBackground(UIManager.getColor("Button.background"));
        }
        PropertyController controller = new PropertyController();
        if(controller.getOnSaleState(MyListingsTableModel.getId(row)) == 1){  setText("See users");  } 
        else
        {
            this.setForeground(Color.red);
            this.setBackground(Color.green);
            setText("Sold");
        }
        return this;
  }
  

    
}