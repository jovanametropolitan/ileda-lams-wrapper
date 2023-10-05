package com.metropolitan.iledalamswrapper.lams.entities.examstarted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamStartedIledaOther {
    private String id;
    private ExamStartedIledaGroupingDefinition definition = new ExamStartedIledaGroupingDefinition("http://adlnet.gov/expapi/activities/attempt",
            new ExamStartedIledaGroupingDefinitionName("Attempt"));
    private String objectType = "Activity";
}
