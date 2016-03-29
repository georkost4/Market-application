
package marketsimulator;

import marketsimulator.View.mainView;
import marketsimulator.Model.User;
import java.util.ArrayList;
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
       
       Runnable r = new Runnable() {

           @Override
           public void run() {
               new mainView().setVisible(true);
           }
       };
       Thread t = new Thread(r);
       t.start();
   }
}