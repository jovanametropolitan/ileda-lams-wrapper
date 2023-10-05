package com.metropolitan.iledalamswrapper.lams.entities.question;

import com.metropolitan.iledalamswrapper.lams.entities.IledaVerbType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class QuestionIledaVerb {
    private QuestionIledaDisplay display;
    private IledaVerbType id;
}
