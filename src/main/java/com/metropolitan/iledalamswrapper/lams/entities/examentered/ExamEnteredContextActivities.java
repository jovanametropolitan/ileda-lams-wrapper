package com.metropolitan.iledalamswrapper.lams.entities.examentered;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ExamEnteredContextActivities {
    private List<ExamEnteredIledaGrouping> grouping = new ArrayList<>();
    private List<ExamEnteredIledaCategory> category = Arrays.asList(new ExamEnteredIledaCategory());

    public ExamEnteredContextActivities() {
        ExamEnteredIledaGrouping sg1 = new ExamEnteredIledaGrouping();
        sg1.setId("http://lams.metropolitan.ac.rs:8080/");
        sg1.setDefinition(new ExamEnteredIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms", new ExamEnteredIledaGroupingDefinitionName("LAMS")));
        grouping.add(sg1);

        ExamEnteredIledaGrouping sg2 = new ExamEnteredIledaGrouping();
        sg2.setId("");
        sg2.setDefinition(new ExamEnteredIledaGroupingDefinitionWithExtensions("http://id.tincanapi.com/activitytype/lms/course", new ExamEnteredIledaGroupingDefinitionName("IZMENAAA")));
        grouping.add(sg2);
    }
}
