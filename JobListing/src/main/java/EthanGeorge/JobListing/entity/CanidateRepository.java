
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
public interface CanidateRepository extends JpaRepository<Canidates, Integer>{
    
    @Modifying
    @Query("update Canidates b set b.canidatesName = ?1, b.canidateSurname = ?2, b.canidateJob = ?3, b.canidateField = ?4")
    public Integer update(String canidatesName, String canidateSurname, String canidateJob, String canidateField);

    public Canidates save(BatchProperties.Canidates canidate);
}
