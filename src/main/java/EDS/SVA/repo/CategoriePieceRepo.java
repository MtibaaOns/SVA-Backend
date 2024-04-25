package EDS.SVA.repo;

import EDS.SVA.Entity.CategoriePiece;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoriePieceRepo extends JpaRepository<CategoriePiece, String> {
    void deleteCategoriePieceById(Long id);
    Optional<CategoriePiece> findCategoriePieceById(Long id);
}