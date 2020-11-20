package ca.ubc.cs304.model;

/**
 * The intent for this class is to store the values we receive from the database
 * after sending the Projection/Join query
 */
public class CustomerAnalysis {
    private int customerID;
    private String cName;

    public CustomerAnalysis(int customerID, String cName) {
        this.customerID = customerID;
        this.cName = cName;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public String getCName() { return this.cName;}

}