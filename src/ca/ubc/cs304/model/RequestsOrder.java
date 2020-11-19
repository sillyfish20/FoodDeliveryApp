package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestsOrder extends AbstractTable {
    private final int restaurantID;
    private final int foodID;
    private final int orderId;

    public RequestsOrder(int restaurantID, int foodID, int orderId) {
        this.restaurantID = restaurantID;
        this.foodID  = foodID;
        this.orderId = orderId;
    }

    public static Object[] getReqOrderRows(ResultSet rs) throws SQLException {
        int restID = rs.getInt("RestaurantID");
        int foodID = rs.getInt("FoodID");
        int orderID = rs.getInt("OrderID");
        Object[] rows = {restID, foodID, orderID};
        return rows;
    }

    public int getRestaurantID() { return this.restaurantID; }

    public int getFoodID() {
        return this.foodID;
    }

    public int getOrderId() {
        return this.orderId;
    }
}
