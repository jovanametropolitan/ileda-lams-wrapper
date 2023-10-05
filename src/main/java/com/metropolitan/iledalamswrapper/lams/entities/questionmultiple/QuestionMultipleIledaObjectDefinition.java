package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;

public class QuestionMultipleIledaObjectDefinition {
    private  String type = "http://adlnet.gov/expapi/activities/cmi.interaction";
    private QuestionMultipleIledaObjectDefinitionName name = new QuestionMultipleIledaObjectDefinitionName();

    private String interactionType;

    public String getType() {
        return type;
    }

    public QuestionMultipleIledaObjectDefinitionName getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(QuestionMultipleIledaObjectDefinitionName name) {
        this.name = name;
    }

    public String getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(String interactionType) {
        this.interactionType = interactionType;
    }
}
