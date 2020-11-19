package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction extends AbstractTable {
    private final int customerID;
    private final int restaurantID;

    public Transaction(int customerID, int restaurantID) {
        this.customerID = customerID;
        this.restaurantID = restaurantID;
    }

    public static Object[] getTransactionRow(ResultSet rs) throws SQLException {
        int custID = rs.getInt("CustomerID");
        int restID = rs.getInt("RestaurantID");
        Object[] rows = {custID, restID};
        return rows;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public int getRestaurantID() { return this.restaurantID; }
}
