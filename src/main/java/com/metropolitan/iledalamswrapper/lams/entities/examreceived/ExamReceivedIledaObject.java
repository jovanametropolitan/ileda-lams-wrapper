package com.metropolitan.iledalamswrapper.lams.entities.examreceived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamReceivedIledaObject {
    private String id;
    private ExamReceivedIledaObjectDefinition definition = new ExamReceivedIledaObjectDefinition();
    private String objectType = "Activity";
}
