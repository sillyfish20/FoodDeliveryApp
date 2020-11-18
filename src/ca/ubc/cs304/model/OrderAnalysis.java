package ca.ubc.cs304.model;

/**
 * The intent for this class is to update/store information about a single branch
 */
public class OrderAnalysis {
    public int customerID;
    public double subTotal; /// how do we make this compatible with the decimal with set criteria????

    public OrderAnalysis(int customerID, float subTotal) {
        this.customerID = customerID;
        this.subTotal = subTotal;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getsubTotal() { return subTotal;}

}
