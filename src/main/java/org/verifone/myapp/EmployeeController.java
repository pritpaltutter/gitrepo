package org.verifone.myapp;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.verifone.myapp.entity.Device;
import org.verifone.myapp.entity.Employee;
import org.verifone.myapp.entity.LabelAndValue;
import org.verifone.myapp.entity.Login;
import org.verifone.myapp.service.DeviceService;
import org.verifone.myapp.service.EmployeeService;
import org.verifone.myapp.util.VIMConstants;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;


/**
 * @author Pritpal
 */
@Controller
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DeviceService deviceService;
	
	@RequestMapping(value = "/loadAssignDeviceToEmployeePage" , method = RequestMethod.GET)
	public String loadAssignDeviceToEmployeePage(Model model) {
		logger.info("loadAssignDeviceToEmployeePage start..");
		
			return "AssignDevToEmp";
		}
	
	@RequestMapping(value = "/loadStorePage" , method = RequestMethod.GET)
	public String loadStorePage(Model model) {
		logger.info("loadAddEmployee start..");
		
			return "store";
		}
	
	@RequestMapping(value = "/loadHomePage" , method = RequestMethod.GET)
	public String loadHomePage(Model model) {
		logger.info("loadHomePage start..");
		
			return "home";
		}

	@RequestMapping(value = "/loadLoginPage" , method = RequestMethod.GET)
	public String loadLoginPage(Model model) {
		logger.info("loadLoginPage start..");
		model.addAttribute("login",new Login());	
		return "login";
			
		}
	
	@RequestMapping(value = "/loadAddEmployeePage" , method = RequestMethod.GET)
	public String loadAddEmployeePage(Model model) {
		logger.info("loadAddEmployee start..");
		
			return "addEmp";
		}
	
	@RequestMapping(value = "/loadDeleteEmployeePage" , method = RequestMethod.GET)
	public String loadDeleteEmployeePage(Model model) {
		logger.info("loadDeleteEmployeePage start..");
		
			return "delEmp";
		}
	
	@RequestMapping(value = "/loadSearchPage" , method = RequestMethod.GET)
	public String loadSearchPage(Model model) {
		logger.info("loadSearchPage start..");
		
			return "searchPage";
		}
	
	@RequestMapping(value = "/loadAddDevicePage" , method = RequestMethod.GET)
	public String loadAddDevicePage(Model model) {
		logger.info("loadAddDevicePage start..");
		
			return "addDev";
		}
	
	@RequestMapping(value = "/loadUpdateDevicePage" , method = RequestMethod.GET)
	public String loadUpdateDevicePage(Model model) {
		logger.info("loadUpdateDevicePage start..");
		
			return "updateDev";
		}
	
	
	
	
	@RequestMapping(value = "/importExportPage" , method = RequestMethod.GET)
	public String loadImportExportPage(Model model) {
		logger.info("importExportPage start..");
		
			return "importExport";
		}
	
	@RequestMapping(value = "/adminEdit" , method = RequestMethod.GET)
	public String loadAdminEditPage(Model model) {
		logger.info("adminEditPage start..");
		
			return "adminEdit";
		}
	
	
	
	
	
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@RequestParam String employeeNameAndCubNumber, Model model) {
		
		String employeeNameAndCubNum[] = employeeNameAndCubNumber.split(";");
		String empName = employeeNameAndCubNum[0];
		String cubNumber = employeeNameAndCubNum[1];
		logger.info(empName + cubNumber);
		
		Employee employee = new Employee();
		employee.setEmployeeName(empName);
		employee.setEmployeeCubicalNumber(cubNumber);
		//employee.setAllotedDevices(devices);
		
		employeeService.addEmployee(employee);
	
		return "addEmp";
	}
	
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam String empName) {
		logger.info("deleteEmployee start.."+empName);
		
		employeeService.deleteEmployee(empName);
	
		return "delEmp";
	}
	
	
	
	@RequestMapping(value = "/deleteDevice", method = RequestMethod.GET)
	public String deleteDevice(@RequestParam String deviceNameToSearch) {
		
		
		logger.info("-------delete device-------------"+deviceNameToSearch);
		deviceService.deleteDevice(deviceNameToSearch);

		return "updateDev";
	}
	
	
	@RequestMapping(value = "/addDevice", method = RequestMethod.POST)
	public String addDevice(@RequestParam String deviceInfo, Model model) {
		
		String deviceInfoArray[] = deviceInfo.split(";");
		String deviceName = deviceInfoArray[0];
		String partName = deviceInfoArray[1];
		String serialNumber = deviceInfoArray[2];
		String bondNumber = deviceInfoArray[3];
		String bondDate = deviceInfoArray[4];
		String remark = deviceInfoArray[5];
		String additionalDescription = deviceInfoArray[6];
		
	    Device device = new Device();
	    device.setDeviceName(deviceName);
	    device.setEmployee(VIMConstants.getStore());
	    device.setPartNumber(partName);
	    device.setSerialNumber(serialNumber);
	    device.setBondNumber(bondNumber);
	    device.setBondDate(bondDate);
	    device.setRemark(remark);
	    device.setAdditionalDescription(additionalDescription);
	    device.setWork(true);
	    device.setNew(true);
	    
		deviceService.addDevice(device);
	
		return "addDev";
	}
	
	@RequestMapping(value = "/employeeAndDeviceSearch/{type}/{name}", method = RequestMethod.POST, produces={"application/xml", "application/json"})
	public @ResponseBody List<Device> springPaginationDataTables(@PathVariable String type,@PathVariable String name) throws IOException {
		
		logger.info("------------inside springPaginationDataTables TABLE..-------------------");
		logger.info(type);
		logger.info(name);
		List<Device> devices =  null;
		/*DataTableTO<Device> dataTableObjectObject = new DataTableTO<Device>();
		
		List<Device> getDevicesByPagination = deviceService.getDevicesToPopulateTable(0, 5);*/
		
		
		/*
		 * To Do add enum and switch case		
		 */
		
		
		if(type.trim().equals("master")){
			devices = deviceService.getMasterRecord();
		}else if(type.trim().equals("employee")){
			devices = deviceService.getDeviceByEmployee(name);
			
		}else if (type.trim().equals("device")) {
			
			devices = deviceService.getDeviceByName(name);
		}else if(type.trim().equals("store")){
			devices = deviceService.getDeviceByEmployee(VIMConstants.getInStoreEmpName());
		}else if(type.trim().equals("bondNo")){
			devices = deviceService.getDevicesByBondNo(name);
		}else if(type.trim().equals("new")){
				devices = deviceService.getNewDevices(name);
		}
		
		
		//todo below code is just a hack to handle json lazy objects tp populate to table
		if(devices != null && !devices.isEmpty()){
			logger.info("Some records Found");
			for (Device device : devices) {
				logger.info(device.getEmployee().toString());
			}
		}else{
			logger.info("No record found");
		}

		/*dataTableObjectObject.setAaData(getDevicesByPagination);
		dataTableObjectObject.setiTotalDisplayRecords(getallDevices.size());
		dataTableObjectObject.setiTotalRecords(getallDevices.size());
		dataTableObjectObject.setsEcho(1);*/
		
		/*ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate4Module());
		String finalJsonValue = mapper.writeValueAsString(devices);
		logger.info("-------------");
		logger.info(finalJsonValue);
		logger.info("-------------");*/
		
		
		return devices;
	}
	
	
	
	
	@RequestMapping(value = "/exportDataToFile", method = RequestMethod.POST, produces={"application/xml", "application/json"})
	public @ResponseBody String exportDataToFile(@PathVariable String type) throws IOException {
		return null;
	}
		
	
	
	/*private String toJson(DataTableTO<?> dt) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		try {
		return mapper.writeValueAsString(dt);
		} catch (JsonProcessingException e) {
		
		e.printStackTrace();
		return null;
		}
		}
	*/
	
	@RequestMapping(value = "/getAllEmployeeNames", method = RequestMethod.GET )
	public @ResponseBody String getAutoCompleteEmployeeNames(@RequestParam String term, Model model) throws JsonProcessingException {
		logger.info("------------inside getAllEmployeeNames..-------------------");
		
		List<LabelAndValue> employeeNames =  employeeService.getAutoCompleteEmployeeNames(term);
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate4Module());
		
        String jsonemployeeNames = mapper.writeValueAsString(employeeNames);
        
        logger.info(jsonemployeeNames);
		
		return jsonemployeeNames;
	}
	
	@RequestMapping(value = "/getAllDeviceNames", method = RequestMethod.GET )
	public @ResponseBody String getAutoCompleteDeviceNames(@RequestParam String term, Model model) throws JsonProcessingException  {
		
		logger.info("------------inside getAllDeviceNames..-------------------");
		
		logger.info("--------------term value is :"+term);
		List<LabelAndValue> deviceIdAndNames =  deviceService.getAutoCompleteDeviceNames(term);
	
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate4Module());
        String jsonDeviceNames = mapper.writeValueAsString(deviceIdAndNames);
        logger.info(jsonDeviceNames);
		
		return jsonDeviceNames;
	}
	
	@RequestMapping(value = "/checkDeviceAvailibity", method = RequestMethod.GET )
	public @ResponseBody String checkDeviceAvailibity(String deviceNameToSearch, Model model) {
		
		logger.info("------------inside checkDeviceAvailibity..-------------------");
		
		String NumberOfFreeDevices = deviceService.checkDeviceAvailibility(deviceNameToSearch);
		logger.info("inside checkDeviceAvailibity number of available device are :"+NumberOfFreeDevices);
		return NumberOfFreeDevices;
	}
	
	@RequestMapping(value = "/assignDeviceToEmployee", method = RequestMethod.POST )
	public String assignDeviceToEmployee(String employeeAndDevice, Model model) {
		logger.info("------------inside assignDeviceToEmployee..-------------------");
		
		String employeeAndDeviceArray[] = employeeAndDevice.split(";");
		String pkemployee = employeeAndDeviceArray[0];
		String pkdevice = employeeAndDeviceArray[1];
		
		deviceService.assignDeviceToEmployee(pkdevice, pkemployee);
		
	    logger.info("assign Device To Employee done..");
		return "AssignDevToEmp";
	}
	
	
	
	@RequestMapping(value = "/deleteEmployeePage", method = RequestMethod.POST)
	public String deleteEmployeePage(Model model) {
		
		return "delEmp";
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public DeviceService getDeviceService() {
		return deviceService;
	}

	public void setDeviceService(DeviceService deviceService) {
		this.deviceService = deviceService;
	}


}
