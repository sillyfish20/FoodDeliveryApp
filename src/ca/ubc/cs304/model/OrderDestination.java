package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderDestination extends AbstractTable {
    private final int orderId;
    private final String houseNum;
    private final String postalCode;

    public OrderDestination(int orderId, String houseNum, String postalCode) {
        this.orderId = orderId;
        this.houseNum  = houseNum;
        this.postalCode = postalCode;
    }

    public static Object[] getOrderDestRows(ResultSet rs) throws SQLException {
        int orderID = rs.getInt("OrderID");
        String houseNum = rs.getString("HouseNum");
        String postCode = rs.getString("PostalCode");
        Object[] rows = {orderID, houseNum, postCode};
        return rows;
    }

    public int getOrderId() { return this.orderId; }

    public String getHouseNum() { return this.houseNum; }

    public String getPostalCode() { return this.postalCode; }
}
