package com.metropolitan.iledalamswrapper.lams.entities.examstarted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamStartedIledaStatement {
    private static String priority = "MEDIUM";
    private ExamStartedIledaActor actor;
    private ExamStartedIledaVerb verb;
    private ExamStartedIledaObject object = new ExamStartedIledaObject();
    private String timestamp;
    private ExamStartedContext context = new ExamStartedContext();

}
