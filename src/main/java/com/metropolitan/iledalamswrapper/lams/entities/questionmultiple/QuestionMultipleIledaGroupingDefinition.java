package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;

import java.util.HashMap;
import java.util.Map;

public class QuestionMultipleIledaGroupingDefinition {
    private String type;
    private QuestionMultipleIledaGroupingDefinitionName name;

    private Map<String, String> extensions = new HashMap<>();
    public QuestionMultipleIledaGroupingDefinition(String type, QuestionMultipleIledaGroupingDefinitionName name) {
        this.type = type;
        this.name = name;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public QuestionMultipleIledaGroupingDefinitionName getName() {
        return name;
    }

    public void setName(QuestionMultipleIledaGroupingDefinitionName name) {
        this.name = name;
    }

    public Map<String, String> getExtensions() {
        return extensions;
    }

    public void setExtensions(Map<String, String> extensions) {
        this.extensions = extensions;
    }
}
