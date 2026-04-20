package Spam_detection.Basic_Spam_Report.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Spam_request_impl extends MongoRepository<Spam_request, String> {
}
