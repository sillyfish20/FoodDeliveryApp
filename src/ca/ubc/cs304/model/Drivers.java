package ca.ubc.cs304.model;

import java.sql.*;

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

    // This method handles creating SQL statements for inserting a tuple into Drivers table
    public PreparedStatement getInsertStatement(Connection conn, Drivers driverTable) throws SQLException {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO Drivers VALUES (?,?,?,?)");
            ps.setInt(1, driverTable.getDriverID());
            ps.setString(2, driverTable.getDriversLicense());
            ps.setString(3, driverTable.getDriverName());
            ps.setInt(4, driverTable.getDrivingRecApproved());

            System.out.println("Preparing SQL statement");
        } catch(SQLException e) {
            throw e;
        }
        return ps;
    }

    public int getDriverID() { return this.driverID; }

    public String getDriversLicense() { return this.driversLicense; }

    public String getDriverName() { return this.dName; }

    public int getDrivingRecApproved() { return this.drivingRecordApproved; }
}
