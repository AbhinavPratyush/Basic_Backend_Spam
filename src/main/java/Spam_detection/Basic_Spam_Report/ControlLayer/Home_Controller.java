package Spam_detection.Basic_Spam_Report.ControlLayer;

import Spam_detection.Basic_Spam_Report.Service_Layer.FindingScore;
import Spam_detection.Basic_Spam_Report.Service_Layer.Reporting_Spam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home_Controller {

    @Autowired
    Reporting_Spam rs;

    @PostMapping("/SpamReport")
    public String report(@RequestParam("phoneNumber") String phoneNumber){
        rs.Reporting_a_number(phoneNumber);
        System.out.print(phoneNumber+"has been Reported");
        return "Sucessfull.html";
    }

    @Autowired
    FindingScore f;

    @PostMapping("/CheckScore")
    public String whatIsTheScore(@RequestParam("phoneNumber") String phoneNumber){
        String whatIsFound=f.FindScoreOf(phoneNumber);
        System.out.println(whatIsFound);
return "";
    }
}
