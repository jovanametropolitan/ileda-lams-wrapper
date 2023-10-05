package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

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
public class ExamCompletedIledaObjectDefinition {
    private  String type = "http://adlnet.gov/expapi/activities/assessment";
    private ExamCompletedIledaObjectDefinitionName name = new ExamCompletedIledaObjectDefinitionName();
    private Map<String, String> extensions = new HashMap<>();
}
