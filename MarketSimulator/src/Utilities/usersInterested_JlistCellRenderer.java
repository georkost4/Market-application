/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import marketsimulator.Model.User;

/**
 * Custom JList model for seeing the users
 * that are interested in a specific property
 * that is on sale.
 * @author SoRa
 */
public class usersInterested_JlistCellRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object>
{
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        User user = (User) value;
        // set the text view of the list with the user
        setText(user.getFirstname()+ " " + user.getLastname());
        
        // Visual effects for the list
        if(isSelected)
        {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        }
        else
        {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        
        setEnabled(true);
        setFont(list.getFont());
        return this;
    }
    
}
