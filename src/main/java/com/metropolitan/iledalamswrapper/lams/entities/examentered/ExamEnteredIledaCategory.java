package com.metropolitan.iledalamswrapper.lams.entities.examentered;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamEnteredIledaCategory {
    private String id = "http://lams.metropolitan.ac.rs:8080/";
    private ExamEnteredIledaCategoryDefinition definition = new ExamEnteredIledaCategoryDefinition();
    private String objectType = "Activity";

}
