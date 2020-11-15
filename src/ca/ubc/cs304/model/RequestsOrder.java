package ca.ubc.cs304.model;

public class RequestsOrder {
    private final int restaurantID;
    private final int foodID;
    private final int orderId;

    public RequestsOrder(int restaurantID, int foodID, int orderId) {
        this.restaurantID = restaurantID;
        this.foodID  = foodID;
        this.orderId = orderId;
    }

    public int getRestaurantID() { return this.restaurantID; }

    public int getFoodID() {
        return this.foodID;
    }

    public int getOrderId() {
        return this.orderId;
    }
}
