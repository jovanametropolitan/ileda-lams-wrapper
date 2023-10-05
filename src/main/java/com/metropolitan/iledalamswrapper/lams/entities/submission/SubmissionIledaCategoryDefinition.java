package com.metropolitan.iledalamswrapper.lams.entities.submission;

public class SubmissionIledaCategoryDefinition {
    private String type = "http://id.tincanapi.com/activitytype/source";
    private SubmissionIledaCategoryDefinitionName name = new SubmissionIledaCategoryDefinitionName();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SubmissionIledaCategoryDefinitionName getName() {
        return name;
    }

    public void setName(SubmissionIledaCategoryDefinitionName name) {
        this.name = name;
    }
}
