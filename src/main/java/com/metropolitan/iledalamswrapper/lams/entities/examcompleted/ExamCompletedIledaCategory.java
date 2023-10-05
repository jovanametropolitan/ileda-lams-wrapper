package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedIledaCategory {
    private String id = "http://lams.metropolitan.ac.rs:8080/";
    private ExamCompletedIledaCategoryDefinition definition = new ExamCompletedIledaCategoryDefinition();
    private String objectType = "Activity";

}
