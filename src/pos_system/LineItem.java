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
public class LineItem {
    
  // Properties
    private Product product;
    private DataStorageStrategy dataStorage;
    private double qty;
    
    // Constructor
    public LineItem(DataStorageStrategy dataStorage, String itemId, double qty) {
        this.setDataStorage(dataStorage);
        this.setProduct(dataStorage.findProduct(itemId));
        this.setQty(qty);
    }
    
    // setters
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public void setDataStorage(DataStorageStrategy dataStorage) {
        this.dataStorage = dataStorage;
    }
    
    public void setQty(double qty) {
        this.qty = qty;
    }
    
    // Getters
    public Product getProduct() {
        return product;
    }
    
    public double getQty() {
        return qty;
    }
    
    // Methods
    public Product findProduct(String itemId) {
        return dataStorage.findProduct(itemId);
    }
    
    public double getDiscount() {
        return product.getDiscountStrategy().getDiscount(qty, product.getPrice());
    }
    
    public double getSubtotal() {
        return qty * product.getPrice();
    }

}
