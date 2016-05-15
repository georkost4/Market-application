
package marketsimulator;

import marketsimulator.View.mainView;
import marketsimulator.Model.User;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import marketsimulator.Controller.UserController;
import marketsimulator.View.AddNewPropertyView;
import marketsimulator.View.propertyView;


/**
 *
 * @author SoRa
 */


public class MarketSimulator 
{
 
    /**
     * Main method that starts the Market application.
     * @param args
     */
    public static void main(String[] args) 
   {
       try 
       {
            UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
       } 
       catch (UnsupportedLookAndFeelException e) {}
       catch (ClassNotFoundException e) {}
       catch (InstantiationException e) {}
       catch (IllegalAccessException e) {}
       
       // If the user credentials not found start over , else show the main view,
       if(new UserController().checkIfLoggedIn()) new propertyView().setVisible(true);
       else new mainView().setVisible(true);
    }



   
}