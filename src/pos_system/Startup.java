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
public class Startup {

    /**
     * @param args the command line arguments
     */
        
    public static void main(String[] args) {
        
        Register reg = new Register();
        
        reg.startSale(new FakeDatabase());
        
        reg.addItemToSale("234567", 2);
        reg.addItemToSale("26485", 1);
        reg.addItemToSale("35486", 2);
        reg.addItemToSale("48782", 1);
        reg.addItemToSale("13572", 1);
        
        reg.endSale();
        
    }
    
}
