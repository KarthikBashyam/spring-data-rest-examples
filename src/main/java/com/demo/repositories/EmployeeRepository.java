package com.demo.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.data.projections.EmployeeProjection;
import com.demo.entity.Employee;

/**
 * 
 * Rest API can be accessed using the below URL http://localhost:8000/employees
 * http://localhost:8000/employees/search/findEmployeeById?id=1
 * http://localhost:8000/employees/search/findById?id=1&projection=employeeProjection
 * 
 * @author Karthik
 *
 */
@RepositoryRestResource(excerptProjection = EmployeeProjection.class)
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@RestResource(path = "findById")
	public Employee findEmployeeById(@Param("id") Long id);

	public Employee findEmployeeByName(@Param("name") String name);

	@RestResource(path = "findBySalaryAbove")
	public List<Employee> findEmployeeBySalaryGreaterThan(@Param("salary") BigDecimal salary);

	@Query("SELECT e from Employee e")
	public List<Employee> findAll();

}
