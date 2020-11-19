package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RestaurantLocation extends AbstractTable {
    private final String street;
    private final String unitNum;
    private final String postalCode;

    public RestaurantLocation(String street, String unitNum, String postalCode) {
        this.street = street;
        this.unitNum = unitNum;
        this.postalCode = postalCode;
    }

    public static Object[] getResLocationRow(ResultSet rs) throws SQLException {
        String street = rs.getString("Street");
        String unitNum = rs.getString("UnitNum");
        String postalCode = rs.getString("PostalCode");
        Object[] rows = {street, unitNum, postalCode};
        return rows;
    }

    public String getStreet() {
        return this.street;
    }

    public String getUnitNum() {
        return this.unitNum;
    }

    public String getPostalCode() {
        return this.postalCode;
    }
}
