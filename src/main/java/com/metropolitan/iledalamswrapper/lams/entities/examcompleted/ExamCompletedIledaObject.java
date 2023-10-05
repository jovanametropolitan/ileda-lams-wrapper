package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedIledaObject {
    private String id;
    private ExamCompletedIledaObjectDefinition definition = new ExamCompletedIledaObjectDefinition();
    private String objectType = "Activity";

}
