package com.metropolitan.iledalamswrapper.lams.entities.submission;

public class SubmissionIledaStatement {
    private static String priority = "MEDIUM";
    private SubmissionIledaActor actor;
    private SubmissionIledaVerb verb;
    private SubmissionIledaObject object = new SubmissionIledaObject();

    private String timestamp;

    private SubmissionContext context = new SubmissionContext();

    public SubmissionIledaStatement() {
    }

    public static String getPriority() {
        return priority;
    }

    public static void setPriority(String priority) {
        SubmissionIledaStatement.priority = priority;
    }

    public SubmissionIledaActor getActor() {
        return actor;
    }

    public void setActor(SubmissionIledaActor actor) {
        this.actor = actor;
    }

    public SubmissionIledaVerb getVerb() {
        return verb;
    }

    public void setVerb(SubmissionIledaVerb verb) {
        this.verb = verb;
    }

    public SubmissionIledaObject getObject() {
        return object;
    }

    public void setObject(SubmissionIledaObject object) {
        this.object = object;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public SubmissionContext getContext() {
        return context;
    }

    public void setContext(SubmissionContext context) {
        this.context = context;
    }
}
