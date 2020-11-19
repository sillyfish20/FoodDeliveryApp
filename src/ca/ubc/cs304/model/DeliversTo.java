package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliversTo extends AbstractTable {
    private final int driverID;
    private final String houseNum;
    private final String postalCode;

    public DeliversTo(int driverID, String houseNum, String postalCode) {
        this.driverID = driverID;
        this.houseNum = houseNum;
        this.postalCode = postalCode;
    }

    public static Object[] getDelivToRows(ResultSet rs) throws SQLException {
        int driverID = rs.getInt("DriverID");
        String houseNum = rs.getString("HouseNum");
        String postCode = rs.getString("PostalCode");
        Object[] rows = {driverID, houseNum, postCode};
        return rows;
    }

    public int getDriverID() { return this.driverID; }

    public String getHouseNum() { return this.houseNum; }

    public String getPostalCode() { return this.postalCode; }
}
