package ca.ubc.cs304.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * The intent for this class is to store the values we receive from the database
 * after sending the Selection and Aggr. Group By query
 */
public class OrderAnalysis {
    private int customerID;
    private BigDecimal subTotal;
    private Timestamp orderTime;

    public OrderAnalysis(int customerID, BigDecimal subTotal, Timestamp orderTime) {
        this.customerID = customerID;
        this.subTotal = subTotal;
        this.orderTime = orderTime;
    }

    public int getOrderCustomerID() {
        return customerID;
    }

    public BigDecimal getSubTotal() { return subTotal;}

    public Timestamp getOrderTime() { return orderTime; }

}
