package ca.ubc.cs304.model;

import oracle.jdbc.proxy.annotation.Pre;

import java.sql.*;

public class Customer extends AbstractTable {
    private final int customerID;
    private final String cName;
    private final String email;
    private final String paymentInfo;
    private final Date trialStartDate;
    private final int membershipLevel;
    private final int points;

    public Customer(int customerID, String cName, String email,
                    String paymentInfo, Date trialStartDate,
                    int membershipLevel, int points) {
        this.customerID = customerID;
        this.cName  = cName;
        this.email = email;
        this.paymentInfo = paymentInfo;
        this.trialStartDate = trialStartDate;
        this.membershipLevel = membershipLevel;
        this.points = points;
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
            // set TrialStartDate to Null
            ps.setNull(5, Types.DATE);
            ps.setInt(6, custTable.getMembershipLevel());
            ps.setInt(7, custTable.getPoints());

            System.out.println("Preparing SQL statement");
        } catch(SQLException e) {
            throw e;
        }
        return ps;
    }

    // TODO: create method that handles creating SQL statement for updating a tuple
    public static PreparedStatement getUpdateStatement(Connection conn, int custID,
                                                       String attr, String newValue) throws SQLException {
        PreparedStatement ps;
        try {
            if (attr.equalsIgnoreCase("cName")) {
                ps = conn.prepareStatement("UPDATE Customer SET Cname = ? WHERE CustomerID = ?");
            } else {
                ps = conn.prepareStatement("UPDATE Customer SET Email = ? WHERE CustomerID = ?");
            }
            ps.setString(1, newValue);
            ps.setInt(2, custID);

        } catch (SQLException e) {
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
