package sebn.backend.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sebn.backend.api.entities.KPI;

public interface KPIRepository extends JpaRepository<KPI, Long> {

}
