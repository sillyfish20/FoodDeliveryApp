package ca.ubc.cs304.model;

public class Transaction {
    private final int customerID;
    private final int restaurantID;

    public Transaction(int customerID, int restaurantID) {
        this.customerID = customerID;
        this.restaurantID = restaurantID;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public int getRestaurantID() { return this.restaurantID; }
}
