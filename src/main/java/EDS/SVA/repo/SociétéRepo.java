package EDS.SVA.repo;

import EDS.SVA.Entity.Société;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SociétéRepo extends JpaRepository<Société,Long> {
    void deleteSociétéById(Long id);
    Optional<Société> findSociétéById(Long id);
}

