package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;

public class QuestionMultipleIledaCategoryDefinition {
    private String type = "http://adlnet.gov/expapi/activities/category";
    private QuestionMultipleIledaCategoryDefinitionName name = new QuestionMultipleIledaCategoryDefinitionName();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public QuestionMultipleIledaCategoryDefinitionName getName() {
        return name;
    }

    public void setName(QuestionMultipleIledaCategoryDefinitionName name) {
        this.name = name;
    }
}
