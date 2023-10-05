package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedIledaOther {
    private String id;
    private ExamCompletedIledaGroupingDefinition definition = new ExamCompletedIledaGroupingDefinition("http://adlnet.gov/expapi/activities/attempt",
            new ExamCompletedIledaGroupingDefinitionName("Attempt"));
    private String objectType = "Activity";
}
