package ca.ubc.cs304.model;

public class Drivers {
    private final int driverID;
    private final String driversLicense;
    private final String dName;
    private final boolean drivingRecordApproved;

    public Drivers(int driverID, String driversLicense, String dName,
                   boolean drivingRecordApproved) {
        this.driverID = driverID;
        this.driversLicense = driversLicense;
        this.dName = dName;
        this.drivingRecordApproved = drivingRecordApproved;
    }

    public int getDriverID() { return this.driverID; }

    public String getDriversLicense() { return this.driversLicense; }

    public String getDriverName() { return this.dName; }

    public boolean getDrivingRecApproved() { return this.drivingRecordApproved; }
}
