package ca.ubc.cs304.model;

public class RequestsAddress {
    private final String houseNum;
    private final String postalCode;
    private final int customerID;

    public RequestsAddress(String houseNum, String postalCode, int customerID) {
        this.houseNum = houseNum;
        this.postalCode  = postalCode;
        this.customerID = customerID;
    }

    public String getHouseNum() { return this.houseNum; }

    public String getPostalCode() {
        return this.postalCode;
    }

    public int getCustomerID() {
        return this.customerID;
    }

}
