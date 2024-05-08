package EDS.SVA.service;

import EDS.SVA.Entity.Interv_piece;
import EDS.SVA.exception.IntervPieceNotFoundException;
import EDS.SVA.repo.IntervPieceRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IntervPieceService {
    private final IntervPieceRepo intervPieceRepo;

    public IntervPieceService(IntervPieceRepo intervPieceRepo) {
        this.intervPieceRepo = intervPieceRepo;
    }

    public Interv_piece addIntervPiece(Interv_piece intervPiece) {
        return intervPieceRepo.save(intervPiece);
    }

    public List<Interv_piece> findAllIntervPieces() {
        return intervPieceRepo.findAll();
    }

    public Interv_piece updateIntervPiece(Long id, Double prixTotal, Integer quantitePiece) {
        Optional<Interv_piece> optionalIntervPiece = intervPieceRepo.findIntervPieceById(id);
        Interv_piece myIntervPiece = optionalIntervPiece.orElseThrow(() -> new IntervPieceNotFoundException("Interv_piece with id " + id + " not found"));

        myIntervPiece.setPrixTotal(prixTotal);
        myIntervPiece.setQuantitePiece(quantitePiece);
        return intervPieceRepo.save(myIntervPiece);
    }

    public Interv_piece findIntervPieceById(Long id) {
        return intervPieceRepo.findIntervPieceById(id)
                .orElseThrow(() -> new IntervPieceNotFoundException("Interv_piece with id " + id + " not found"));
    }

    public void deleteIntervPieceById(Long id) {
        intervPieceRepo.deleteIntervPieceById(id);
    }
}