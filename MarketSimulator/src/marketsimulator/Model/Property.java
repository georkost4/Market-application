/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Model;

/**
 *
 * @author SoRa
 */
public class Property 
{
    String seller_id;
    String name;
    String value;
    String image_location;
    String datePosted;

    public Property(String seller_id, String name, String value, String image_location, String datePosted) 
    {
        this.seller_id = seller_id;
        this.name = name;
        this.value = value;
        this.image_location = image_location;
        this.datePosted = datePosted;
    }

    public String getName() { return name;}

    public void setName(String name) {this.name = name; }

    public String getImage_location() { return image_location;}

    public void setImage_location(String image_location) {this.image_location = image_location;}

    public String getDatePosted() {return datePosted;}

    public void setDatePosted(String datePosted) {this.datePosted = datePosted; }
    
    
    
    
    
}
