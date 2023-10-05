package com.metropolitan.iledalamswrapper.lams.entities.examreceived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamReceivedIledaStatement {
    private static String priority = "MEDIUM";
    private ExamReceivedIledaActor actor;
    private ExamReceivedIledaVerb verb;
    private ExamReceivedIledaObject object = new ExamReceivedIledaObject();
    private String timestamp;
    private ExamReceivedContext context = new ExamReceivedContext();
}
