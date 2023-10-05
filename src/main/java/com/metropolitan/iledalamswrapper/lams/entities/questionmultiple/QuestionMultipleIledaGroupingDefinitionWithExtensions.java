package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;


import java.util.HashMap;
import java.util.Map;

public class QuestionMultipleIledaGroupingDefinitionWithExtensions extends QuestionMultipleIledaGroupingDefinition {

    private Map<String, String> extensions = new HashMap<>();

    public QuestionMultipleIledaGroupingDefinitionWithExtensions(String type, QuestionMultipleIledaGroupingDefinitionName name) {
        super(type, name);
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/external-id", "test");
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
    }

    public Map<String, String> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, String> extensions) {
        this.extensions = extensions;
    }
}
