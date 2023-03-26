package org.example;

import java.util.List;

public class Model {
    public Boolean success;
    public String message;
    public List<JobDetail> jobsDetails;

    public static class JobDetail{
        public String jobName;
    }
}
