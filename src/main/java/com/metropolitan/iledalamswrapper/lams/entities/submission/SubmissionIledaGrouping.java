package com.metropolitan.iledalamswrapper.lams.entities.submission;

public class SubmissionIledaGrouping {

    private String id;
    private SubmissionIledaGroupingDefinition definition;
    private String objectType = "Activity";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SubmissionIledaGroupingDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(SubmissionIledaGroupingDefinition definition) {
        this.definition = definition;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
