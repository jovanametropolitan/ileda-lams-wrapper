package com.metropolitan.iledalamswrapper.lams.entities.examreceived;

import com.metropolitan.iledalamswrapper.lams.entities.IledaVerbType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamReceivedIledaVerb {
    private ExamReceivedIledaDisplay display;
    private IledaVerbType id;
}
