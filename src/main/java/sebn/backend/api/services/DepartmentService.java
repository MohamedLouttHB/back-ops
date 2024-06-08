package sebn.backend.api.services;

import sebn.backend.api.entities.Department;

import java.util.List;

public interface DepartmentService {

    Department creteDepartment(Department department);
    Department getDepartmentById(Long departmentId);
    List<Department> getAllDepartment();
    Department updateDepartment(Department department);
    void deleteDepartment(Long departmentId);

}
