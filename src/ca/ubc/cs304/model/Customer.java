package ca.ubc.cs304.model;

import java.sql.Date;

public class Customer {
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
