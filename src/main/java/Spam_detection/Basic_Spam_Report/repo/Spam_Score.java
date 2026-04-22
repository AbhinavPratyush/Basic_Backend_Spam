package Spam_detection.Basic_Spam_Report.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Spam_Score")
public class Spam_Score {
    /*
    * This collection is used to update if necessary post the Spam score
    * This will used to check weather the phone no is spam or not
    * This will also be used by service layer , in case of a new number reported
    * it will be posted in collection
    * in case of already existing number is reported then the spam scored will be updated
    *
    * It is used for pull and push the data in db
    *
    * Attributes;
    * (Id) PhoneNo->String->It should be same as spam_req to maintain consistency
    * Score->double->calculated by a formula
    * Status->String->{Not Spam, Likely Spam, Spam, High Risk};calculated by score
    * Reports->int->Number of requests
    *
    * */

    @Id
    private String phoneNumber;
    private double score;
    private String status;
    private int reports;


    public Spam_Score() {

    }

    //This will be used by spring , info request will by handled by string only
    public Spam_Score(String phoneNumber, double score, String status, int reports) {
        this.phoneNumber = phoneNumber;
        this.score = score;
        this.status = status;
        this.reports = reports;
    }

    public int getReports() {
        return reports;
    }

    public void setReports(int reports) {
        this.reports = reports;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



}
