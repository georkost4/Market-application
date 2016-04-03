/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import marketsimulator.Model.Property;

/**
 *
 * @author SoRa
 */
public interface InterestInterface 
{
    public boolean makeInterest(String property_id,String user_id);
    public boolean acceptInterest();
    public boolean declineInterest();
    
}
