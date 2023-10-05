package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

public class SubmissionGradedIledaGroupingDefinition {
    private String type;
    private SubmissionGradedIledaGroupingDefinitionName name;

    public SubmissionGradedIledaGroupingDefinition(String type, SubmissionGradedIledaGroupingDefinitionName name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SubmissionGradedIledaGroupingDefinitionName getName() {
        return name;
    }

    public void setName(SubmissionGradedIledaGroupingDefinitionName name) {
        this.name = name;
    }

}
