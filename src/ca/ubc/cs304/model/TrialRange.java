package ca.ubc.cs304.model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrialRange extends AbstractTable {
    private final Date trialStartDate;
    private final Date trialEndDate;

    public TrialRange(Date trialStartDate, Date trialEndDate) {
        this.trialStartDate = trialStartDate;
        this.trialEndDate = trialEndDate;
    }

    public static Object[] getTrialRangeRows(ResultSet rs) throws SQLException {
        Date trialStart = rs.getDate("TrialStartDate");
        Date trialEnd = rs.getDate("TrialEndDate");
        Object[] rows = {trialStart, trialEnd};
        return rows;
    }

    public Date getTrialStartDate() { return this.trialStartDate; }

    public Date getTrialEndDate() { return this.trialEndDate; }
}
