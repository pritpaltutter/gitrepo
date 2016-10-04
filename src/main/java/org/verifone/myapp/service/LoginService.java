package org.verifone.myapp.service;

import org.verifone.myapp.entity.Login;

public interface LoginService {

	boolean validateLogin(Login login);
}
