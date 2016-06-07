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
 * Custom JList renderer for displaying
 * properties tha are on sale.
 * @author SoRa
 */
public class propertyOnSale_JListCellRenderer extends DefaultListCellRenderer implements ListCellRenderer<Object>
{

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Property prop = (Property) value;
        // set the text of the jTextView to the property city , address , value.
        setText(prop.getCity() + " " + prop.getAddress() + "  " + prop.getValue()+"$");
        
        
        // Get the url of the image from the prop object and 
        // save the image.
        URL url;
        BufferedImage img = null ;
        try 
        { 
            url = new URL(prop.getImage_location()) ;
            img = ImageIO.read(url.openStream());
        } 
        catch (MalformedURLException ex) {ex.printStackTrace();   } 
        catch (IOException ex) {ex.printStackTrace();  }
        
        ImageIcon icon = new ImageIcon(img);
        // Set the image taken from the url to the imageView of
        // the ListView
        setIcon(icon);
        
        // Custom Borders for each entry of the ListView
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
