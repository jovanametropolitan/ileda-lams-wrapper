package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;

public class QuestionMultipleIledaObject {
    private String id;

    private QuestionMultipleIledaObjectDefinition definition = new QuestionMultipleIledaObjectDefinition();
    private String objectType = "Activity";


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDefinition(QuestionMultipleIledaObjectDefinition definition) {
        this.definition = definition;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public QuestionMultipleIledaObjectDefinition getDefinition() {
        return definition;
    }

    public String getObjectType() {
        return objectType;
    }

}
