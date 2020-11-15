package ca.ubc.cs304.model;

public class DriversVehicle {
    private final int driverID;
    private final String vehicleNum;
    private final int insuranceNum;

    public DriversVehicle(int driverID, String vehicleNum, int insuranceNum) {
        this.driverID = driverID;
        this.vehicleNum = vehicleNum;
        this.insuranceNum = insuranceNum;
    }

    public int getDriverID() { return this.driverID; }

    public String getVehicleNum() { return this.vehicleNum; }

    public int getInsuranceNum() { return this.insuranceNum; }
}
