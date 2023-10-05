package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

import java.util.HashMap;
import java.util.Map;

public class SubmissionGradedIledaObjectDefinition {
    private  String type = "http://adlnet.gov/expapi/activities/assessment";
    private SubmissionGradedIledaObjectDefinitionName name = new SubmissionGradedIledaObjectDefinitionName();

    private Map<String, String> extensions = new HashMap<>();

    public String getType() {
        return type;
    }

    public SubmissionGradedIledaObjectDefinitionName getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(SubmissionGradedIledaObjectDefinitionName name) {
        this.name = name;
    }

    public Map<String, String> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, String> extensions) {
        this.extensions = extensions;
    }
}
