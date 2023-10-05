package com.metropolitan.iledalamswrapper.lams.entities.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@AllArgsConstructor
@Getter
@Setter
public class QuestionContextActivities {
   private List<QuestionIledaGrouping> grouping = new ArrayList<>();
   private List<QuestionIledaCategory> category = Arrays.asList(new QuestionIledaCategory());

    public QuestionContextActivities() {
        QuestionIledaGrouping sg1 = new QuestionIledaGrouping();
        sg1.setId("http://lams.metropolitan.ac.rs:8080/");
        sg1.setDefinition(new QuestionIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms", new QuestionIledaGroupingDefinitionName("LAMS")));
        grouping.add(sg1);

        QuestionIledaGrouping sg2 = new QuestionIledaGrouping();
        sg2.setId("IZMENAAA");
        sg2.setDefinition(new QuestionIledaGroupingDefinitionWithExtensions("http://id.tincanapi.com/activitytype/lms/course", new QuestionIledaGroupingDefinitionName("IZMENAAA")));
        grouping.add(sg2);
    }
}
