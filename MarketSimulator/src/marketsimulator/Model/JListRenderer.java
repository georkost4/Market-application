/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Model;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author SoRa
 */
public class JListRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object>
{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Property prop = (Property) value;
        setText(prop.getCity() + " " + prop.getAddress() + "  " + prop.getValue()+"$");
        Image img = null;
        try {  img= ImageIO.read(new File(prop.getImage_location().replace("/","\\"))).getScaledInstance(176, 146, BufferedImage.SCALE_SMOOTH);} 
        catch (IOException ex) { ex.printStackTrace();}
        Icon icon = new ImageIcon(img);
        
        setIcon(icon);
        
        
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
