package Utilities;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import marketsimulator.View.usersThatAreInterestedInMyListingsView;

/**
 * Custom Editor for the Button Image , 
 * uses jcombobox super constructor.
 * @author SoRa-NDKTP
 */
public class btnSeeUsersEditor extends DefaultCellEditor
{
  protected JButton button;
  private boolean isPushed;
  private String prop_id;

    /**
     * Constructor for adding a button
     * to the table model using the checkBox super
     * constructor
     * @param checkBox
     */
    public btnSeeUsersEditor(JCheckBox checkBox) 
    {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() 
        {
          @Override
          public void actionPerformed(ActionEvent e) {
            fireEditingStopped();
          }
        });
    }

  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) 
  {
      // Visual effect for the button push action
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
      // get the property id from the table
      prop_id = MyListingsTableModel.getId(row);
      System.out.println(prop_id);
      // set the clicked variable to true to fire the event.
      isPushed = true;

      return button;
  }

  @Override
  public Object getCellEditorValue() 
  {
      // Button see users clicked event
      if (isPushed) 
      {
        new usersThatAreInterestedInMyListingsView(prop_id).setVisible(true);
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