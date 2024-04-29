package EDS.SVA.repo;


import EDS.SVA.Entity.Interventions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

    public interface InterventionsRepo  extends JpaRepository<Interventions, Long> {
    void deleteInterventionById(Long id);
    Optional<Interventions> findInterventionsById(Long id);
}
