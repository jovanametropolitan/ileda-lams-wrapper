package com.metropolitan.iledalamswrapper.lams.entities.examentered;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamEnteredIledaCategoryDefinition {
    private String type = "http://id.tincanapi.com/activitytype/source";
    private ExamEnteredIledaCategoryDefinitionName name = new ExamEnteredIledaCategoryDefinitionName();

}
