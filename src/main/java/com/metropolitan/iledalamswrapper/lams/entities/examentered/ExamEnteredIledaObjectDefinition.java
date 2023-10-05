package com.metropolitan.iledalamswrapper.lams.entities.examentered;

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
public class ExamEnteredIledaObjectDefinition {
    private String type = "http://xapi.jisc.ac.uk/activities/quiz";
    private ExamEnteredIledaObjectDefinitionName name = new ExamEnteredIledaObjectDefinitionName();
    private Map<String, String> extensions = new HashMap<>();

}
