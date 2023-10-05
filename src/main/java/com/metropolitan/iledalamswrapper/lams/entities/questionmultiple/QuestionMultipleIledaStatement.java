package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;

public class QuestionMultipleIledaStatement {
    private static String priority = "MEDIUM";
    private QuestionMultipleIledaActor actor;
    private QuestionMultipleIledaVerb verb;
    private QuestionMultipleIledaObject object = new QuestionMultipleIledaObject();

    private String timestamp;
    private QuestionMultipleResult result = new QuestionMultipleResult();

    private QuestionMultipleContext context = new QuestionMultipleContext();

    public QuestionMultipleIledaStatement() {
    }

    public static String getPriority() {
        return priority;
    }

    public static void setPriority(String priority) {
        QuestionMultipleIledaStatement.priority = priority;
    }

    public QuestionMultipleIledaActor getActor() {
        return actor;
    }

    public void setActor(QuestionMultipleIledaActor actor) {
        this.actor = actor;
    }

    public QuestionMultipleIledaVerb getVerb() {
        return verb;
    }

    public void setVerb(QuestionMultipleIledaVerb verb) {
        this.verb = verb;
    }

    public QuestionMultipleIledaObject getObject() {
        return object;
    }

    public void setObject(QuestionMultipleIledaObject object) {
        this.object = object;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public QuestionMultipleContext getContext() {
        return context;
    }

    public void setContext(QuestionMultipleContext context) {
        this.context = context;
    }

    public QuestionMultipleResult getResult() {
        return result;
    }

    public void setResult(QuestionMultipleResult result) {
        this.result = result;
    }
}
