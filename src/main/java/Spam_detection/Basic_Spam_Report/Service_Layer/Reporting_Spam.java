package Spam_detection.Basic_Spam_Report.Service_Layer;

import Spam_detection.Basic_Spam_Report.DTO.GotFromPrediction;
import Spam_detection.Basic_Spam_Report.DTO.SentForPrediction;
import Spam_detection.Basic_Spam_Report.DTO.SpamResponse;
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

    public Spam_Score Reporting_a_number(String PhoneNumber){
        //Clean insertion of the spam report
//        if(phoneNumberValidity(PhoneNumber)){
//            return null;
//        }
        Spam_request spamRequest=new Spam_request("SMS",PhoneNumber,"HAkoona MATata");
        SpamReport.save(spamRequest);
        Spam_Score spamScore=new Spam_Score();
        Boolean PreviousReport=true;

        spamScore = SpamScore.findByPhoneNumber(PhoneNumber);
        if(spamScore==null)
            {PreviousReport=false;}


        if(PreviousReport){
            double gf=spamScore.getScore();
            int bf=spamScore.getReports();

            spamScore.setScore(gf+(1/(Math.pow(bf,1.01)+10)));
            spamScore.setReports(bf+1);
            spamScore.setStatus(statusOfScore(spamScore.getScore()));
            SpamScore.save(spamScore);

        }
        else{
            spamScore=new Spam_Score(PhoneNumber,0.0001,"Not Spam",1);
            SpamScore.save(spamScore);
        }
        return spamScore;

    }

    private String statusOfScore(double score){
        String op="We are hacked dont belive us";
        if(score<0.5){op="theeke aadmi hai, not spam";}
        else if(score<1){op="Kuch to gadbad hai , nazar rakho, maybe scam";}
        else if (score<1.5) {
            op="Mummy jis aadmi se door rehne bolti thi yahi aadmi hai, scam";
        }
        else {
            op="vijay maalya issi se seekh ke gaya hai. Threat to humanity";
        }
        return op;
    }

    public Boolean phoneNumberValidity(String phn){
        if(phn.length()!=10 || phn.charAt(0)=='0') {
            return false;
        }
        for(int i=0; i<10;i++){
            if((int)phn.charAt(i)<=57 && (int)phn.charAt(i)>=48){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    @Autowired
    PredictionService predictionService;

    public Spam_Score Reporting_a_message(String phoneNumber, String message) {
//        if(phoneNumberValidity(phoneNumber)){
//            return null;
//        }
        Spam_request spamRequest=new Spam_request("SMS",phoneNumber,message);
        SpamReport.save(spamRequest);
/*        the spam is saved here
        now we will update the score
        we are going to call the api for our dl model here


*/
        GotFromPrediction prediction=predictionService.getPrediction(new SentForPrediction(message));
        Spam_Score spamScore= SpamScore.findByPhoneNumber(phoneNumber);
        System.out.println(prediction.toString());

        if(spamScore==null){

            spamScore=new Spam_Score(phoneNumber,prediction.getPrediction(),prediction.getLabel(),1);
        }
        else{
            spamScore.setReports(spamScore.getReports()+1);

            double gf=spamScore.getScore();
            int bf=spamScore.getReports()-1;

            spamScore.setScore(prediction.getPrediction()+gf+(1/(Math.pow(bf,1.01)+10)));


            spamScore.setStatus(statusOfScore(spamScore.getScore()));


            spamScore.setPhoneNumber(phoneNumber);

        }
        SpamScore.save(spamScore);
        return spamScore;
    }
}
