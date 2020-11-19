package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDestination extends AbstractTable {
    private final String houseNum;
    private final String postalCode;
    private final String street;
    private final String city;
    private final String province;

    public AddressDestination(String houseNum, String postalCode, String street,
                              String city, String province) {
        this.houseNum = houseNum;
        this.postalCode  = postalCode;
        this.street = street;
        this.city = city;
        this.province = province;
    }

    public static Object[] getAddDestRows(ResultSet rs) throws SQLException {
        String houseNum = rs.getString("HouseNum");
        String postCode = rs.getString("PostalCode");
        String street = rs.getString("Street");
        String city = rs.getString("City");
        String province = rs.getString("Province");
        Object[] rows = {houseNum, postCode, street, city, province};
        return rows;
    }

    public String getHouseNum() { return this.houseNum; }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getProvince() {
        return this.province;
    }
}
