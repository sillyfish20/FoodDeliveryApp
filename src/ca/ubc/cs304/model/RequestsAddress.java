package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestsAddress extends AbstractTable {
    private final String houseNum;
    private final String postalCode;
    private final int customerID;

    public RequestsAddress(String houseNum, String postalCode, int customerID) {
        this.houseNum = houseNum;
        this.postalCode  = postalCode;
        this.customerID = customerID;
    }

    public static Object[] getReqAddressRows(ResultSet rs) throws SQLException {
        String houseNum = rs.getString("HouseNum");
        String postCode = rs.getString("PostalCode");
        int custID = rs.getInt("CustomerID");
        Object[] rows = {houseNum, postCode, custID};
        return rows;
    }

    public String getHouseNum() { return this.houseNum; }

    public String getPostalCode() {
        return this.postalCode;
    }

    public int getCustomerID() {
        return this.customerID;
    }

}
