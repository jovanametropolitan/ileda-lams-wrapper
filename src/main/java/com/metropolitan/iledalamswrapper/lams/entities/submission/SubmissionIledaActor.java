package com.metropolitan.iledalamswrapper.lams.entities.submission;

public class SubmissionIledaActor {
    private String name;
    private String mbox;

    public SubmissionIledaActor() {
    }

    public SubmissionIledaActor(String name, String mbox) {
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
