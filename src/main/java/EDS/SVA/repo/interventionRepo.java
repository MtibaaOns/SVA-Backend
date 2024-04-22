package EDS.SVA.repo;
import EDS.SVA.Entity.intervention;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface interventionRepo  extends JpaRepository<intervention,Long> {
    void deleteInterventionByCodeinterv(Long codeinterv);
    Optional<intervention> findInterventionByCodeinterv(Long codeinterv);
}

