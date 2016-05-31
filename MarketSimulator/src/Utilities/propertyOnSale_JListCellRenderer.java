/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public class propertyOnSale_JListCellRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object>
{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Property prop = (Property) value;
        setText(prop.getCity() + " " + prop.getAddress() + "  " + prop.getValue()+"$");
        
        URL url;
        BufferedImage img = null ;
        try 
        { 
            url = new URL(prop.getImage_location()) ;
            img = ImageIO.read(url);
        } 
        catch (MalformedURLException ex) {ex.printStackTrace();   } 
        catch (IOException ex) {ex.printStackTrace();  }
        
        ImageIcon icon = new ImageIcon(img);
        
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
            Border noFocus = BorderFactory.createRaisedBevelBorder();
            this.setBorder(noFocus);
        }
        
        setEnabled(true);
        setFont(list.getFont());
        return this;
    }

}
