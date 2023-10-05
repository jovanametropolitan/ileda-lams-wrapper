package com.metropolitan.iledalamswrapper.lams.entities.submissiongraded;

public class SubmissionGradedResults {
    private SubmissionGradedScore score = new SubmissionGradedScore();
    private boolean completion = true;
    private boolean success = true;
    private String response = "Completed practice";

    public SubmissionGradedResults() {
    }

    public SubmissionGradedResults(SubmissionGradedScore score, boolean completion, boolean success, String response) {
        this.score = score;
        this.completion = completion;
        this.success = success;
        this.response = response;
    }

    public SubmissionGradedScore getScore() {
        return score;
    }

    public void setScore(SubmissionGradedScore score) {
        this.score = score;
    }

    public boolean isCompletion() {
        return completion;
    }

    public void setCompletion(boolean completion) {
        this.completion = completion;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
