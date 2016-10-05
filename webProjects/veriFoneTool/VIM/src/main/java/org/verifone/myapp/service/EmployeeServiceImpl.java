package org.verifone.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.verifone.myapp.dao.EmployeeDao;
import org.verifone.myapp.entity.Employee;
import org.verifone.myapp.entity.LabelAndValue;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);
	}

	@Override
	public List<LabelAndValue> getAutoCompleteEmployeeNames(String employee){
		
		return employeeDao.getAutoCompleteEmployeeNames(employee);
	}

	@Override
	public void deleteEmployee(String employeeName) {
		
		employeeDao.deleteEmployee(employeeName);
	}
	
}
