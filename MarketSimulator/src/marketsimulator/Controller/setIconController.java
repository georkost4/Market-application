/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 * Controller for setting application icon
 * @author SoRa
 */
public class setIconController 
{
 
    /**
     * Method for setting jframe's icon .
     * @param frame The frame to set up the application icon.
     */
    public void setIcon(JFrame frame) 
    {
        Image icon = null;
        try {icon = ImageIO.read(getClass().getClassLoader().getResource("Images/logo.jpg"));} 
        catch (IOException ex) {ex.printStackTrace();  }
        frame.setIconImage( icon);
    }     
    
}
