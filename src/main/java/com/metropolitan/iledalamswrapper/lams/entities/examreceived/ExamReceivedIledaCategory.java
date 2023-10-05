package com.metropolitan.iledalamswrapper.lams.entities.examreceived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamReceivedIledaCategory {
    private String id = "http://lams.metropolitan.ac.rs:8080/";
    private ExamReceivedIledaCategoryDefinition definition = new ExamReceivedIledaCategoryDefinition();
    private String objectType = "Activity";
}
