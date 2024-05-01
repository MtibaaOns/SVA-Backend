package EDS.SVA.repo;

import EDS.SVA.Entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FactureRepo extends JpaRepository<Facture, Long> {
    void deleteFactureById(Long id);

    Optional<Facture> findFactureById(Long id);
}