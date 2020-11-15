package ca.ubc.cs304.model;

import java.sql.Date;

public class ManagesRestaurant {
    private final int restaurantID;
    private final int vendorID;
    private final String rName;
    private final String unitNum;
    private final String postalCode;
    private final String cuisineType;
    private final Date joinDate;

    public ManagesRestaurant(int restaurantID, int vendorID, String rName,
                             String unitNum, String postalCode, String cuisineType,
                             Date joinDate) {
        this.restaurantID = restaurantID;
        this.vendorID  = vendorID;
        this.rName = rName;
        this.unitNum = unitNum;
        this.postalCode = postalCode;
        this.cuisineType = cuisineType;
        this.joinDate = joinDate;
    }

    public int getRestaurantID() { return this.restaurantID; }

    public int getVendorID() {
        return this.vendorID;
    }

    public String getRestaurantName() {
        return this.rName;
    }

    public String getUnitNum() {
        return this.unitNum;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCuisineType() {
        return this.cuisineType;
    }

    public Date getJoinDate() {
        return this.joinDate;
    }
}
