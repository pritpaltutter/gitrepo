package org.verifone.myapp.service;

import java.util.List;

import org.verifone.myapp.entity.Employee;
import org.verifone.myapp.entity.LabelAndValue;

public interface EmployeeService {

	void addEmployee(Employee employee);
	
	List<LabelAndValue> getAutoCompleteEmployeeNames(String employee);
	
	void deleteEmployee(String employeeName);
	
}
