package EthanGeorge.JobListing.entity;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



/**
 *
 * @author Ethan
 */
@Repository
public interface JobRepository extends JpaRepository<Jobs, Integer>{
    
    @Modifying
    @Query("update Jobs b set b.jobName = ?1, b.jobDescription = ?2, b.jobRequirements = ?3, b.jobField = ?4")
    public Integer update(String jobName, String jobDescription, String jobRequirements, String jobField);

    public Jobs save(BatchProperties.Job job);
}
