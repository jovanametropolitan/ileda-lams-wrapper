package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedIledaStatement {
    private static String priority = "MEDIUM";
    private ExamCompletedIledaActor actor;
    private ExamCompletedIledaVerb verb;
    private ExamCompletedIledaObject object = new ExamCompletedIledaObject();
    private String timestamp;
    private ExamCompletedContext context = new ExamCompletedContext();
    private ExamCompletedResult result = new ExamCompletedResult();


}
