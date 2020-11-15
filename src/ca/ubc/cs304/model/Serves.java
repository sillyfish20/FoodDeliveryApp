package ca.ubc.cs304.model;

public class Serves {
    private final int restaurantID;
    private final int foodID;

    public Serves(int restaurantID, int foodID) {
        this.restaurantID = restaurantID;
        this.foodID  = foodID;
    }

    public int getRestaurantID() { return this.restaurantID; }

    public int getFoodID() {
        return this.foodID;
    }
}
