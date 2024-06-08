package sebn.backend.api.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sebn.backend.api.Repositories.DepartmentRepository;
import sebn.backend.api.entities.Department;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
    private DepartmentRepository departmentRepository;

    @Override
    public Department creteDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId){
        Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
        return optionalDepartment.orElse(null);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Department department) {
        Department existingDepartment = departmentRepository.findById(department.getId_department()).get();
        existingDepartment.setName_department(department.getName_department());
        Department updatedDepartment = departmentRepository.save(existingDepartment);
        return updatedDepartment;
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

}
