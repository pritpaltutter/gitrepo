package com.test.secondtest;

import java.util.Hashtable;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.test.secondtest.entity.Stock;
import com.test.secondtest.entity.StockHolder;

public class HelloClass {


	public HelloWorldService helloWorldService;
	public SessionFactory sessionFactory;


	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public HelloWorldService getHelloWorldService() {
		return helloWorldService;
	}


	@Autowired
	public void setHelloWorldService(HelloWorldService helloWorldService) {
		this.helloWorldService = helloWorldService;
	}



	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		System.out.println("Hello");


		HelloClass service = (HelloClass) context
				.getBean("helloWorldBean");



		HelloWorldService helloWorldService  = service.getHelloWorldService(); 
		String message = helloWorldService.sayHello();
		System.out.println(message);

		//set a new name
		helloWorldService.setName("Spring");
		message = helloWorldService.sayHello();
		System.out.println(message);




		System.out.println("Performing DB operations");


		Stock stock ;
		StockHolder stockHolder;
		StockHolder stockHolder2;

		Session session = service.getSessionFactory().openSession();

		session.beginTransaction();
	
		for(int i=0;i<100;i++){
			stock = new Stock();
			stockHolder = new StockHolder();
			stockHolder.setStockHolderAddress("My Address");
			stockHolder.setStockHolderName("Holder Name");

			stockHolder2 = new StockHolder();
			stockHolder2.setStockHolderAddress("My Address");
			stockHolder2.setStockHolderName("Holder Name");

			stock.setStockDescription("This is stock description");
			stock.setStockValue("This is stock value");
			stock.getStockHolder().add(stockHolder);
			stock.getStockHolder().add(stockHolder2);
			stockHolder.setStockOwned(stock);
			stockHolder2.setStockOwned(stock);
			session.save(stock);
			session.save(stockHolder);
			session.save(stockHolder2);
		}
		session.getTransaction().commit();
		session.close();
		Query query =session.createQuery("from Stock ");
		List results = query.getResultList();
		System.out.println("Result size"+results.size());
		
		


	}
}
