package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

public class SubmissionGradedIledaCategory {
    private String id = "http://lams.metropolitan.ac.rs:8080/";
    private SubmissionGradedIledaCategoryDefinition definition = new SubmissionGradedIledaCategoryDefinition();
    private String objectType = "Activity";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SubmissionGradedIledaCategoryDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(SubmissionGradedIledaCategoryDefinition definition) {
        this.definition = definition;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
