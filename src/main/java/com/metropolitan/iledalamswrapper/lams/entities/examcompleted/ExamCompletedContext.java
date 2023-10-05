package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;


import com.metropolitan.iledalamswrapper.lams.entities.examstarted.ExamStartedContextActivities;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedContext {
    private ExamStartedContextActivities contextActivities = new ExamStartedContextActivities();

    public ExamStartedContextActivities getContextActivities() {
        return contextActivities;
    }

}
