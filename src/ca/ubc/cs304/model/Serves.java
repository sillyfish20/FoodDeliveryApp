package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Serves extends AbstractTable {
    private final int restaurantID;
    private final int foodID;

    public Serves(int restaurantID, int foodID) {
        this.restaurantID = restaurantID;
        this.foodID  = foodID;
    }

    public static Object[] getServesRow(ResultSet rs) throws SQLException {
        int restaurantID = rs.getInt("RestaurantID");
        int foodID = rs.getInt("FoodID");
        Object[] rows = {restaurantID, foodID};
        return rows;
    }

    public int getRestaurantID() { return this.restaurantID; }

    public int getFoodID() {
        return this.foodID;
    }
}
