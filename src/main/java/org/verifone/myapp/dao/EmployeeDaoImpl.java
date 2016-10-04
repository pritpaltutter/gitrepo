package org.verifone.myapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.verifone.myapp.entity.Device;
import org.verifone.myapp.entity.Employee;
import org.verifone.myapp.entity.LabelAndValue;

public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void addEmployee(Employee employee) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(employee);
		
		session.getTransaction().commit();		
		System.out.println("employee inserted successfully");
		
	}

	@Override
	public List<LabelAndValue> getAutoCompleteEmployeeNames(String employee) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String employeeNames = "select e.employeeId, e.employeeName From Employee e where e.employeeName like ? ";
		Query query = session.createQuery(employeeNames);
		query.setParameter(0, "%"+employee+"%");
		
		List<LabelAndValue> LabelAndValues =  new ArrayList<LabelAndValue>();
		
		if(query.list() != null && !query.list().isEmpty()){
			
			 Iterator it = query.list().iterator();   
	         while(it.hasNext()){
	        	 
	        	 Object employeeIdAndEmployeeName[] = (Object[])it.next();
	        	 LabelAndValue	labelAndValue =  new LabelAndValue();
	        	 labelAndValue.setLabel(String.valueOf(employeeIdAndEmployeeName[1]));
	        	 labelAndValue.setValue(String.valueOf(employeeIdAndEmployeeName[0]));
	        	 LabelAndValues.add(labelAndValue);
	         }
		}
		
		session.getTransaction().commit();		
		System.out.println(" get All Devices Names with IDs successfully");
		return LabelAndValues;
	}

	@Override
	public void deleteEmployee(String employeeName) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Device> devices = new ArrayList<Device>();
		int employeeId = -1;
				
		String employeeQuery = "From Employee e where e.employeeName=:employeeName ";
		Query getemployee = session.createQuery(employeeQuery);
		getemployee.setParameter("employeeName", employeeName);
		
		if(getemployee.list() != null && !getemployee.list().isEmpty()){
			Employee employee = (Employee)getemployee.list().get(0);
			employeeId = employee.getEmployeeId();

			String getAssociatedDeviceQuery = "select * From device d where d.EmployeeId is not null and d.EmployeeId =:employeeId ";

			SQLQuery query = session.createSQLQuery(getAssociatedDeviceQuery);
			query.addEntity(Device.class);
			query.setParameter("employeeId", employeeId);
			
			
			if(query.list() != null && !query.list().isEmpty()){
				devices.addAll(query.list());
			}

			for (Iterator iterator = devices.iterator(); iterator.hasNext();){
				Device device = (Device) iterator.next(); 
				device.setEmployee(null);
				session.saveOrUpdate(device);
			}
			
			session.flush();
			

			String deleteEmployee = "delete from Employee e where e.employeeId =:employeeId ";

			Query deleteEmployeequery = session.createQuery(deleteEmployee);
			deleteEmployeequery.setParameter("employeeId", employeeId);
			deleteEmployeequery.executeUpdate();

		}

		session.getTransaction().commit();		
		System.out.println("employee deleted successfully");
	}

}
