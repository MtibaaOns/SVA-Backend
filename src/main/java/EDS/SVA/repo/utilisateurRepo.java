package EDS.SVA.repo;

import EDS.SVA.Entity.utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface utilisateurRepo extends JpaRepository<utilisateur, Long> {

    Optional<utilisateur> findUtilisateurById(Long id);

    void deleteUtilisateurById(Long id);
}
