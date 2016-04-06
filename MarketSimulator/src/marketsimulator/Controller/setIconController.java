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
 *
 * @author SoRa
 */
public class setIconController 
{
     public void setIcon(JFrame frame) 
    {
        Image icon = null;
        try {icon = ImageIO.read(getClass().getClassLoader().getResource("Images/logo.jpg"));} 
        catch (IOException ex) {ex.printStackTrace();  }
        frame.setIconImage( icon);
    }     
    
}
