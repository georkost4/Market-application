/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import marketsimulator.View.propertyImageView;
import marketsimulator.View.usersThatAreInterestedInMyListingsView;

/**
 *
 * @author SoRa
 */
public class btnImageEditor extends DefaultCellEditor
{
  protected JButton button;


  private boolean isPushed;
  private String image_loc = null;

  public btnImageEditor(JCheckBox checkBox) 
  {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    button.addActionListener(new ActionListener() 
    {@Override  public void actionPerformed(ActionEvent e) { fireEditingStopped();}});
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
  {
    if (isSelected) 
    {
      button.setForeground(table.getSelectionForeground());
      button.setBackground(table.getSelectionBackground());
    } 
    else 
    {
      button.setForeground(table.getForeground());
      button.setBackground(table.getBackground());
    }
    image_loc = (String) table.getValueAt(row, 5);
    System.out.println(image_loc);
    isPushed = true;
    
    return button;
  }

  @Override
  public Object getCellEditorValue() 
  {
    if (isPushed) 
    {
      new propertyImageView(image_loc).setVisible(true);
    }
    isPushed = false;
    return null;
  }

  @Override
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
    
}
