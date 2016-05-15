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
public class btnImageRenderer extends JButton implements TableCellRenderer
{

    /**
     * Custom button image renderer constructor.
     */
    public btnImageRenderer() {
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
        setText("See Image");
        return this;
  }
  

    
}
