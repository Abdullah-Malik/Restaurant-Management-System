/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import java.util.ArrayList;

/**
 *
 * FoodItem class stores information regarding a particular food item
 */
public class FoodItem {
    
    /**
     * Stores the name of the fooditem
     */
    private String name;
    
    /**
     * Stores the price of the food item
     */
    private float price;
    
    /**
     * alist stores information regarding the addons
     */
    private ArrayList<AddOn> alist;

    public FoodItem(String name, float price, ArrayList<AddOn> alist) {
        this.name = name;
        this.price = price;
        this.alist = alist;
    }
    public FoodItem(String name, float price) {
        this.name = name;
        this.price = price;
        this.alist = new ArrayList<>();
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

    public ArrayList<AddOn> getAlist() {
        return alist;
    }

    public void setAlist(ArrayList<AddOn> alist) {
        this.alist = alist;
    }
    
}
