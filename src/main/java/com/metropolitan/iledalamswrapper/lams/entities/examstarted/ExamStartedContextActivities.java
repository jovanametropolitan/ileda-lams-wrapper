package com.metropolitan.iledalamswrapper.lams.entities.examstarted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ExamStartedContextActivities {
    private List<ExamStartedIledaGrouping> grouping = new ArrayList<>();
    private List<ExamStartedIledaOther> other = new ArrayList<>();
    private List<ExamStartedIledaCategory> category = Arrays.asList(new ExamStartedIledaCategory());

    public ExamStartedContextActivities() {
        ExamStartedIledaGrouping sg1 = new ExamStartedIledaGrouping();
        sg1.setId("http://lams.metropolitan.ac.rs:8080/");
        sg1.setDefinition(new ExamStartedIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms", new ExamStartedIledaGroupingDefinitionName("LAMS")));
        grouping.add(sg1);

        ExamStartedIledaGrouping sg2 = new ExamStartedIledaGrouping();
        sg2.setId("");
        sg2.setDefinition(new ExamStartedIledaGroupingDefinitionWithExtensions("http://id.tincanapi.com/activitytype/lms/course", new ExamStartedIledaGroupingDefinitionName("IZMENAAA")));
        grouping.add(sg2);

        other.add(new ExamStartedIledaOther());
    }
}
