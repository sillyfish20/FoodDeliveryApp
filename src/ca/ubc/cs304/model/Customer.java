package ca.ubc.cs304.model;

import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;

public class Customer extends AbstractTable {
    private final int customerID;
    private final String cName;
    private final String email;
    private final String paymentInfo;
    private final int points;
    private final Date trialStartDate;
    private final int membershipLevel;

    public Customer(int customerID, String cName, String email,
                    String paymentInfo, int points, Date trialStartDate,
                    int membershipLevel) {
        this.customerID = customerID;
        this.cName  = cName;
        this.email = email;
        this.paymentInfo = paymentInfo;
        this.points = points;
        this.trialStartDate = trialStartDate;
        this.membershipLevel = membershipLevel;
    }

    // TODO: Create method that handles creating SQL statements
    public PreparedStatement getInsertStatement(Connection conn, Customer custTable) throws SQLException {
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO customer VALUES (?,?,?,?,?,?,?)");
            ps.setInt(1, custTable.getCustomerID());
            ps.setString(2, custTable.getCustomerName());
            ps.setString(3, custTable.getEmail());
            ps.setString(4, custTable.getPaymentInfo());
            ps.setNull(4, Types.CHAR);
            ps.setInt(5, custTable.getPoints());
            // set TrialStartDate to Null
            ps.setNull(6, Types.DATE);
            ps.setInt(7, custTable.getMembershipLevel());

            System.out.println("Preparing SQL statement");
        } catch(SQLException e) {
            throw e;
        }
        return ps;
    }

    public int getCustomerID() { return this.customerID; }

    public String getCustomerName() { return this.cName; }

    public String getEmail() {
        return this.email;
    }

    public String getPaymentInfo() {
        return this.paymentInfo;
    }

    public int getPoints() {
        return this.points;
    }

    public Date getTrialStartDate() { return this.trialStartDate; }

    public int getMembershipLevel() {
        return this.membershipLevel;
    }
}
