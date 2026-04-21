package Spam_detection.Basic_Spam_Report.Service_Layer;

import Spam_detection.Basic_Spam_Report.repo.Spam_Score_impl;
import Spam_detection.Basic_Spam_Report.repo.Spam_request_impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Reporting_Spam {
    @Autowired
    Spam_request_impl SpamReport;
    @Autowired
    Spam_Score_impl SpamScore;

    public void Reporting_a_number()
}
