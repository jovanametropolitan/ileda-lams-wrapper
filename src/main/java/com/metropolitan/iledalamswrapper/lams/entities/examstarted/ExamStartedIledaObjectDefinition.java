package com.metropolitan.iledalamswrapper.lams.entities.examstarted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamStartedIledaObjectDefinition {
    private  String type = "http://adlnet.gov/expapi/activities/assessment";
    private ExamStartedIledaObjectDefinitionName name = new ExamStartedIledaObjectDefinitionName();
    private Map<String, String> extensions = new HashMap<>();

}
