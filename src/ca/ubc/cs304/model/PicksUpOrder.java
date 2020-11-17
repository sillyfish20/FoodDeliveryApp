package ca.ubc.cs304.model;


import java.sql.Timestamp;

public class PicksUpOrder extends AbstractTable {
    private final int orderId;
    private final int driverID;
    private final Timestamp pickUpTime;

    public PicksUpOrder(int orderId, int driverID, Timestamp pickUpTime) {
        this.orderId = orderId;
        this.driverID  = driverID;
        this.pickUpTime = pickUpTime;
    }

    public int getOrderId() { return this.orderId; }

    public int getDriverID() { return this.driverID; }

    public Timestamp getPickUpTime() { return this.pickUpTime; }
}
