package ca.ubc.cs304.model;

import java.math.BigDecimal;

public class Food {
    private final int foodID;
    private final String fName;
    private final BigDecimal price;
    private final String type;

    public Food(int foodID, String fName, BigDecimal price, String type) {
        this.foodID = foodID;
        this.fName = fName;
        this.price = price;
        this.type = type;
    }

    public int getFoodID() { return this.foodID; }

    public String getFoodName() { return this.fName; }

    public BigDecimal getPrice() { return this.price; }

    public String getType() { return this.type; }
}
