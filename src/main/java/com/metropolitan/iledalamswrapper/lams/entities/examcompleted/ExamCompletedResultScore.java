package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedResultScore {
    private double raw;
    private double min;
    private double max;
    private double scaled;
}
