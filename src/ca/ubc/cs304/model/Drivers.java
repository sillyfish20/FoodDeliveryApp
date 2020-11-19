package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Drivers extends AbstractTable {
    private final int driverID;
    private final String driversLicense;
    private final String dName;
    // int must be 1 or 0 for true or false
    private final int drivingRecordApproved;

    public Drivers(int driverID, String driversLicense, String dName,
                   int drivingRecordApproved) {
        this.driverID = driverID;
        this.driversLicense = driversLicense;
        this.dName = dName;
        this.drivingRecordApproved = drivingRecordApproved;
    }

    public static Object[] getDriversRows(ResultSet rs) throws SQLException {
        int driverID = rs.getInt("DriverID");
        String driversLicense = rs.getString("DriversLicense");
        String dName = rs.getString("Dname");
        int drivingRecordApproved = rs.getInt("drivingRecordApproved");
        Object[] rows = {driverID, driversLicense, dName, drivingRecordApproved};
        return rows;
    }

    public int getDriverID() { return this.driverID; }

    public String getDriversLicense() { return this.driversLicense; }

    public String getDriverName() { return this.dName; }

    public int getDrivingRecApproved() { return this.drivingRecordApproved; }
}
