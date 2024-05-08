package EDS.SVA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import EDS.SVA.Entity.Interv_piece;
import java.util.Optional;
public interface IntervPieceRepo extends JpaRepository<Interv_piece, Long> {
    void deleteIntervPieceById(Long id);
    Optional<Interv_piece> findIntervPieceById(Long id);
}