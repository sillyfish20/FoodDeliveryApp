package ca.ubc.cs304.model;

import java.math.BigDecimal;

/**
 * The intent for this class is to store the values we receive from the database
 */
public class OrderAnalysis {
    private int orderID;
    private BigDecimal subTotal;

    public OrderAnalysis(int customerID, BigDecimal subTotal) {
        this.orderID = customerID;
        this.subTotal = subTotal;
    }

    public int getOrderID() {
        return orderID;
    }

    public BigDecimal getSubTotal() { return subTotal;}

}
