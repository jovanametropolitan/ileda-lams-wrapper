package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

public class SubmissionGradedIledaStatement {
    private static String priority = "MEDIUM";
    private SubmissionGradedIledaActor actor;
    private SubmissionGradedIledaVerb verb;
    private SubmissionGradedIledaObject object = new SubmissionGradedIledaObject();

    private String timestamp;

    private SubmissionGradedContext context = new SubmissionGradedContext();

    private SubmissionGradedResults result = new SubmissionGradedResults();

    public SubmissionGradedIledaStatement() {
    }

    public static String getPriority() {
        return priority;
    }

    public static void setPriority(String priority) {
        SubmissionGradedIledaStatement.priority = priority;
    }

    public SubmissionGradedIledaActor getActor() {
        return actor;
    }

    public void setActor(SubmissionGradedIledaActor actor) {
        this.actor = actor;
    }

    public SubmissionGradedIledaVerb getVerb() {
        return verb;
    }

    public void setVerb(SubmissionGradedIledaVerb verb) {
        this.verb = verb;
    }

    public SubmissionGradedIledaObject getObject() {
        return object;
    }

    public void setObject(SubmissionGradedIledaObject object) {
        this.object = object;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public SubmissionGradedContext getContext() {
        return context;
    }

    public void setContext(SubmissionGradedContext context) {
        this.context = context;
    }

    public SubmissionGradedResults getResult() {
        return result;
    }

    public void setResult(SubmissionGradedResults result) {
        this.result = result;
    }
}
