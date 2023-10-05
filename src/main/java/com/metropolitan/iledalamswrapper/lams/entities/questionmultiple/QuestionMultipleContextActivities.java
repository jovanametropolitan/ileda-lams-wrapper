package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class QuestionMultipleContextActivities {
    private List<QuestionMultipleIledaGrouping> grouping = new ArrayList<>();
    private List<QuestionMultipleMultipleIledaCategory> category = Arrays.asList(new QuestionMultipleMultipleIledaCategory());

    public QuestionMultipleContextActivities() {
        QuestionMultipleIledaGrouping sg1 = new QuestionMultipleIledaGrouping();
        sg1.setId("http://lams.metropolitan.ac.rs:8080/");
        sg1.setDefinition(new QuestionMultipleIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms", new QuestionMultipleIledaGroupingDefinitionName("LAMS")));
        grouping.add(sg1);

        QuestionMultipleIledaGrouping sg2 = new QuestionMultipleIledaGrouping();
        sg2.setId("IZMENAAA");
        sg2.setDefinition(new QuestionMultipleIledaGroupingDefinitionWithExtensions("http://id.tincanapi.com/activitytype/lms/course", new QuestionMultipleIledaGroupingDefinitionName("IZMENAAA")));
        grouping.add(sg2);
    }
}
