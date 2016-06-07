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

/**
 * Custom Editor for the Button Image , 
 * uses jcombobox super constructor.
 * @author SoRa
 */
public class btnImageEditor extends DefaultCellEditor
{

    /**
     *
     */
    protected JButton button;


  private boolean isPushed;
  private String image_loc = null;

    /**
     * Custom button image editor constructor.
     * @param checkBox
     */
    public btnImageEditor(JCheckBox checkBox) 
    {
        // Use default cell editor for a checkbox
        // but instead create a button
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() 
        {
            @Override  
            public void actionPerformed(ActionEvent e)
            { 
                fireEditingStopped();
            }
        });
  }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
  {
      // Visual effect if the button is selected or not
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
      // Get the image URL
      image_loc = (String) table.getValueAt(row, 5);
      System.out.println(image_loc);
      // Set the pushed variable to true so tha the event will be fired.
      isPushed = true;

      return button;
  }

  @Override
  public Object getCellEditorValue() 
  {
     // Button Image clicked event 
     if (isPushed) 
     {
         //Show the image
         new propertyImageView(image_loc).setVisible(true);
     }
     // Set the clicked variable to false
     isPushed = false;
     return null;
  }

  @Override
  public boolean stopCellEditing() 
  {
            
      isPushed = false;
      return super.stopCellEditing();
  }

  @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
    
}
