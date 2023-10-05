package com.metropolitan.iledalamswrapper.lams.entities;

public enum IledaVerbType {
    LOGGED_IN("https://brindlewaye.com/xAPITerms/verbs/loggedin"),
    LOGGED_OUT("https://brindlewaye.com/xAPITerms/verbs/loggedout/"),
    SUBMISSION_COMPLETED("http://adlnet.gov/expapi/verbs/completed"),

    SUBMISSION_SCORED("http://adlnet.gov/expapi/verbs/scored"),

    EXAM_ENTERED("http://id.tincanapi.com/verb/viewed"),

    EXAM_START("http://activitystrea.ms/schema/1.0/start"),

    EXAM_RECEIVED("http://activitystrea.ms/schema/1.0/receive"),
    ANSWERED("http://adlnet.gov/expapi/verbs/answered"),

    COMPLETED("http://adlnet.gov/expapi/verbs/completed");

    private String displayName;

    IledaVerbType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
