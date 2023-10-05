package com.metropolitan.iledalamswrapper.lams.entities.submission;

public class SubmissionIledaGroupingDefinition {
    private String type;
    private SubmissionIledaGroupingDefinitionName name;

    public SubmissionIledaGroupingDefinition(String type, SubmissionIledaGroupingDefinitionName name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SubmissionIledaGroupingDefinitionName getName() {
        return name;
    }

    public void setName(SubmissionIledaGroupingDefinitionName name) {
        this.name = name;
    }

}
