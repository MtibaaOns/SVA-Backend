package EDS.SVA.repo;
import EDS.SVA.Entity.client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface clientRepo extends JpaRepository<client,Long> {
    void deleteClientById(Long id);
    Optional<client> findClientById(Long id);
}


