package org.verifone.myapp.util;

import org.verifone.myapp.entity.Employee;

public class VIMConstants {
	
	
private static Employee inStoreEmp ;
private static  final int inStoreEmployeeID = 1;


private static  final String inStoreEmpName = "Store";

static{
	inStoreEmp = new Employee();
	inStoreEmp.setEmployeeId(inStoreEmployeeID);
	inStoreEmp.setEmployeeName(inStoreEmpName);
	inStoreEmp.setEmployeeCubicalNumber("0");
}


public static Employee getStore() {
	return inStoreEmp;
}


public static int getInstoreemployeeid() {
	return inStoreEmployeeID;
}


public static String getInStoreEmpName(){
	return inStoreEmpName;
}
}
