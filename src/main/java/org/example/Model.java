package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Model {
    @JsonProperty("success")
    public Boolean success;
    @JsonProperty("message")
    public String message;
    @JsonProperty("jobsDetails")
    public List<JobDetail> jobDetailList;

    public static class JobDetail{
        @JsonProperty("jobName")
        public String jobName;
    }
}
