package Spam_detection.Basic_Spam_Report.Service_Layer;

import Spam_detection.Basic_Spam_Report.DTO.GotFromPrediction;
import Spam_detection.Basic_Spam_Report.DTO.SentForPrediction;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PredictionService {
    private final RestTemplate restTemplate=new RestTemplate();
    public GotFromPrediction getPrediction(SentForPrediction sentForPrediction){
        GotFromPrediction prediction=restTemplate.postForObject(
                "http://localhost:8000/prediction",
                sentForPrediction,
                GotFromPrediction.class
        );
        //now if i want to use the prediction data can call it here like
//        theclassinwhichiwanttouse.thefuncinwhichiwanttouse(prediction)
        return prediction;
    }
}
