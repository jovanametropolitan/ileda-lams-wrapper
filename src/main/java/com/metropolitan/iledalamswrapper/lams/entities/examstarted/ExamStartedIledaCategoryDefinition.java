package com.metropolitan.iledalamswrapper.lams.entities.examstarted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamStartedIledaCategoryDefinition {
    private String type = "http://id.tincanapi.com/activitytype/source";
    private ExamStartedIledaCategoryDefinitionName name = new ExamStartedIledaCategoryDefinitionName();
}
