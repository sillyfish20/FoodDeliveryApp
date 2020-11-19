package ca.ubc.cs304.model;


import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static Object[] getPicksUpOrdRows(ResultSet rs) throws SQLException {
        int orderID = rs.getInt("OrderID");
        int driverID = rs.getInt("DriverID");
        Timestamp pickUpTime = rs.getTimestamp("PickUpTime");
        Object[] rows = {orderID, driverID, pickUpTime};
        return rows;
    }

    public int getOrderId() { return this.orderId; }

    public int getDriverID() { return this.driverID; }

    public Timestamp getPickUpTime() { return this.pickUpTime; }
}
