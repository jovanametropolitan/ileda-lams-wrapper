package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedIledaGrouping {
    private String id;
    private ExamCompletedIledaGroupingDefinition definition;
    private String objectType = "Activity";
}
