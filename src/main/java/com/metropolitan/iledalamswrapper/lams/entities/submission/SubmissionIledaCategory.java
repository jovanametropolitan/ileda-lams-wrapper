package com.metropolitan.iledalamswrapper.lams.entities.submission;

public class SubmissionIledaCategory {
    private String id = "http://lams.metropolitan.ac.rs:8080/";
    private SubmissionIledaCategoryDefinition definition = new SubmissionIledaCategoryDefinition();
    private String objectType = "Activity";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SubmissionIledaCategoryDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(SubmissionIledaCategoryDefinition definition) {
        this.definition = definition;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
