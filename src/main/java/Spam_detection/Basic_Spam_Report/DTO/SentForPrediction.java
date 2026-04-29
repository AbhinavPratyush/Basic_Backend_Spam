package Spam_detection.Basic_Spam_Report.DTO;

public class SentForPrediction {
    String message;

    public SentForPrediction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
