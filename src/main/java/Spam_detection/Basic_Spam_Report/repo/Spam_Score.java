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
    private String PhoneNumber;
    private double Score;
    private String Status;
    private int Reports;



    //This will be used by spring , info request will by handled by string only
    public Spam_Score(String phoneNumber, double score, String status, int reports) {
        PhoneNumber = phoneNumber;
        Score = score;
        Status = status;
        Reports = reports;
    }

    public int getReports() {
        return Reports;
    }

    public void setReports(int reports) {
        Reports = reports;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public double getScore() {
        return Score;
    }

    public void setScore(double score) {
        Score = score;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }



}
