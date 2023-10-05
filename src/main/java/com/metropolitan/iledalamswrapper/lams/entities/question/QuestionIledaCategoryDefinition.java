package com.metropolitan.iledalamswrapper.lams.entities.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionIledaCategoryDefinition {
    private String type = "http://id.tincanapi.com/activitytype/source";
    private QuestionIledaCategoryDefinitionName name = new QuestionIledaCategoryDefinitionName();
}
