package ca.ubc.cs304.model;

public class DeliversTo {
    private final int driverID;
    private final String houseNum;
    private final String postalCode;

    public DeliversTo(int driverID, String houseNum, String postalCode) {
        this.driverID = driverID;
        this.houseNum = houseNum;
        this.postalCode = postalCode;
    }

    public int getDriverID() { return this.driverID; }

    public String getHouseNum() { return this.houseNum; }

    public String getPostalCode() { return this.postalCode; }
}
