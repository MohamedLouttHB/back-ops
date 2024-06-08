package sebn.backend.api.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sebn.backend.api.entities.Department;
import sebn.backend.api.services.DepartmentService;

import java.util.List;


@RestController
@CrossOrigin("*")
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {
    private DepartmentService departmentService;


    // create Department endpoint
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.creteDepartment(department);
    }

    // Get Department by Id endpoint
    @GetMapping("{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    // Get All Department endpoint
    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    //Update department endpoint
    @PutMapping("{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department) {
        department.setId_department(departmentId);
        Department updatedDepartment = departmentService.updateDepartment(department);
        return updatedDepartment;
    }

    //Delete department endpoint
    @DeleteMapping("{id}")
    public void deleteDepartment(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }

}
