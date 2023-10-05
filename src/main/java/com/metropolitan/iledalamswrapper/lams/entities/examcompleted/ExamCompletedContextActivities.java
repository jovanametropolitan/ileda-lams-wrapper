package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedContextActivities {
    private List<ExamCompletedIledaGrouping> grouping = new ArrayList<>();
    private List<ExamCompletedIledaOther> other = new ArrayList<>();
    private List<ExamCompletedIledaCategory> category = Arrays.asList(new ExamCompletedIledaCategory());

    public ExamCompletedContextActivities() {
        ExamCompletedIledaGrouping sg1 = new ExamCompletedIledaGrouping();
        sg1.setId("http://lams.metropolitan.ac.rs:8080/");
        sg1.setDefinition(new ExamCompletedIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms", new ExamCompletedIledaGroupingDefinitionName("LAMS")));
        grouping.add(sg1);

        ExamCompletedIledaGrouping sg2 = new ExamCompletedIledaGrouping();
        sg2.setId("");
        sg2.setDefinition(new ExamCompletedIledaGroupingDefinitionWithExtensions("http://id.tincanapi.com/activitytype/lms/course", new ExamCompletedIledaGroupingDefinitionName("IZMENAAA")));
        grouping.add(sg2);

        other.add(new ExamCompletedIledaOther());
    }
}
