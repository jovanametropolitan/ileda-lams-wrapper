package com.metropolitan.iledalamswrapper.lams.entities.examentered;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamEnteredIledaObject {
    private String id;
    private ExamEnteredIledaObjectDefinition definition = new ExamEnteredIledaObjectDefinition();
    private String objectType = "Activity";
}
