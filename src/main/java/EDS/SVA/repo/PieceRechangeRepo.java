package EDS.SVA.repo;

import EDS.SVA.Entity.PieceRechange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PieceRechangeRepo  extends JpaRepository<PieceRechange, Long> {
    void deletePieceRechangeById(Long id);
    Optional<PieceRechange> findPieceRechangeById(Long id);
}