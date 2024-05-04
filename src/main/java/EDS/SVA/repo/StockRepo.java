package EDS.SVA.repo;

import EDS.SVA.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StockRepo extends JpaRepository<Stock, Long> {
}