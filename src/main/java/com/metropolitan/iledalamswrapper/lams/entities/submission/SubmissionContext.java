package com.metropolitan.iledalamswrapper.lams.entities.submission;

public class SubmissionContext {
    private SubmissionContextActivities contextActivities = new SubmissionContextActivities();

    public SubmissionContextActivities getContextActivities() {
        return contextActivities;
    }

    public void setContextActivities(SubmissionContextActivities contextActivities) {
        this.contextActivities = contextActivities;
    }
}
