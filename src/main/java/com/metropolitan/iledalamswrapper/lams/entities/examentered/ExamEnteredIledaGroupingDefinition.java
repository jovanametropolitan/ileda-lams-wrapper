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
public class ExamEnteredIledaGroupingDefinition {
    private String type;
    private ExamEnteredIledaGroupingDefinitionName name;
    private Map<String, String> extensions = new HashMap<>();

    public ExamEnteredIledaGroupingDefinition(String type, ExamEnteredIledaGroupingDefinitionName name) {
    }
}
