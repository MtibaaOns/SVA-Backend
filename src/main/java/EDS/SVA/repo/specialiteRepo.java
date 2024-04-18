package EDS.SVA.repo;

import EDS.SVA.Entity.specialite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface specialiteRepo extends JpaRepository<specialite,Integer> {
    void deleteSpecialiteByCodeSpec(Integer codeSpec);
    Optional<specialite> findSpecialiteBycodeSpec(Integer codeSpec);
}
