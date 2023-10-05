package com.metropolitan.iledalamswrapper.lams.entities.examstarted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamStartedIledaObject {
    private String id;
    private ExamStartedIledaObjectDefinition definition = new ExamStartedIledaObjectDefinition();
    private String objectType = "Activity";
}
