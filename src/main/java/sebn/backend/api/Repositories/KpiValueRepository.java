package sebn.backend.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sebn.backend.api.entities.KpiValue;

public interface KpiValueRepository extends JpaRepository<KpiValue, Long> {
}
