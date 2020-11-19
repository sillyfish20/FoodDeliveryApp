package ca.ubc.cs304.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DriversVehicle extends AbstractTable {
    private final int driverID;
    private final int vehicleNum;
    private final int insuranceNum;

    public DriversVehicle(int driverID, int vehicleNum, int insuranceNum) {
        this.driverID = driverID;
        this.vehicleNum = vehicleNum;
        this.insuranceNum = insuranceNum;
    }

    public static Object[] getVehicleRows(ResultSet rs) throws SQLException {
        int driverID = rs.getInt("DriverID");
        int vehicleNum = rs.getInt("VehicleNum");
        int insuranceNum = rs.getInt("InsuranceNum");
        Object[] rows = {driverID, vehicleNum, insuranceNum};
        return rows;
    }

    public int getDriverID() { return this.driverID; }

    public int getVehicleNum() { return this.vehicleNum; }

    public int getInsuranceNum() { return this.insuranceNum; }
}
