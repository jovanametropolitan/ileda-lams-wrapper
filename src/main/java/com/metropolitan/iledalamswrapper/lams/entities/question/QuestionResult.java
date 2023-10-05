package com.metropolitan.iledalamswrapper.lams.entities.question;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionResult {
    private String response;
    private boolean completion;
    private boolean success;
    private Map<String, Boolean> extensions = new HashMap<>();

}
