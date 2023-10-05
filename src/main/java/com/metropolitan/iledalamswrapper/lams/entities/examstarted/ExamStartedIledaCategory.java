package com.metropolitan.iledalamswrapper.lams.entities.examstarted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamStartedIledaCategory {
    private String id = "http://lams.metropolitan.ac.rs:8080/";
    private ExamStartedIledaCategoryDefinition definition = new ExamStartedIledaCategoryDefinition();
    private String objectType = "Activity";
}
