package com.metropolitan.iledalamswrapper.lams.entities.submission;

public class SubmissionIledaObject {
    private String id;

    private SubmissionIledaObjectDefinition definition = new SubmissionIledaObjectDefinition();
    private String objectType = "Activity";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDefinition(SubmissionIledaObjectDefinition definition) {
        this.definition = definition;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public SubmissionIledaObjectDefinition getDefinition() {
        return definition;
    }

    public String getObjectType() {
        return objectType;
    }

}
