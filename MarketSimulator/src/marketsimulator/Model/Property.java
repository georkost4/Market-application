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
    String property_id;
    String seller_id;
    String on_sale;
    String value;
    String city;
    String address;
    String image_location;
    String datePosted;

    public Property(String property_id, String seller_id, String on_sale, String value, String city, String address,String datePosted , String image_location) {
        this.property_id = property_id;
        this.seller_id = seller_id;
        this.on_sale = on_sale;
        this.value = value;
        this.city = city;
        this.address = address;
        this.image_location = image_location;
        this.datePosted = datePosted;
    }

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getAddress() {return address; }

    public void setAddress(String address) {this.address = address;}

    public String getProperty_id() { return property_id;  }

    public void setProperty_id(String property_id) {this.property_id = property_id; }

    public String getSeller_id() {return seller_id;}

    public void setSeller_id(String seller_id) {this.seller_id = seller_id;}

    public String getOn_sale() { return on_sale; }

    public void setOn_sale(String on_sale) { this.on_sale = on_sale;  }
  
    public String getValue() { return value; }

    public void setValue(String value) {this.value = value; }

    public String getImage_location() {return image_location;}

    public void setImage_location(String image_location) {this.image_location = image_location;}

    public String getDatePosted() { return datePosted;    }

    public void setDatePosted(String datePosted) { this.datePosted = datePosted;    }

    
    
    
    
}
