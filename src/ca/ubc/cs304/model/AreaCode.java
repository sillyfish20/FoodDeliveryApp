package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AreaCode extends AbstractTable {
    private final String postalCode;
    private final String city;
    private final String province;

    public AreaCode(String postalCode, String city, String province) {
        this.postalCode = postalCode;
        this.city = city;
        this.province = province;
    }

    public static Object[] getAreaCodeRow(ResultSet rs) throws SQLException {
        String postalCode = rs.getString("PostalCode");
        String city = rs.getString("City");
        String province = rs.getString("Province");
        Object[] rows = {postalCode, city, province};
        return rows;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public String getProvince() {
        return this.province;
    }
}
