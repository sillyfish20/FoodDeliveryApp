package ca.ubc.cs304.model;

import java.sql.Date;

public class TrialRange {
    private final Date trialStartDate;
    private final Date trialEndDate;

    public TrialRange(Date trialStartDate, Date trialEndDate) {
        this.trialStartDate = trialStartDate;
        this.trialEndDate = trialEndDate;
    }

    public Date getTrialStartDate() { return this.trialStartDate; }

    public Date getTrialEndDate() { return this.trialEndDate; }
}
