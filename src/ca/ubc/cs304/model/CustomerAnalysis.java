package ca.ubc.cs304.model;

import java.math.BigDecimal;

/**
 * The intent for this class is to store the values we receive from the database
 */
public class CustomerAnalysis {
    private int customerID;
    private String cName;

    public CustomerAnalysis(int customerID, String cName) {
        this.customerID = customerID;
        this.cName = cName;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getcName() { return cName;}

}