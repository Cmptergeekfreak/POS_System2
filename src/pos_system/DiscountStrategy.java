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
public interface DiscountStrategy {
     // Methods
    public abstract double getDiscount(double qty, double price);
    public abstract double getAmountAfterDiscount(double qty, double price);
}
