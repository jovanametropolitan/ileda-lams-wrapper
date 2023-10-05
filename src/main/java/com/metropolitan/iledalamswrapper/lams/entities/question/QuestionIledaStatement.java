package com.metropolitan.iledalamswrapper.lams.entities.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionIledaStatement {
    private static String priority = "MEDIUM";
    private QuestionIledaActor actor;
    private QuestionIledaVerb verb;
    private QuestionIledaObject object = new QuestionIledaObject();
    private String timestamp;
    private QuestionResult result = new QuestionResult();
    private QuestionContext context = new QuestionContext();
}
