package com.metropolitan.iledalamswrapper.lams.entities.examstarted;

import com.metropolitan.iledalamswrapper.lams.entities.IledaVerbType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamStartedIledaVerb {
    private ExamStartedIledaDisplay display;
    private IledaVerbType id;
}
