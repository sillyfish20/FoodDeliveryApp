package ca.ubc.cs304.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Vendor extends AbstractTable {
    private final int vendorId;
    private final String vendorName;
    private final String paymentInfo;
    private final BigDecimal monthlyFee;

    public Vendor(int vendorId, String vendorName, String paymentInfo, BigDecimal monthlyFee) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
        this.paymentInfo = paymentInfo;
        this.monthlyFee = monthlyFee;
    }

    public static Object[] getVendorRows(ResultSet rs) throws SQLException {
        int vendorId = rs.getInt("VendorID");
        String vendorName = AbstractTable.stringTrimmer(rs.getString("Vname"));
        String paymentInfo = AbstractTable.stringTrimmer(rs.getString("PaymentInfo"));
        BigDecimal monthlyFee = rs.getBigDecimal("MonthlyFee").setScale(2, RoundingMode.HALF_EVEN);
        Object[] rows = {vendorId, vendorName, paymentInfo, monthlyFee};
        return rows;
    }

    public int getVendorID() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getPaymentInfo() { return paymentInfo; }

    public BigDecimal getMonthlyFee() { return monthlyFee; }
}
