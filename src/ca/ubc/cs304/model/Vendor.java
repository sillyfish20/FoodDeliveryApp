package ca.ubc.cs304.model;

public class Vendor extends AbstractTable {
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

    public int getVendorID() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getPaymentInfo() { return paymentInfo; }

    public int getMonthlyFee() { return monthlyFee; }
}
