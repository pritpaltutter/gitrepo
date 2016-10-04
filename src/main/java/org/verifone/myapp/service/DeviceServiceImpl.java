package org.verifone.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.verifone.myapp.dao.DeviceDao;
import org.verifone.myapp.entity.Device;
import org.verifone.myapp.entity.DeviceType;
import org.verifone.myapp.entity.LabelAndValue;

/**
 * @author Pritpal
 */
public class DeviceServiceImpl implements DeviceService{
	
	@Autowired
	private DeviceDao deviceDao;

	public DeviceDao getDeviceDao() {
		return deviceDao;
	}

	public void setDeviceDao(DeviceDao deviceDao) {
		this.deviceDao = deviceDao;
	}

	@Override
	public void addDevice(Device device) {
	
		deviceDao.addDevice(device);
		
	}

	@Override
	public List<LabelAndValue> getAutoCompleteDeviceNames(String deviceName){
		
		return deviceDao.getAutoCompleteDeviceNames(deviceName);
	}

	@Override
	public String checkDeviceAvailibility(String deviceName) {
		
		return deviceDao.checkDeviceAvailibility(deviceName);
	}

	@Override
	public void assignDeviceToEmployee(String pkdevice, String pkemployee) {
	
		 deviceDao.assignDeviceToEmployee(pkdevice, pkemployee);
	}

	@Override
	public List<Device> getDevicesToPopulateTable(int currPosition, int pageSize) {
		
		return deviceDao.getDevicesToPopulateTable(currPosition, pageSize);
	}

	@Override
	public List<Device> getNumberOfDevicesByCondition(DeviceType deviceType) {
		
		return deviceDao.getNumberOfDevicesByCondition(deviceType);
	}

	@Override
	public List<Device> getDeviceByName(String device) {
		
		return deviceDao.getDeviceByName(device);
	}

	@Override
	public List<Device> getDeviceByEmployee(String employee) {
		return deviceDao.getDeviceByEmployee(employee);
	}

	@Override
	public void deleteDevice(String pkDevice) {
		
     deviceDao.deleteDevice(pkDevice);
	}

	@Override
	public List<Device> getMasterRecord() {
		// TODO Auto-generated method stub
		return deviceDao.getMasterRecord();
	}

	@Override
	public List<Device> getDevicesInStore(String deviceName) {
		// TODO Auto-generated method stub
		return deviceDao.getDevicesInStore(deviceName);
	}

	@Override
	public List<Device> getDevicesByBondNo(String bondNumber) {
		// TODO Auto-generated method stub
		return deviceDao.getDevicesByBondNo(bondNumber);
	}

	@Override
	public List<Device> getNewDevices(String deviceName) {
		// TODO Auto-generated method stub
		return deviceDao.getNewDevices(deviceName);
	}
	
	
}
