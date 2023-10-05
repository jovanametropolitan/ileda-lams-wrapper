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
public class QuestionIledaGroupingDefinition {
    private String type;
    private QuestionIledaGroupingDefinitionName name;
    private Map<String, String> extensions = new HashMap<>();

    public QuestionIledaGroupingDefinition(String type, QuestionIledaGroupingDefinitionName name) {
        this.type = type;
        this.name = name;
    }
}
