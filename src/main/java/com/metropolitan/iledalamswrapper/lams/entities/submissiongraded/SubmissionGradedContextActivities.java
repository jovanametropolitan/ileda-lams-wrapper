package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubmissionGradedContextActivities {
   private List<SubmissionGradedIledaGrouping> grouping = new ArrayList<>();
   private List<SubmissionGradedIledaCategory> category = Arrays.asList(new SubmissionGradedIledaCategory());

    public SubmissionGradedContextActivities() {
        SubmissionGradedIledaGrouping sg1 = new SubmissionGradedIledaGrouping();
        sg1.setId("http://lams.metropolitan.ac.rs:8080/");
        sg1.setDefinition(new SubmissionGradedIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms", new SubmissionGradedIledaGroupingDefinitionName("LAMS")));
        grouping.add(sg1);

        SubmissionGradedIledaGrouping sg2 = new SubmissionGradedIledaGrouping();
        sg2.setId("IZMENAAA");
        sg2.setDefinition(new SubmissionGradedIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms/course", new SubmissionGradedIledaGroupingDefinitionName("IZMENAAA")));
        grouping.add(sg2);
    }


    public List<SubmissionGradedIledaGrouping> getGrouping() {
        return grouping;
    }

    public void setGrouping(List<SubmissionGradedIledaGrouping> grouping) {
        this.grouping = grouping;
    }

    public List<SubmissionGradedIledaCategory> getCategory() {
        return category;
    }

    public void setCategory(List<SubmissionGradedIledaCategory> category) {
        this.category = category;
    }
}
