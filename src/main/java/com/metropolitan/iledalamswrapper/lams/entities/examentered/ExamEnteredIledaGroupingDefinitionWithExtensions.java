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
public class ExamEnteredIledaGroupingDefinitionWithExtensions extends ExamEnteredIledaGroupingDefinition{

    private Map<String, String> extensions = new HashMap<>();

    public ExamEnteredIledaGroupingDefinitionWithExtensions(String type, ExamEnteredIledaGroupingDefinitionName name) {
        super(type, name);
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/short-id", "test");
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
    }

}
