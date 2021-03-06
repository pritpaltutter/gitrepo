package org.verifone.myapp;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.verifone.myapp.entity.Login;
import org.verifone.myapp.service.LoginService;



/**
 * @author Pritpal
 */


/**
 * Handles requests for the application home page.
 */


@Controller
public class HomeController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
    @Qualifier("employeeValidator")
    private Validator validator;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		model.addAttribute("login",new Login());	
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("login")@Validated Login login,BindingResult bindingResult,Model model) {
		
		if (bindingResult.hasErrors()) {
            logger.info("Returning to login.jsp page");
            return "login";
        }
		
		boolean isValidLogin = loginService.validateLogin(login);	
		if(isValidLogin){
			return "home";
		}	
		return "home";
	}
	
	
	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	
}
