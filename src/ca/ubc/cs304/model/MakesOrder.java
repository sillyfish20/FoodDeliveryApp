package ca.ubc.cs304.model;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class MakesOrder extends AbstractTable {
    private final int orderID;
    private final int customerID;
    private final Timestamp orderTime;
    private final BigDecimal subTotal;
    private final BigDecimal deliveryFee;
    private final BigDecimal tax;

    public MakesOrder(int orderID, int customerID, Timestamp orderTime,
                             BigDecimal subTotal, BigDecimal deliveryFee, BigDecimal tax) {
        this.orderID = orderID;
        this.customerID  = customerID;
        this.orderTime = orderTime;
        this.subTotal = subTotal;
        this.deliveryFee = deliveryFee;
        this.tax = tax;
    }

    public static Object[] getMakesOrderRows(ResultSet rs) throws SQLException {
        int orderID = rs.getInt("OrderID");
        int custID = rs.getInt("CustomerID");
        Timestamp orderTime = rs.getTimestamp("OrderTime");
        BigDecimal subTotal = rs.getBigDecimal("Subtotal");
        BigDecimal deliveryFee = rs.getBigDecimal("DeliveryFee");
        BigDecimal tax = rs.getBigDecimal("Tax");
        Object[] rows = {orderID, custID, orderTime, subTotal, deliveryFee, tax};
        return rows;
    }

    public int getOrderID() { return this.orderID; }

    public int getCustomerID() { return this.customerID; }

    public Timestamp getOrderTime() {
        return this.orderTime;
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

}
