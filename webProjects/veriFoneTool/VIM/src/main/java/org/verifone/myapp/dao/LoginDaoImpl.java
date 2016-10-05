package org.verifone.myapp.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.verifone.myapp.entity.Login;

public class LoginDaoImpl implements LoginDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public boolean validateLogin(Login login) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String queryString = "FROM Login l where l.userName=:username and l.password=:password";
		Query query = session.createQuery(queryString);
		query.setParameter("username", login.getUserName());
		query.setParameter("password", login.getPassword());
		
		
		if(query.list() != null && query.list().size() >= 1){
			return true;
		}
		
		session.getTransaction().commit();		
		System.out.println("login validation done..");
		return false;
	}

}
