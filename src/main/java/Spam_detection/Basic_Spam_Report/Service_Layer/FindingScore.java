package Spam_detection.Basic_Spam_Report.Service_Layer;

import Spam_detection.Basic_Spam_Report.repo.Spam_Score;
import Spam_detection.Basic_Spam_Report.repo.Spam_Score_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindingScore {

    @Autowired
    Spam_Score_impl spamScoreImpl;

    public Spam_Score FindScoreOf(String phoneNumber){
        Spam_Score spamScore=spamScoreImpl.findByPhoneNumber(phoneNumber);
        if(spamScore==null){
            return "Nirdosh aadmi hai, bekaar shAQ MATT KARO";
        }

        return spamScore;

    }
}
