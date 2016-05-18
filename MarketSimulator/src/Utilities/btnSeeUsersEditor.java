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
 *
 * @author SoRa-NDKTP
 */
public class btnSeeUsersEditor extends DefaultCellEditor
{
    
    /**
     *
     */
    protected JButton button;


  private boolean isPushed;
  private String prop_id;

    /**
     *
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
    prop_id = MyListingsTableModel.getId(row);
    System.out.println(prop_id);
    isPushed = true;
    
    return button;
  }

  @Override
  public Object getCellEditorValue() 
  {
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