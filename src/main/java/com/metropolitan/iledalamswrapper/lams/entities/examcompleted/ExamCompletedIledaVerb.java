package com.metropolitan.iledalamswrapper.lams.entities.examcompleted;

import com.metropolitan.iledalamswrapper.lams.entities.IledaVerbType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamCompletedIledaVerb {
    private ExamCompletedIledaDisplay display;
    private IledaVerbType id;
}
