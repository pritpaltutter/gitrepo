package org.verifone.myapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.verifone.myapp.entity.Device;
import org.verifone.myapp.entity.DeviceType;
import org.verifone.myapp.entity.Employee;
import org.verifone.myapp.entity.LabelAndValue;
import org.verifone.myapp.util.VIMConstants;


/**
 * @author Pritpal
 */
public class DeviceDaoImpl implements DeviceDao {
	private static final Logger logger = LoggerFactory.getLogger(DeviceDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addDevice(Device device) {
		

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(device);
		
		session.getTransaction().commit();		
		System.out.println("device inserted successfully");
		
	}

	
	@Override
	public List<Device> getAllFreeDevices(Device device) {
	
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Device> freeDevices =  new ArrayList<Device>();
		
		String AllFreeDevicesQuery  = "from Device d where d.isFree = 0"; 
		Query query = session.createQuery(AllFreeDevicesQuery);
		
		if(query.list() != null && !query.list().isEmpty()){
			freeDevices.addAll(query.list());
		}
		
		/*freeDevices
		
		session.save(device);*/
		
		session.getTransaction().commit();		
		logger.info("Device inserted successfully");
		return freeDevices;
		
	}
	
	
	public List<Device> getDeviceByName(String deviceName) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Device> devicesByDeviceName =  new ArrayList<Device>();
		
		String AllFreeDevicesQuery  = "from Device d where d.deviceName =:deviceName"; 
		
		Query query = session.createQuery(AllFreeDevicesQuery);
		query.setParameter("deviceName", deviceName);
		
		if(query.list() != null && !query.list().isEmpty()){
			devicesByDeviceName.addAll(query.list());
		}
		
		session.getTransaction().commit();		
		logger.info("GetDevice Name successfully done");
		return devicesByDeviceName;
	}

	@Override
	public List<LabelAndValue> getAutoCompleteDeviceNames(String deviceName) {

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String getAllDeviceNameQuery  = "select distinct d.deviceId ,d.deviceName from Device d where d.deviceName like ?"; 
		Query query = session.createQuery(getAllDeviceNameQuery);
		query.setParameter(0, "%"+deviceName+"%");
		List<LabelAndValue> LabelAndValues =  new ArrayList<LabelAndValue>();
	
		 
		if(query.list() != null && !query.list().isEmpty()){

         Iterator it = query.list().iterator();   
         while(it.hasNext()){
        	 
        	 Object deviceIdAndDeviceName[] = (Object[])it.next();
        	 LabelAndValue	labelAndValue =  new LabelAndValue();
        	 labelAndValue.setLabel(String.valueOf(deviceIdAndDeviceName[1]));
        	 labelAndValue.setValue(String.valueOf(deviceIdAndDeviceName[0]));
        	 LabelAndValues.add(labelAndValue);
         }
        
		}
		
		
		session.getTransaction().commit();		
		logger.info("Get All device with ID successfully done");
		return LabelAndValues;
	}

	@Override
	public String checkDeviceAvailibility(String deviceName) {
		System.out.println("inside checkDeviceAvailibility dao...");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Long numberOfFreedevice = 0L;
		System.out.println(deviceName);
		String checkDeviceAvailibilityQuery  = "select count(*) from Device d where d.deviceName=:deviceName and d.free =:isFree"; 
		
		Query query = session.createQuery(checkDeviceAvailibilityQuery);
		query.setParameter("deviceName", deviceName);
		query.setParameter("isFree", new Boolean(false));
		
		if(query.uniqueResult() != null){
			numberOfFreedevice = (Long) query.uniqueResult();
		}
		
		session.getTransaction().commit();		
		logger.info("Check device availability successfully done");
		return String.valueOf(numberOfFreedevice);
	}

	@Override
	public void assignDeviceToEmployee(String pkdevice, String pkemployee) {
		
        System.out.println("inside assignDeviceToEmployee dao...");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class, new Integer(Integer.valueOf(pkemployee)) );
		Device device = (Device) session.get(Device.class, new Integer(Integer.valueOf(pkdevice)) );
		
		device.setEmployee(employee);
		device.setFree(false);
		session.saveOrUpdate(device);
		
