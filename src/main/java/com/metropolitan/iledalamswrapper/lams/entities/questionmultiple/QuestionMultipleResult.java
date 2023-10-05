package com.metropolitan.iledalamswrapper.lams.entities.questionmultiple;

import java.util.HashMap;
import java.util.Map;

public class QuestionMultipleResult {
        private String response;

        private QuestionMultiple score = new QuestionMultiple();
        private boolean completion;
        private boolean success;
        private Map<String, Boolean> extensions = new HashMap<>();
        public QuestionMultipleResult() {
        }

        public String getResponse() {
                return response;
        }

        public void setResponse(String response) {
                this.response = response;
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

        public Map<String, Boolean> getExtensions() {
                return extensions;
        }

        public void setExtensions(Map<String, Boolean> extensions) {
                this.extensions = extensions;
        }

        public QuestionMultiple getScore() {
                return score;
        }

        public void setScore(QuestionMultiple score) {
                this.score = score;
        }
}
