package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubmissionGradedInstructor {
    private String name;
    private String mbox;
    private String objectType = "Agent";
}
