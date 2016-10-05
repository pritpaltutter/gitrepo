package org.verifone.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.verifone.myapp.dao.LoginDao;
import org.verifone.myapp.entity.Login;

public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginDao loginDao;
	
	@Override
	public boolean validateLogin(Login login) {
	
		return loginDao.validateLogin(login);
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

}
