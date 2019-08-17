package com.data.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.demo.entity.Employee;

@Projection(name = "employeeFmt", types = { Employee.class })
public interface EmployeeFormatProjection {

	@Value("#{target.id}, #{target.name}, #{target.country}")
	public String getEmployeeDetails();

}
