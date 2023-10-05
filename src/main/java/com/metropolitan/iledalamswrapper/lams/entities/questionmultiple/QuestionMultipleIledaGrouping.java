package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;

public class QuestionMultipleIledaGrouping {

    private String id;
    private QuestionMultipleIledaGroupingDefinition definition;
    private String objectType = "Activity";

    public QuestionMultipleIledaGrouping() {
    }

    public QuestionMultipleIledaGrouping(String id, QuestionMultipleIledaGroupingDefinition definition) {
        this.id = id;
        this.definition = definition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public QuestionMultipleIledaGroupingDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(QuestionMultipleIledaGroupingDefinition definition) {
        this.definition = definition;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }
}
