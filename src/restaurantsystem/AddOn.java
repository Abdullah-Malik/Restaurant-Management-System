/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

/**
 *
 * 
 * This class handles the Addons in the ordered food Item
 */
public class AddOn {
    
    /**
    * name carries the name of the AddOn
    */
    private String name;
    /**
    * price stores the price of the addOn
    */
    private float price;

    /**
    * Constructor for addOn
    */
    public AddOn(String name, float price) {
        this.name = name;
        this.price = price;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
}
