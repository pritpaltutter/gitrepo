package org.verifone.myapp.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.verifone.myapp.entity.Login;
import org.verifone.myapp.service.LoginService;

@Component
public class EmployeeFormValidator implements Validator {
	
	@Autowired
	private LoginService loginService;

    @Override
    public boolean supports(Class<?> paramClass) {
        return Login.class.equals(paramClass);
    }
 
    @Override
    public void validate(Object obj, Errors errors) {

    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.required");
    	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");

    	Login login = (Login) obj;
    	boolean isValidLogin = loginService.validateLogin(login);
    	
    	if(!isValidLogin){
    		errors.rejectValue("id", "invalidLogin", new Object[]{"'id'"}, "id can't be negative");
    	}
    }
}
