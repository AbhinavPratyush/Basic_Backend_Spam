package Spam_detection.Basic_Spam_Report.DTO;

import Spam_detection.Basic_Spam_Report.repo.Spam_Score;

public class SpamResponse {
    String phoneNumber;
    int reports;
    String status;
    double score;

    public SpamResponse(Spam_Score spamScore) {
        phoneNumber = spamScore.getPhoneNumber();
        reports= spamScore.getReports();
        status= spamScore.getStatus();
        score= spamScore.getScore();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
