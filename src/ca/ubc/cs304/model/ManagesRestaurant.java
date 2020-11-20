package ca.ubc.cs304.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagesRestaurant extends AbstractTable {
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

    public static Object[] getManagesRestRows(ResultSet rs) throws SQLException {
        int restaurantID = rs.getInt("RestaurantID");
        int vendorID = rs.getInt("VendorID");
        String rName = AbstractTable.stringTrimmer(rs.getString("Rname"));
        String unitNum = AbstractTable.stringTrimmer(rs.getString("UnitNum"));
        String postalCode = AbstractTable.stringTrimmer(rs.getString("PostalCode"));
        String cuisineType = AbstractTable.stringTrimmer(rs.getString("CuisineType"));
        Date joinDate = rs.getDate("JoinDate");
        Object[] rows = {restaurantID, vendorID, rName, unitNum, postalCode, cuisineType, joinDate};
        return rows;
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
