/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import java.util.ArrayList;
import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public interface InterestInterface 
{
    public boolean makeInterest(String property_id,String user_id);
    public boolean acceptInterest(String property_id,String user_id);
    public boolean declineInterest(String property_id,String user_id);
    public ArrayList<Property> getMyInterests(String user_id);
    public ArrayList<Property> getMyListings(String user_id);
    
}
