package com.pradeep.samrthrportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pradeep.samrthrportal.dto.ApiResponse;
import com.pradeep.samrthrportal.dto.EmployeeRequestDTO;
import com.pradeep.samrthrportal.dto.EmployeeResponseDTO;
import com.pradeep.samrthrportal.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> createEmployee(
            @RequestBody EmployeeRequestDTO request) {

        EmployeeResponseDTO response = employeeService.createEmployee(request);

        return new ResponseEntity<>(
                new ApiResponse<>(
                    true,
                    201,
                    "Employee created successfully",
                    response
                ),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeResponseDTO>>> getAllEmployees() {

        List<EmployeeResponseDTO> employees = employeeService.getAllEmployees();

        return ResponseEntity.ok(
            new ApiResponse<>(
                    true,
                    200,
                    "Employees fetched successfully",
                    employees
            )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> getEmployeeById(
            @PathVariable Long id) {

        EmployeeResponseDTO employee = employeeService.getEmployeeById(id);

        return ResponseEntity.ok(
            new ApiResponse<>(
                    true,
                    200,
                    "Employee fetched successfully",
                    employee
            )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeRequestDTO request) {

        EmployeeResponseDTO updated = employeeService.updateEmployee(id, request);

        return ResponseEntity.ok(
            new ApiResponse<>(
                    true,
                    200,
                    "Employee updated successfully",
                    updated
            )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(
            new ApiResponse<>(
                    true,
                    200,
                    "Employee deleted successfully",
                    null
            )
        );
    }
}