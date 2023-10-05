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
public class ExamReceivedIledaGroupingDefinition {
    private String type;
    private ExamReceivedIledaGroupingDefinitionName name;
    private Map<String, String> extensions = new HashMap<>();

    public ExamReceivedIledaGroupingDefinition(String type, ExamReceivedIledaGroupingDefinitionName name) {
        this.type = type;
        this.name = name;
    }
}
