
package marketsimulator;

import java.util.ArrayList;


/**
 *
 * @author SoRa
 */


public class MarketSimulator 
{
  
   
   public static void main(String[] args) 
   {
       DatabaseController cr = new DatabaseController();
       ArrayList<User> users = new ArrayList<User>();
       
       users = cr.getUsers();
       
              
       System.out.println(users);
       
       
       Runnable r = new Runnable() {

           @Override
           public void run() {
               new mainForm().setVisible(true);
           }
       };
       Thread t = new Thread(r);
       t.start();
   
   }
}