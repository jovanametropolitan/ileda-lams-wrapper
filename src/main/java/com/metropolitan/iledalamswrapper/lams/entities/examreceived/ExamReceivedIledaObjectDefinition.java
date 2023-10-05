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
public class ExamReceivedIledaObjectDefinition {
    private  String type = "http://xapi.jisc.ac.uk/activities/quiz";
    private ExamReceivedIledaObjectDefinitionName name = new ExamReceivedIledaObjectDefinitionName();
    private Map<String, String> extensions = new HashMap<>();
}
