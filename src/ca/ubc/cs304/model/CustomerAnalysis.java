package ca.ubc.cs304.model;

/**
 * The intent for this class is to store the values we receive from the database
 * after sending the Projection/Join query and the division query
 */
public class CustomerAnalysis {
    private int customerID;
    private String cName;
    private String email;

    public CustomerAnalysis(int customerID, String cName, String email) {
        this.customerID = customerID;
        this.cName = cName;
        this.email = email;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public String getCName() { return this.cName;}

    public String getEmail() {
        return this.email;
    }

}