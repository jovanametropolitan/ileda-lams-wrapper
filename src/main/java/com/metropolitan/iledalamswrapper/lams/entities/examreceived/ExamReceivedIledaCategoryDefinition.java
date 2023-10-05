package com.metropolitan.iledalamswrapper.lams.entities.examreceived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamReceivedIledaCategoryDefinition {
    private String type = "http://id.tincanapi.com/activitytype/source";
    private ExamReceivedIledaCategoryDefinitionName name = new ExamReceivedIledaCategoryDefinitionName();
}
