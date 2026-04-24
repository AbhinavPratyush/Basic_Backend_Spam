package Spam_detection.Basic_Spam_Report.ControlLayer;

import Spam_detection.Basic_Spam_Report.DTO.SpamResponse;
import Spam_detection.Basic_Spam_Report.Service_Layer.FindingScore;
import Spam_detection.Basic_Spam_Report.Service_Layer.Reporting_Spam;
import Spam_detection.Basic_Spam_Report.repo.Spam_Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home_Controller {

    @Autowired
    Reporting_Spam rs;

    @PostMapping("/SpamReport")
    public SpamResponse report(@RequestParam("phoneNumber") String phoneNumber){
        Spam_Score s=rs.Reporting_a_number(phoneNumber);
        System.out.print(phoneNumber+"has been Reported");
        return new SpamResponse(s);
    }

    @Autowired
    FindingScore f;

    @PostMapping("/CheckScore")
    public SpamResponse whatIsTheScore(@RequestParam("phoneNumber") String phoneNumber){
        Spam_Score whatIsFound=f.FindScoreOf(phoneNumber);
        System.out.println(whatIsFound.toString());
return new SpamResponse(whatIsFound);
    }
}
