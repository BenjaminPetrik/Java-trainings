import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.JsonMap;
import org.example.Model;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test()
public class SampleTest {

    public void myFirstTest() throws JsonProcessingException {
        String json = """
                {"success": true,
                "message": "successfully fetched all jobs",
                "jobsDetails":
                [{"jobName":"JobNameOne", "jobDetails":"Details1"},
                {"jobName":"JobNameTwo", "jobDetails":"Details2"},
                {"jobName":"JobNameThree", "jobDetails":"Details3"}]}""";
        JsonMap jsonMap = new JsonMap();
        Model model = jsonMap.JsonMaper(json);
        String expMessage = "successfully fetched all jobs";
        String[] expJobsArr = {"JobNameOne", "JobNameTwo", "JobNameThree"};
//        Creating new list and changing type just for training purpose.
//        List<String> expList1 = Arrays.asList("JobNameOn", "JobNameTwo", "JobNameThree");
//        List<String> actJobsList = model.jobsDetails.stream().map(x -> x.jobName).toList();
        SoftAssert softAssert = new SoftAssert();
        Assert.assertTrue(model.success, "Failed. No success message.");
        Assert.assertEquals(model.message, expMessage);
        System.out.println("===============");
        for (String s : expJobsArr) {
            softAssert.assertTrue(model.jobsDetails.stream().map(x -> x.jobName).toList().contains(s),
                    "\"" + s + "\" job is not found!");
            System.out.println("Expected job: " + s);
        }
        System.out.println("===============");
        softAssert.assertAll();

        System.out.printf("JSON:\n%s", json);
        System.out.println("\n===============");
        System.out.printf("Success: %b\nMessage: %s\nActual jobs list: %s",
                model.success, expMessage, model.jobsDetails.stream().map(x -> x.jobName).toList());
    }

}