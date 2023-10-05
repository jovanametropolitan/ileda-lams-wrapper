package com.metropolitan.iledalamswrapper.lams.entities.examreceived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamReceivedContext {
    private ExamReceivedContextActivities contextActivities = new ExamReceivedContextActivities();
    private ExamReceivedContextInstructor instructor = new ExamReceivedContextInstructor();
}
