
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
   public static void main(String[] args) 
   {
       try 
       {
            // Set cross-platform Java L&F (also called "Metal")
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
       } 
       catch (UnsupportedLookAndFeelException e) {
          // handle exception
       }
       catch (ClassNotFoundException e) {
          // handle exception
       }
       catch (InstantiationException e) {
          // handle exception
       }
       catch (IllegalAccessException e) {
          // handle exception
       }
       if(new UserController().checkIfLoggedIn()) new propertyView().setVisible(true);
       else new mainView().setVisible(true);
    }



   
}