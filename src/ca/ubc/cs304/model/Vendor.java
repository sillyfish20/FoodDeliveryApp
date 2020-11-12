package ca.ubc.cs304.model;

public class Vendor {
    private final int vendorId;
    private final String vendorName;
    private final String paymentInfo;
    private final int monthlyFee;

    public Vendor(int vendorId, String vendorName, String paymentInfo, int monthlyFee) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.paymentInfo = paymentInfo;
        this.monthlyFee = monthlyFee;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }
}
