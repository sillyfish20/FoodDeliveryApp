package ca.ubc.cs304.model;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MembershipInfo extends AbstractTable {
    private final int membershipLevel;
    private final BigDecimal monthlyFee;

    public MembershipInfo(int membershipLevel, BigDecimal monthlyFee) {
        this.membershipLevel = membershipLevel;
        this.monthlyFee = monthlyFee;
    }

    public static Object[] getMemberInfoRows(ResultSet rs) throws SQLException {
        int memLevel = rs.getInt("MembershipLevel");
        BigDecimal monthlyFee = rs.getBigDecimal("MonthlyFee");
        Object[] rows = {memLevel, monthlyFee};
        return rows;
    }

    public int getMembershipLevel() {
        return this.membershipLevel;
    }

    public BigDecimal getMonthlyFee() {
        return this.monthlyFee;
    }
}
