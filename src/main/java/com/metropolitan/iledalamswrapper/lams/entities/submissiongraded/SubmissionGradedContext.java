package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

public class SubmissionGradedContext {
    private SubmissionGradedContextActivities contextActivities = new SubmissionGradedContextActivities();

    private SubmissionGradedInstructor instructor = new SubmissionGradedInstructor();
    public SubmissionGradedContextActivities getContextActivities() {
        return contextActivities;
    }

    public void setContextActivities(SubmissionGradedContextActivities contextActivities) {
        this.contextActivities = contextActivities;
    }

    public SubmissionGradedInstructor getInstructor() {
        return instructor;
    }

    public void setInstructor(SubmissionGradedInstructor instructor) {
        this.instructor = instructor;
    }
}
