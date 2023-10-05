package com.metropolitan.iledalamswrapper.lams.entities.submission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubmissionContextActivities {
   private List<SubmissionIledaGrouping> grouping = new ArrayList<>();
   private List<SubmissionIledaCategory> category = Arrays.asList(new SubmissionIledaCategory());

    public SubmissionContextActivities() {
        SubmissionIledaGrouping sg1 = new SubmissionIledaGrouping();
        sg1.setId("http://lams.metropolitan.ac.rs:8080/");
        sg1.setDefinition(new SubmissionIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms", new SubmissionIledaGroupingDefinitionName("LAMS")));
        grouping.add(sg1);

        SubmissionIledaGrouping sg2 = new SubmissionIledaGrouping();
        sg2.setId("IZMENAAA");
        sg2.setDefinition(new SubmissionIledaGroupingDefinition("http://id.tincanapi.com/activitytype/lms/course", new SubmissionIledaGroupingDefinitionName("IZMENAAA")));
        grouping.add(sg2);
    }


    public List<SubmissionIledaGrouping> getGrouping() {
        return grouping;
    }

    public void setGrouping(List<SubmissionIledaGrouping> grouping) {
        this.grouping = grouping;
    }

    public List<SubmissionIledaCategory> getCategory() {
        return category;
    }

    public void setCategory(List<SubmissionIledaCategory> category) {
        this.category = category;
    }
}
