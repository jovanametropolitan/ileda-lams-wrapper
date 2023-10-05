package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedResult {
    private ExamCompletedResultScore score = new ExamCompletedResultScore();
    private boolean completion = true;
    private boolean success = true;
    private String duration = "PT8S";
}