		session.getTransaction().commit();		
		logger.info("Assign Device To Employee successfully done");
	}

	@Override
	public List<Device> getDevicesToPopulateTable(int currPosition, int pageSize) {

		System.out.println("inside getDevicesToPopulateTable dao...");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Device> allDevices =  session.createQuery("from Device").setMaxResults(pageSize).setFirstResult(currPosition).list();

		session.getTransaction().commit();		
		System.out.println("get Devices To Populate Table done successfully");
		
		return allDevices;
	}

	@Override
	public List<Device> getNumberOfDevicesByCondition(DeviceType deviceType) {
		System.out.println("inside getNumberOfDevicesByCondition dao...");

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<Device> devices = null;
		
		switch (deviceType) {
		case ALL: 
			devices =  session.createQuery("select d from Device d").list();
			break;
		default:
			devices =  session.createQuery("select d from Device d").list();
			break;
		}

		session.getTransaction().commit();		
		logger.info("Device conditional search done");
		return devices;

	}

	@Override
	public List<Device> getDeviceByEmployee(String employeeName) {
		System.out.println("inside getDeviceByEmployee dao...");

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Device> devicesByEmployeeName =  new ArrayList<Device>();
		Employee employee = null;

		String getEmployeeQuery  = "from Employee e where e.employeeName =:employeeName"; 

		Query employeeQuery = session.createQuery(getEmployeeQuery);
		employeeQuery.setParameter("employeeName", employeeName);

		if(employeeQuery.list() != null && !employeeQuery.list().isEmpty()){
			employee = (Employee)employeeQuery.list().get(0);
			logger.info("Employee name fetched"+employee.getEmployeeName());
			String getDeviceQuery  = "from Device d where d.employee.employeeId =:employeeId"; 
			logger.info("Get Device by employee query"+getDeviceQuery);
			Query deviceQuery = session.createQuery(getDeviceQuery);
			deviceQuery.setParameter("employeeId", employee.getEmployeeId());
			if(deviceQuery.list() != null && !deviceQuery.list().isEmpty()){
				devicesByEmployeeName.addAll(deviceQuery.list());
				logger.info("Device is not null"+devicesByEmployeeName.size());
			}else{
				logger.info("No Devices found");
				return null;
			}
		}
		logger.info("Get Device by Employee search done successfully");
		return devicesByEmployeeName;
	}

	@Override
	public void deleteDevice(String pkDevice) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("delete Device d where d.deviceId = :pkDevice");
		query.setParameter("pkDevice", new Integer(pkDevice));
		int result = query.executeUpdate();
		session.getTransaction().commit();		
		logger.info("Deleting device done");
	}

	@Override
	public List<Device> getMasterRecord() {
		logger.info("Inside getMasterRecords");
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		logger.info("Executing Master Record Query");
		Query query = session.createQuery("from Device");
		logger.info("Executed");
		List<Device> allDevicesList =   new ArrayList<Device>();
		allDevicesList.addAll(query.list());
		logger.info("112");
		logger.info("allDevicesList size"+allDevicesList.size());
		session.getTransaction().commit();		
		logger.info("Master record fetch done");

		return allDevicesList;

	}

	@Override
	public List<Device> getDevicesInStore(String deviceName) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String getDeviceInStoreQuery  = null;
		if(deviceName == null || deviceName.trim().length()==0){
			getDeviceInStoreQuery = "from Device d where d.employee.employeeId ="+VIMConstants.getInstoreemployeeid();
		}
		else {
			getDeviceInStoreQuery = "from Device d where d.employee.employeeId ="+VIMConstants.getInstoreemployeeid()+ "and d.devicename =:deviceName";
		}
		Query query = session.createQuery(getDeviceInStoreQuery);
		query.setParameter("deviceName", deviceName);
		List<Device> allDevicesList =    new ArrayList<Device>();
		allDevicesList.addAll(query.list());


		session.getTransaction().commit();		

		logger.info("InStore Device fetch done");

		return allDevicesList;
	}

	@Override
	public List<Device> getDevicesByBondNo(String bondNumber) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String getDeviceInStoreQuery  = "from Device where bondnumber =:bondNumber"; 
		Query query = session.createQuery(getDeviceInStoreQuery);
		query.setParameter("bondNumber", bondNumber);
		List<Device> devicesList =   new ArrayList<Device>();
		devicesList.addAll(query.list());
		session.getTransaction().commit();		
		logger.info("Get devices by bond number done");
		return devicesList;
	}

	@Override
	public List<Device> getNewDevices(String deviceName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		String getNewDeviceQuery  = null;
		Query query = null;
		if(deviceName == null || deviceName.trim().length()==0){
			getNewDeviceQuery = "from Device where isnew = 't'";
			query = session.createQuery(getNewDeviceQuery);
		}
		else {
			getNewDeviceQuery = "from Device where  isnew= 't' and devicename =:deviceName";
			query = session.createQuery(getNewDeviceQuery);
			query.setParameter("deviceName", deviceName);
		}
		List<Device> allDevicesList =  new ArrayList<Device>();
		allDevicesList.addAll(query.list());
		session.getTransaction().commit();		
		logger.info("Get New devices fetch done");
		return allDevicesList;
	}
}
