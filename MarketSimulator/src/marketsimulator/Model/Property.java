/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketsimulator.Model;

/**
 * Class describing a property(house) in the
 * application . Contains methods for creating a
 * Property object also for getting and setting 
 * values to its objects.
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

    /**
     * Property class constructor .
     * @param property_id The object's id .
     * @param seller_id The object's seller id .
     * @param on_sale The object's on sale state (sold or on sale) .
     * @param value The object's value .
     * @param city The object's city name .
     * @param address The object's address .
     * @param datePosted The object's posted date .
     * @param image_location The object's image url .
     */
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

    /**
     * Getter for city
     * @return <b>String</b> of the city name.
     */
    public String getCity() {return city;}

    /**
     * Setter for city.
     * @param city The String  of the city to set.
     */
    public void setCity(String city) {this.city = city;}

    /**
     * Getter for address.
     * @return <b>String</b> of address .
     */
    public String getAddress() {return address; }

    /**
     * Setter for address.
     * @param address The String of the address to set.
     */
    public void setAddress(String address) {this.address = address;}

    /**
     * Getter for property_id.
     * @return <b>String</b> of the property id.
     */
    public String getProperty_id() { return property_id;  }

    /**
     * Setter for property_id .
     * @param property_id String of the property id to set.
     */
    public void setProperty_id(String property_id) {this.property_id = property_id; }

    /**
     * Getter for seller id .
     * @return <b>String</b> of the seller id .
     */
    public String getSeller_id() {return seller_id;}

    /**
     * Setter for seller id .
     * @param seller_id String of the seller id to set.
     */
    public void setSeller_id(String seller_id) {this.seller_id = seller_id;}

    /**
     * Getter for the on sale state of the property.
     * @return <b>String</b> of the state .
     */
    public String getOn_sale() { return on_sale; }

    /**
     * Setter for the on sale attribute of the object .
     * @param on_sale <b>String</b> of the on sale state to set.
     */
    public void setOn_sale(String on_sale) { this.on_sale = on_sale;  }
  
    /**
     * Getter for the value of the property.
     * @return <b>String</b> of the property value.
     */
    public String getValue() { return value; }

    /**
     * Setter for the value of the proeprty.
     * @param value <b>String</b> of the property value to set.
     */
    public void setValue(String value) {this.value = value; }

    /**
     * Getter for the image location of the property.
     * @return <b>String</b> of the image url .
     */
    public String getImage_location() {return image_location;}

    /**
     * Setter for the image location of the property .
     * @param image_location <b>String</b> of the url to set the image location of
     * the property.
     */
    public void setImage_location(String image_location) {this.image_location = image_location;}

    /**
     * Getter for the date posted attribute .
     * @return <b>String</b> of the date which this property
     * registered to this service .
     */
    public String getDatePosted() { return datePosted;    }

    /**
     * Setter for the date posted attribute.
     * @param datePosted <b>String</b> of the date to set.
     */
    public void setDatePosted(String datePosted) { this.datePosted = datePosted;    }

    @Override
    public String toString() {
        return "Property{" + "property_id=" + property_id + ", seller_id=" + seller_id + ", on_sale=" + on_sale + ", value=" + value + ", city=" + city + ", address=" + address + ", image_location=" + image_location + ", datePosted=" + datePosted + '}';
    }

    
    
    
    
}
