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
public class ExamStartedIledaGroupingDefinitionWithExtensions extends ExamStartedIledaGroupingDefinition{

    private Map<String, String> extensions = new HashMap<>();

    public ExamStartedIledaGroupingDefinitionWithExtensions(String type, ExamStartedIledaGroupingDefinitionName name) {
        super(type, name);
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/short-id", "test");
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
    }
}
