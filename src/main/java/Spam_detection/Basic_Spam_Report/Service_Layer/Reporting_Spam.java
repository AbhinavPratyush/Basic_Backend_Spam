package Spam_detection.Basic_Spam_Report.Service_Layer;

import Spam_detection.Basic_Spam_Report.repo.Spam_Score;
import Spam_detection.Basic_Spam_Report.repo.Spam_Score_impl;
import Spam_detection.Basic_Spam_Report.repo.Spam_request;
import Spam_detection.Basic_Spam_Report.repo.Spam_request_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Reporting_Spam {
    @Autowired
    Spam_request_impl SpamReport;
    @Autowired
    Spam_Score_impl SpamScore;

    public void Reporting_a_number(String PhoneNumber){
        //Clean insertion of the spam report
        Spam_request spamRequest=new Spam_request("SMS",PhoneNumber,"HAkoona MATata");
        SpamReport.save(spamRequest);
        Spam_Score spamScore=new Spam_Score();
        Boolean PreviousReport=true;

        spamScore = SpamScore.findByPhoneNumber(PhoneNumber);
        if(spamScore==null)
            {PreviousReport=false;}
        if(PreviousReport){
            spamScore.setScore(spamScore.getScore()*1.01);
            spamScore.setReports(spamScore.getReports()+1);
        }
        else{
            spamScore=new Spam_Score(PhoneNumber,0.01,"Not Spam",1);
        }
        SpamScore.save(spamScore);
    }
}
