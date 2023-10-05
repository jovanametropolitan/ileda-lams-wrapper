package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;

public class QuestionMultipleMultipleIledaCategory {
    private String id = "http://lams.metropolitan.ac.rs:8080/";
    private QuestionMultipleIledaCategoryDefinition definition = new QuestionMultipleIledaCategoryDefinition();
    private String objectType = "Activity";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QuestionMultipleIledaCategoryDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(QuestionMultipleIledaCategoryDefinition definition) {
        this.definition = definition;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
