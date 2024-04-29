package EDS.SVA.repo;

import EDS.SVA.Entity.CategoriePiece;
import EDS.SVA.Entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepotRepo  extends JpaRepository<Depot, Long> {
    void deleteDepotById(Long id);
    Optional<Depot> findDepotById(Long id);
}