package com.metropolitan.iledalamswrapper.lams.entities.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionIledaObjectDefinition {
    private  String type = "http://adlnet.gov/expapi/activities/cmi.interaction";
    private QuestionIledaObjectDefinitionName name = new QuestionIledaObjectDefinitionName();
    private String interactionType;
}
