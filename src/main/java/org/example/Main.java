package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;


public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"success\": true,\"message\": \"successfully fetched all jobs\",\"jobsDetails\":[{\"jobName\":\"" +
                "RedshiftInputControl\", \"jobDetails\":\"Details1\"},{\"jobName\":\"RedhisftAccountLevel\", " +
                "\"jobDetails\":\"Details2\"},{\"jobName\":\"GoodDataProvisioning\", \"jobDetails\":\"Details3\"}]}";
        JsonMap jsonMap = new JsonMap();
        Model model = jsonMap.JsonMaper(json);

        System.out.println("Success: " + model.success);
        System.out.println("Message: " + model.message);
        for (int i = 0; i < model.jobDetailList.size(); i++) {
            System.out.println(i + " job name: " + model.jobDetailList.get(i).jobName);
        }

    }

}
