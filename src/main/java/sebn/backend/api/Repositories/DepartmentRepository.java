package sebn.backend.api.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sebn.backend.api.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
