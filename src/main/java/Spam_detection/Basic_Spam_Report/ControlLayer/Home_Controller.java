package Spam_detection.Basic_Spam_Report.ControlLayer;

import Spam_detection.Basic_Spam_Report.DTO.ClientToServerDTO;
import Spam_detection.Basic_Spam_Report.DTO.GotFromPrediction;
import Spam_detection.Basic_Spam_Report.DTO.SentForPrediction;
import Spam_detection.Basic_Spam_Report.DTO.SpamResponse;
import Spam_detection.Basic_Spam_Report.Service_Layer.FindingScore;
import Spam_detection.Basic_Spam_Report.Service_Layer.PredictionService;
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
    public SpamResponse report(@RequestBody ClientToServerDTO ctsd){
        Spam_Score s;
        if(ctsd.getMessage()==null){
            //then this is call spam
            s=rs.Reporting_a_number(ctsd.getPhoneNumber());
        }
        else{
            //it is an sms spam
           s=rs.Reporting_a_message(ctsd.getPhoneNumber(),ctsd.getMessage());
        }
        System.out.println(s.toString());
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

    @Autowired
    PredictionService predictionService;
    @PostMapping("/prediction")
    public GotFromPrediction APIforPython(@RequestBody SentForPrediction sentForPrediction){

        GotFromPrediction prediction=predictionService.getPrediction(sentForPrediction);
        return prediction;
    }


}
