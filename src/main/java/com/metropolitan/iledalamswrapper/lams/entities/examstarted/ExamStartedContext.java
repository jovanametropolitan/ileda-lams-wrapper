package com.metropolitan.iledalamswrapper.lams.entities.examstarted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamStartedContext {
    private ExamStartedContextActivities contextActivities = new ExamStartedContextActivities();
}
