package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

public class SubmissionGradedIledaGrouping {

    private String id;
    private SubmissionGradedIledaGroupingDefinition definition;
    private String objectType = "Activity";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SubmissionGradedIledaGroupingDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(SubmissionGradedIledaGroupingDefinition definition) {
        this.definition = definition;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
