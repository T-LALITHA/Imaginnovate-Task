package com.imaginnovate.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imaginnovate.employee.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
