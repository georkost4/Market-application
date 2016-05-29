
package marketsimulator;

import marketsimulator.View.mainView;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import marketsimulator.Controller.UserController;
import marketsimulator.Model.DatabaseController;
import marketsimulator.View.propertyView;


/**
 * Main class used for starting
 * the application
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
       
       
       DatabaseController controller = new DatabaseController();
       if(controller.checkIfDatabaseExists())
       {
           // If the user credentials not found start over , else show the main view,
           if(new UserController().checkIfLoggedIn()) new propertyView().setVisible(true);
           else new mainView().setVisible(true);
       }
       else
       {
           System.out.print("Database and tables created.");
           
           //Create the db and the tables.
           controller.createDatabase();
           controller.createTables();
           // Show the login form.
           new mainView().setVisible(true);
       }
       
       
    }



   
}