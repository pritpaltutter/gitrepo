package org.verifone.myapp.service;

import java.util.List;

import org.verifone.myapp.entity.Device;
import org.verifone.myapp.entity.DeviceType;
import org.verifone.myapp.entity.LabelAndValue;


/**
 * @author Pritpal
 */
public interface DeviceService {

	void addDevice(Device device);
	
	List<LabelAndValue> getAutoCompleteDeviceNames(String deviceName);
	
	String checkDeviceAvailibility(String deviceName);
	
	void assignDeviceToEmployee(String pkdevice, String pkemployee);
	
	List<Device> getDevicesToPopulateTable(int currPosition, int pageSize);
	
	List<Device> getNumberOfDevicesByCondition(DeviceType deviceType);
	
	List<Device> getDeviceByName(String device);
	
	List<Device> getDeviceByEmployee(String employee);
	
	List<Device> getMasterRecord();
	
	List<Device> getDevicesInStore(String deviceName);
	
	List<Device> getDevicesByBondNo(String bondNumber);
	
	List<Device>  getNewDevices(String deviceName);
	
	

	
	void deleteDevice(String pkDevice); 
}
