/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos_system;

import java.text.DecimalFormat;

/**
 *
 * @author Joe
 * @version 2
 */
public class Receipt {
    
    // Properties
    private LineItem[] lineItems;
    private final DataStorageStrategy dataStorage;
    private final String thankyou = "Thank you for shopping at Kohl's with us. Please come back anytime! \n\n\n" ;
    
    //private ReceiptOutputStrategy receiptOutput;

    // Construcor
    public Receipt(DataStorageStrategy dataStorage) {
        this.dataStorage = dataStorage;
        lineItems = new LineItem[0];
    }

    // Methods
    public void addLineItem(String itemId, double qty) {
        LineItem item = new LineItem(dataStorage, itemId, qty);
        addToArray(item);
    }

    private void addToArray(final LineItem item) {
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    public double getOriginalPriceTotal() {
        double total = 0.0;
        for (LineItem item : lineItems) {
            total += item.getSubtotal();
        }

        return total;
    }

    public double getDiscountTotal() {
        double totalDiscount = 0.0;
        for (LineItem item : lineItems) {
            totalDiscount += item.getDiscount();
        }

        return totalDiscount;
    }

    public void outputReceipt() {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        // Heading
        System.out.println(thankyou + "Qty   Id   Product  Price   Subtotal   discount\n"
                + "-----------------------------------------------");
        double subtotal = getOriginalPriceTotal();
        double discount = getDiscountTotal();
        double total = (getOriginalPriceTotal() - getDiscountTotal());
    //    System.out.println("-----------------------------------------------" );
        // Displays lineItems
        for (LineItem item : lineItems) {
            double productDiscount = item.getProduct().getDiscountStrategy().getDiscount(item.getQty() 
                                    ,item.getProduct().getPrice());
            
            
            System.out.println((int) item.getQty() + "  " + item.getProduct().getItemId() + " --  " + item.getProduct().getDescription() + "     "
                    + item.getProduct().getPrice() + "  " + (df.format((int) item.getQty() * item.getProduct().getPrice()))
                    + "  " + "  " + df.format(productDiscount) + "\n" + "\n");
            }

        // Process totals and discount
        System.out.println("-----------------------------------------------");
        System.out.println("\t\t\t  Subtotal:     " + df.format(subtotal) + "\n"
                +"\t\t\t  Discount:     -" + df.format(discount)+ "\n"
                + "\t\t\t  Total:        " + df.format(total));

    }

}
