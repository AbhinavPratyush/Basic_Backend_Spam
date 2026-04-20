package Spam_detection.Basic_Spam_Report.repo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Timer;

@Document(collection =  "Spam_Request")
public class Spam_request {
    /*
    * The attributes of this class are named to match the column name of
    * the main collection , in docker mongodb container
    *
    *
    * Since it is the request , So,
    * (ID)PhoneNo->Type String -> It is reported Phone number(WIll get it from user)
    * TimeStamp->type time-> It will help with report frequency(Will get it from  system)
    *Type_of_scam->SMS/CALL->THe spam score will be calculated differently for both
    * (If applicable)Message->String->copy paste the message, although not compulsory
    *
    * */

    @Id
    private String PhoneNumber;
    private LocalDateTime time;
    private String type_of_scam;//Can be either Sms or call
    private String Message;

    public Spam_request(String phoneNumber, LocalDateTime time, String type_of_scam, String message) {
        PhoneNumber = phoneNumber;
        this.time = time;
        this.type_of_scam = type_of_scam;
        Message = message;
    }

    public Spam_request(String phoneNumber) {
        PhoneNumber = phoneNumber;
        time=LocalDateTime.now();
    }

    public Spam_request(String type_of_scam, String phoneNumber, String message) {
        this.type_of_scam = type_of_scam;
        PhoneNumber = phoneNumber;
        Message = message;
        time=LocalDateTime.now();
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getType_of_scam() {
        return type_of_scam;
    }

    public void setType_of_scam(String type_of_scam) {
        this.type_of_scam = type_of_scam;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
