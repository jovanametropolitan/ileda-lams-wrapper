package com.metropolitan.iledalamswrapper.lams.entities.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionIledaCategory {
    private String id = "http://lams.metropolitan.ac.rs:8080/";
    private QuestionIledaCategoryDefinition definition = new QuestionIledaCategoryDefinition();
    private String objectType = "Activity";
}
