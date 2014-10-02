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
public class PercentageDiscount implements DiscountStrategy {
    
    // Properties
    private double percentRate = .10;
    
    // Constructor
    public PercentageDiscount(double percent) {
        this.setPercentRate(percent);
    }
    
    // Setters
    public void setPercentRate(double percent) {
        this.percentRate = percent;
    }
    
    // Getters
    public double getPercentRate() {
        return percentRate;
    }
    
    // Methods
    @Override
    public double getDiscount(double qty, double price) {
        return (qty * price * percentRate);
    }
    
    @Override
    public double getAmountAfterDiscount(double qty, double price) {
        return (qty * price) - getDiscount(qty, price);
    }



}
