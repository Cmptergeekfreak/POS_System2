/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_system;

/**
 *
 * @author Joe
 * @version 2
 */
public class Product {
    
    // Properties
    private String itemId;
    private String description;
    private double price;
    private DiscountStrategy discountStrategy;
    
    // Constructor
    public Product(String itemId, String description, double price, DiscountStrategy discount){
        this.setItemId(itemId);
        this.setDescription(description);
        this.setPrice(price);
        this.setDiscountStrategy(discount);
    }
    
    // Setters
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    
    // Getters
    public String getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

}
