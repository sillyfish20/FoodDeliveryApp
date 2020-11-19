package ca.ubc.cs304.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Receipt extends AbstractTable {
    private final BigDecimal subTotal;
    private final BigDecimal deliveryFee;
    private final BigDecimal tax;
    private final BigDecimal total;

    public Receipt(BigDecimal subTotal, BigDecimal deliveryFee, BigDecimal tax, BigDecimal total) {
        this.subTotal = subTotal;
        this.deliveryFee = deliveryFee;
        this.tax = tax;
        this.total = total;
    }

    public static Object[] getReceiptRows(ResultSet rs) throws SQLException {
        BigDecimal subTotal = rs.getBigDecimal("Subtotal");
        BigDecimal deliveryFee = rs.getBigDecimal("DeliveryFee");
        BigDecimal tax = rs.getBigDecimal("Tax");
        BigDecimal total = rs.getBigDecimal("Total");
        Object[] rows = {subTotal, deliveryFee, tax, total};
        return rows;
    }

    public BigDecimal getSubTotal() {
        return this.subTotal;
    }

    public BigDecimal getDeliveryFee() {
        return this.deliveryFee;
    }

    public BigDecimal getTax() {
        return this.tax;
    }

    public BigDecimal getTotal() {
        return this.total;
    }
}
