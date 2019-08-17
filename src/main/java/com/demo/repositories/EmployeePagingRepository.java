package com.demo.repositories;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.demo.entity.Employee;

/**
 * 
 * http://localhost:8000/api?page=0&sort=name,asc
 * 
 * @author Karthik
 *
 */
@RepositoryRestResource(path = "/api")
public interface EmployeePagingRepository extends PagingAndSortingRepository<Employee, Long> {

	public List<Employee> findById(Pageable p);

}
