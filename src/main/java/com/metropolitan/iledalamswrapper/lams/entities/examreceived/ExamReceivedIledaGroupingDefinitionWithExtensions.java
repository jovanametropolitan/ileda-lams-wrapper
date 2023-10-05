package com.metropolitan.iledalamswrapper.lams.entities.examreceived;


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
public class ExamReceivedIledaGroupingDefinitionWithExtensions extends ExamReceivedIledaGroupingDefinition {

    private Map<String, String> extensions = new HashMap<>();

    public ExamReceivedIledaGroupingDefinitionWithExtensions(String type, ExamReceivedIledaGroupingDefinitionName name) {
        super(type, name);
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/external-id", "test");
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
    }

}
