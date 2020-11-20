package ca.ubc.cs304.model;

import java.math.BigDecimal;

/**
 * The intent for this class is to store the values we receive from the database
 * after sending the Selection query
 */
public class OrderAnalysis {
    private int customerID;
    private BigDecimal subTotal;

    public OrderAnalysis(int customerID, BigDecimal subTotal) {
        this.customerID = customerID;
        this.subTotal = subTotal;
    }

    public int getOrderCustomerID() {
        return customerID;
    }

    public BigDecimal getSubTotal() { return subTotal;}

}
