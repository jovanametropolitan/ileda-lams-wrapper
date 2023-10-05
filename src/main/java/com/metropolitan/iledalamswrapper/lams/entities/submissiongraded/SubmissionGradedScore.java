package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubmissionGradedScore {
    private double raw;
    private double min;
    private double max;
    private double scaled;
}
