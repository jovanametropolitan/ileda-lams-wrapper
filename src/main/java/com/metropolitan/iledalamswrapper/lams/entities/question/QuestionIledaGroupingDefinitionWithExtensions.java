package com.metropolitan.iledalamswrapper.lams.entities.question;


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
public class QuestionIledaGroupingDefinitionWithExtensions extends QuestionIledaGroupingDefinition {

    private Map<String, String> extensions = new HashMap<>();

    public QuestionIledaGroupingDefinitionWithExtensions(String type, QuestionIledaGroupingDefinitionName name) {
        super(type, name);
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/external-id", "test");
        extensions.put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
    }
}
