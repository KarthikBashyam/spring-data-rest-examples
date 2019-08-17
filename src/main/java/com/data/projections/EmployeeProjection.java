package com.data.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "employeeProjection", types = { com.demo.entity.Employee.class })
public interface EmployeeProjection {

	@Value("#{target.name},#{target.country}")
	public String getDetails();

}
