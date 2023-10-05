package com.metropolitan.iledalamswrapper.lams.entities.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionIledaObject {
    private String id;
    private QuestionIledaObjectDefinition definition = new QuestionIledaObjectDefinition();
    private String objectType = "Activity";

}
