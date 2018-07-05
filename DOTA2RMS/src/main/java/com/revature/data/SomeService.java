package com.revature.data;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeService {
	
	private SessionFactory hibernateFactory;
	
	@Autowired
	  public SomeService(EntityManagerFactory factory) {
	    if(factory.unwrap(SessionFactory.class) == null){
	      throw new NullPointerException("factory is not a hibernate factory");
	    }
	    this.hibernateFactory = factory.unwrap(SessionFactory.class);
	  }
}
