package com.metropolitan.iledalamswrapper.lams.entities.submission;

import com.metropolitan.iledalamswrapper.lams.entities.IledaVerbType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubmissionIledaVerb {
    private SubmissionIledaDisplay display;
    private IledaVerbType id;

}
