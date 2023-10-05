package com.metropolitan.iledalamswrapper.lams.entities.examreceived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ExamReceivedContextActivities {
    private List<ExamReceivedIledaGrouping> grouping = new ArrayList<>();
    private List<ExamReceivedIledaCategory> category = Arrays.asList(new ExamReceivedIledaCategory());

    public ExamReceivedContextActivities() {
        ExamReceivedIledaGrouping sg1 = new ExamReceivedIledaGrouping();
        sg1.setId("http://lams.metropolitan.ac.rs:8080/");
        sg1.setDefinition(new ExamReceivedIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms", new ExamReceivedIledaGroupingDefinitionName("LAMS")));
        grouping.add(sg1);

        ExamReceivedIledaGrouping sg2 = new ExamReceivedIledaGrouping();
        sg2.setId("IZMENAAA");
        sg2.setDefinition(new ExamReceivedIledaGroupingDefinitionWithExtensions("http://id.tincanapi.com/activitytype/lms/course", new ExamReceivedIledaGroupingDefinitionName("IZMENAAA")));
        grouping.add(sg2);
    }
}
