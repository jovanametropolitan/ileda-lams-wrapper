package com.metropolitan.iledalamswrapper.lams.entities.examentered;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamEnteredIledaStatement {
    private static String priority = "MEDIUM";
    private ExamEnteredIledaActor actor;
    private ExamEnteredIledaVerb verb;
    private ExamEnteredIledaObject object = new ExamEnteredIledaObject();
    private String timestamp;
    private ExamEnteredContext context = new ExamEnteredContext();


}
