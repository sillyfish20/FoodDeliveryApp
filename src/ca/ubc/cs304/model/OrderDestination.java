package ca.ubc.cs304.model;

public class OrderDestination {
    private final int orderId;
    private final String houseNum;
    private final String postalCode;

    public OrderDestination(int orderId, String houseNum, String postalCode) {
        this.orderId = orderId;
        this.houseNum  = houseNum;
        this.postalCode = postalCode;
    }

    public int getOrderId() { return this.orderId; }

    public String getHouseNum() { return this.houseNum; }

    public String getPostalCode() { return this.postalCode; }
}
