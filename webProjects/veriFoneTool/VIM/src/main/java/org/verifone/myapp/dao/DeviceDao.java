package org.verifone.myapp.dao;

import java.util.List;

import org.verifone.myapp.entity.Device;
import org.verifone.myapp.entity.DeviceType;
import org.verifone.myapp.entity.LabelAndValue;

/**
 * @author Pritpal
 */
public interface DeviceDao {
	
	
	void addDevice(Device device);
	
	List<Device> getAllFreeDevices(Device device);
	
	List<LabelAndValue> getAutoCompleteDeviceNames(String deviceName);
	
	String checkDeviceAvailibility(String deviceName);
	
	void assignDeviceToEmployee(String deviceName, String employeeName);
	
	List<Device> getDevicesToPopulateTable(int currPosition, int pageSize);
	
	List<Device> getNumberOfDevicesByCondition(DeviceType deviceType);
	
	List<Device> getDeviceByName(String device);
	
	List<Device> getDeviceByEmployee(String employee);
	
	List<Device> getMasterRecord();
	
	List<Device> getDevicesInStore(String deviceName);
	
	List<Device> getDevicesByBondNo(String bondNumber);
	
	List<Device> getNewDevices(String deviceName);
	
	void deleteDevice(String pkDevice); 

}
