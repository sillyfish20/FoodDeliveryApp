package ca.ubc.cs304.model;

import java.math.BigDecimal;

public class MembershipInfo extends AbstractTable {
    private final int membershipLevel;
    private final BigDecimal monthlyFee;

    public MembershipInfo(int membershipLevel, BigDecimal monthlyFee) {
        this.membershipLevel = membershipLevel;
        this.monthlyFee = monthlyFee;
    }

    public int getMembershipLevel() {
        return this.membershipLevel;
    }

    public BigDecimal getMonthlyFee() {
        return this.monthlyFee;
    }
}
