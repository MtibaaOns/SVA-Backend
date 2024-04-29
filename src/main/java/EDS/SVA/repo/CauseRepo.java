package EDS.SVA.repo;

import EDS.SVA.Entity.Cause;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CauseRepo extends JpaRepository<Cause, Long> {
    void deleteCauseById(Long id);
    Optional<Cause> findCauseById(Long id);
}