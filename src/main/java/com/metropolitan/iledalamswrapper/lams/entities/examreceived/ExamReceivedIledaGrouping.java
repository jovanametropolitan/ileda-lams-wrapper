package com.metropolitan.iledalamswrapper.lams.entities.examreceived;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamReceivedIledaGrouping {
    private String id;
    private ExamReceivedIledaGroupingDefinition definition;
    private String objectType = "Activity";
}
