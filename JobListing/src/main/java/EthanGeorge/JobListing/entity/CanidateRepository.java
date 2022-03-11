
package EthanGeorge.JobListing.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Ethan George
 */
public interface CanidateRepository extends JpaRepository<Canidates, Integer>{
    
    @Modifying
    @Query("update Canidates b set b.canidateName = ?1, b.canidateSurname = ?2, b.canidateJob = ?3, b.canidateField = ?4")
    public Integer update(String canidateName, String canidateSurname, String canidateJob, String canidateField);

    public Canidates save(Canidates canidate);
}
