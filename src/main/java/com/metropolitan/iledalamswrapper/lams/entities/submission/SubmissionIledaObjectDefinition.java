package com.metropolitan.iledalamswrapper.lams.entities.submission;

import java.util.HashMap;
import java.util.Map;

public class SubmissionIledaObjectDefinition {
    private  String type = "http://adlnet.gov/expapi/activities/assessment";
    private SubmissionIledaObjectDefinitionName name = new SubmissionIledaObjectDefinitionName();

    private Map<String, String> extensions = new HashMap<>();

    public String getType() {
        return type;
    }

    public SubmissionIledaObjectDefinitionName getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(SubmissionIledaObjectDefinitionName name) {
        this.name = name;
    }

    public Map<String, String> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, String> extensions) {
        this.extensions = extensions;
    }
}
