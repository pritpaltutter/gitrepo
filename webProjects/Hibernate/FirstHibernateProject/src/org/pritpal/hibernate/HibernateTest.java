package org.pritpal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.pritpal.hibernate.dto.Address;
import org.pritpal.hibernate.dto.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {

	
		UserDetails user = new UserDetails();
		user = new UserDetails();
		user.setUserID(1);
		user.setUserName("First User");
		
		
		Address homeAddress = new Address();
		homeAddress.setCity("City");
		homeAddress.setState("Punjab");
		
		Address officeAddress = new Address();
		officeAddress.setCity("City111");
		officeAddress.setState("Punjab");
		
		
		user.getAllAddress().add(officeAddress);
		user.getAllAddress().add(homeAddress);
		
		
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		
		session.getTransaction().commit();
		session.close();


	}

}
