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
public class Register {
    
     // Properties
    private Receipt receipt;
    
    // Setters
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
    
    // Gettes
    public Receipt getReceipt() {
        return receipt;
    }
    
    
    // Methods
    public void startSale(DataStorageStrategy dataStorage) {
        receipt = new Receipt(dataStorage);
    }
    
    public void addItemToSale(String itemId, double qty) {
        receipt.addLineItem(itemId, qty);
    }
    
    public void endSale() {
        receipt.outputReceipt();
    }
}
