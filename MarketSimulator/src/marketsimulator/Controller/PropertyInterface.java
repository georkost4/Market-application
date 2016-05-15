/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Controller;

import java.util.ArrayList;
import marketsimulator.Model.Property;

/**
 * Interface for declaring PropertyController methods.
 * @author SoRa
 */
public interface PropertyInterface 
{
    public boolean addProperty(Property property);
    public boolean removeProperty(Property property);
    public ArrayList<Property> getProperties();
    public int getOnSaleState(String property_id);
    public boolean removePropertyFromSale(String property_id);
    
}
