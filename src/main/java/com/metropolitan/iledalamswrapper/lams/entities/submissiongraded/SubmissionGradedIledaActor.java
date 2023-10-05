package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

public class SubmissionGradedIledaActor {
    private String name;
    private String mbox;

    public SubmissionGradedIledaActor() {
    }

    public SubmissionGradedIledaActor(String name, String mbox) {
        this.name = name;
        this.mbox = mbox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMbox() {
        return mbox;
    }

    public void setMbox(String mbox) {
        this.mbox = mbox;
    }
}
