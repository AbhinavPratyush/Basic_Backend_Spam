package Spam_detection.Basic_Spam_Report.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Spam_Score_impl extends MongoRepository<Spam_Score,String> {
}
