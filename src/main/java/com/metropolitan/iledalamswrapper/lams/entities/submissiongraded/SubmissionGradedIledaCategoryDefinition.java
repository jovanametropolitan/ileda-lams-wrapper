package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

public class SubmissionGradedIledaCategoryDefinition {
    private String type = "http://id.tincanapi.com/activitytype/source";
    private SubmissionGradedIledaCategoryDefinitionName name = new SubmissionGradedIledaCategoryDefinitionName();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SubmissionGradedIledaCategoryDefinitionName getName() {
        return name;
    }

    public void setName(SubmissionGradedIledaCategoryDefinitionName name) {
        this.name = name;
    }
}
